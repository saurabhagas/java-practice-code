package com.saurabh.conceptual.restaurant_design.infra;

import com.saurabh.conceptual.restaurant_design.order.Menu;
import com.saurabh.conceptual.restaurant_design.staff.Chef;
import com.saurabh.conceptual.restaurant_design.staff.Manager;
import com.saurabh.conceptual.restaurant_design.staff.Receptionist;
import com.saurabh.conceptual.restaurant_design.staff.Staff;
import com.saurabh.conceptual.restaurant_design.staff.Waiter;

public class Branch {
  private final String name;
  private final String phone;
  private final String email;
  private final Menu menu;
  private final Staff staff;
  private final BranchCoordinator branchCoordinator;

  public Branch(String name, String phone, String email, Menu menu, Staff staff, BranchCoordinator branchCoordinator) {
    this.name = name;
    this.phone = phone;
    this.email = email;
    this.menu = menu;
    this.staff = staff;
    this.branchCoordinator = branchCoordinator;
  }

  public String getName() {
    return name;
  }

  public String getPhone() {
    return phone;
  }

  public String getEmail() {
    return email;
  }

  public Menu getMenu() {
    return menu;
  }

  public Receptionist getReceptionist() {
    return staff.getReceptionist();
  }

  public Manager getManager() {
    return staff.getManager();
  }

  public Waiter getWaiter() {
    return staff.getWaiters().get(0);
  }

  public boolean addWaiter(Waiter waiter) {
    return staff.addWaiter(waiter);
  }

  public boolean removeWaiter(Waiter waiter) {
    return staff.removeWaiter(waiter);
  }

  public boolean addChef(Chef chef) {
    return staff.addChef(chef);
  }

  public boolean removeChef(Chef chef) {
    return staff.removeChef(chef);
  }

  public BranchCoordinator getBranchCoordinator() {
    return branchCoordinator;
  }
}
