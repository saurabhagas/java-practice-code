package com.saurabh.conceptual.restaurant_design.staff;

import com.saurabh.conceptual.restaurant_design.infra.BranchCoordinator;
import com.saurabh.conceptual.restaurant_design.infra.Table;
import com.saurabh.conceptual.restaurant_design.people.Customer;

import java.time.LocalDate;
import java.util.List;

public class Receptionist extends Employee {
  private final BranchCoordinator branchCoordinator;

  public Receptionist(String name, String email, String phone, int id, LocalDate joinedOn, BranchCoordinator branchCoordinator) {
    super(name, email, phone, id, joinedOn);
    this.branchCoordinator = branchCoordinator;
  }

  public boolean checkSeatAvailability() {
    LocalDate time = LocalDate.now();
    List<Table> availableTables = branchCoordinator.getAvailableTables(time);
    return !availableTables.isEmpty();
  }

  public Table seatCustomer(Customer customer) {
    LocalDate time = LocalDate.now();
    Table table = branchCoordinator.getAvailableTables(time).get(0);
    table.occupy(customer, time);
    return table;
  }

  public boolean placeReservation(Customer customer) {
    LocalDate time = LocalDate.now();
    List<Table> availableTables = branchCoordinator.getAvailableTables(time);
    if (availableTables.isEmpty()) return false;

    branchCoordinator.reserveTable(customer, time);
    return true;
  }
}
