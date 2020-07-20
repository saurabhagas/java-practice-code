package com.saurabh.conceptual.restaurant_design.staff;

import com.saurabh.conceptual.restaurant_design.infra.Table;
import com.saurabh.conceptual.restaurant_design.order.MenuItem;
import com.saurabh.conceptual.restaurant_design.order.Order;
import com.saurabh.conceptual.restaurant_design.payment.Bill;
import com.saurabh.conceptual.restaurant_design.payment.Payment;
import com.saurabh.conceptual.restaurant_design.payment.PaymentMode;
import com.saurabh.conceptual.restaurant_design.payment.PaymentStatus;
import com.saurabh.conceptual.restaurant_design.people.Customer;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Waiter extends Employee {
  private final List<Order> processedOrders = new ArrayList<>();

  public Waiter(String name, String email, String phone, int id, LocalDate joinedOn) {
    super(name, email, phone, id, joinedOn);
  }

  public Order takeOrder(Customer customer, List<MenuItem> items, LocalDate placedAt, Table table) {
    Order order = new Order(customer, table, items, placedAt);
    processedOrders.add(order);
    return order;
  }

  public boolean addItemsToOrder(Order order, MenuItem... items) {
    return processedOrders.stream().filter(processedOrder -> processedOrder.equals(order)).findFirst().get().addItems(items);
  }

  public Bill finishOrder(Order order, PaymentMode paymentMode) {
    double amount = order.getMenuItems().stream().mapToDouble(MenuItem::getPrice).sum();
    return new Bill(order, new Payment(amount, paymentMode));
  }

  public PaymentStatus processPayment(Bill bill) {
    return bill.pay();
  }

  public PaymentStatus revisePayment(Bill bill, PaymentMode newPaymentMode) {
    return bill.pay(newPaymentMode);
  }
}
