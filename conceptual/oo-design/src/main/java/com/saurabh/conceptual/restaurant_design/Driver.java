package com.saurabh.conceptual.restaurant_design;

import com.saurabh.conceptual.restaurant_design.infra.Branch;
import com.saurabh.conceptual.restaurant_design.infra.BranchCoordinator;
import com.saurabh.conceptual.restaurant_design.infra.Table;
import com.saurabh.conceptual.restaurant_design.order.Menu;
import com.saurabh.conceptual.restaurant_design.order.MenuItem;
import com.saurabh.conceptual.restaurant_design.order.MenuSection;
import com.saurabh.conceptual.restaurant_design.order.Order;
import com.saurabh.conceptual.restaurant_design.payment.Bill;
import com.saurabh.conceptual.restaurant_design.payment.PaymentMode;
import com.saurabh.conceptual.restaurant_design.payment.PaymentStatus;
import com.saurabh.conceptual.restaurant_design.people.Customer;
import com.saurabh.conceptual.restaurant_design.staff.Chef;
import com.saurabh.conceptual.restaurant_design.staff.Manager;
import com.saurabh.conceptual.restaurant_design.staff.Receptionist;
import com.saurabh.conceptual.restaurant_design.staff.Staff;
import com.saurabh.conceptual.restaurant_design.staff.Waiter;
import com.saurabh.source.common.IntSequenceGenerator;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.saurabh.conceptual.restaurant_design.order.MenuItem.from;
import static com.saurabh.source.common.RetryUtils.waitFor;
import static java.time.LocalDate.now;
import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;

public class Driver {
  public static void main(String[] args) {
    // Use case 0 - create restaurant with 1 branch
    List<MenuSection> menuSections = new ArrayList<>();
    MenuSection section1 = new MenuSection("Continental", asList(from("Pasta", 250), from("Pizza", 400), from("Burger", 150)));
    MenuSection section2 = new MenuSection("Oriental", asList(from("Noodles", 175), from("Stir fried rice", 230), from("Manchurian", 190)));
    MenuSection section3 = new MenuSection("Dessert", asList(from("Mousse", 120), from("Cake", 120)));
    menuSections.add(section1);
    menuSections.add(section2);
    menuSections.add(section3);

    IntSequenceGenerator empIdGenerator = new IntSequenceGenerator(0);
    BranchCoordinator branchCoordinator = new BranchCoordinator();
    Staff staff = new Staff(
        new Manager("manager-1", "manager-1@trffules.com", "080 1000 1005", empIdGenerator.next(), now()),
        new Receptionist("receptionist-1", "receptionist-1@trffules.com", "080 1000 1006", empIdGenerator.next(), now(), branchCoordinator),
        asList(
            new Waiter("waiter-1", "waiter-1@trffules.com", "080 1000 1003", empIdGenerator.next(), now()),
            new Waiter("waiter-2", "waiter-1@trffules.com", "080 1000 1004", empIdGenerator.next(), now())
        ),
        asList(
            new Chef("khansama-1", "khansama-1@trffules.com", "080 1000 1001", empIdGenerator.next(), now()),
            new Chef("khansama-2", "khansama-2@trffules.com", "080 1000 1002", empIdGenerator.next(), now())
        )
    );
    Branch branch = new Branch("MG road", "080 1234 5001", "mg-road@truffles.com", new Menu(menuSections), staff, branchCoordinator);
    new Restaurant("Truffles", "080 1234 5000", "info@truffles.com", singletonList(branch));

    IntSequenceGenerator customerIdGenerator = new IntSequenceGenerator(0);
    walkInCustomer(customerIdGenerator.next(), branch);
    reservationCustomer(customerIdGenerator.next(), branch);
  }

  private static void walkInCustomer(int id, Branch branch) {
    // Customer walks-in and asks for a table
    Customer customer = new Customer("Sooraj", "sooraj@hotmail.com", null, id);
    Receptionist receptionist = branch.getReceptionist();
    boolean isSeatAvailable = receptionist.checkSeatAvailability();
    Table table;
    if (isSeatAvailable) {
      table = receptionist.seatCustomer(customer);
    } else {
      // If seat is not available, take a reservation
      receptionist.placeReservation(customer);
      // Customer waits for max 30 minutes for a table to become available
      if (waitFor(receptionist::checkSeatAvailability, 30, TimeUnit.MINUTES)) {
        table = receptionist.seatCustomer(customer);
      } else {
        return;
      }
    }

    // Customer orders an item from the oriental section in one go
    Waiter waiter = branch.getWaiter();
    Menu menu = branch.getMenu();
    MenuItem orientalItem = menu.getSections().stream()
        .filter(menuSection -> menuSection.getSectionName().equals("Oriental"))
        .map(menuSection -> menuSection.getSectionItems().get(0))
        .findFirst()
        .get();
    List<MenuItem> items = singletonList(orientalItem);
    Order order = waiter.takeOrder(customer, items, now(), table);

    // Customer is done eating, and asks for a bill
    Bill bill = waiter.finishOrder(order, PaymentMode.CASH);

    // pays in cash and leaves
    waiter.processPayment(bill);
  }

  private static void reservationCustomer(int id, Branch branch) {
    Customer customer = new Customer("Shiva Reddy", "shiva@gmail.com", "1234567890", id);

    // Customer makes a reservation by calling the branch
    branch.getBranchCoordinator().reserveTable(customer, LocalDate.now().plusDays(1));

    // Customer later walks-in
    Receptionist receptionist = branch.getReceptionist();
    Table table = receptionist.seatCustomer(customer);

    // Customer orders a meal
    Waiter waiter = branch.getWaiter();
    Menu menu = branch.getMenu();
    List<MenuItem> continentalItems = menu.getSections().stream()
        .filter(menuSection -> menuSection.getSectionName().equals("Continental"))
        .map(MenuSection::getSectionItems)
        .findFirst()
        .get();

    Order order = waiter.takeOrder(customer, continentalItems, now(), table);

    // Customer adds dessert to his meal
    MenuItem dessertItem = menu.getSections().stream()
        .filter(menuSection -> menuSection.getSectionName().equals("Dessert"))
        .map(menuSection1 -> menuSection1.getSectionItems().get(0))
        .findFirst()
        .get();
    waiter.addItemsToOrder(order, dessertItem);

    // Customer is done eating, and asks for a bill with payment mode of card
    Bill bill = waiter.finishOrder(order, PaymentMode.CARD);

    // pays in card. wait for 5 minutes for the transaction to clear. Pays with cash otherwise
    PaymentStatus paymentStatus = waiter.processPayment(bill);
    if (!waitFor(() -> paymentStatus == PaymentStatus.PAID, 5, TimeUnit.MINUTES)) {
      waiter.revisePayment(bill, PaymentMode.CASH);
    }
  }
}
