package com.saurabh.conceptual.restaurant_design.order;

import com.saurabh.conceptual.restaurant_design.infra.Table;
import com.saurabh.conceptual.restaurant_design.people.Customer;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

public class Order {
  private final Customer customer;
  private final Table table;
  private final List<MenuItem> menuItems;
  private final LocalDate placedAt;

  public Order(Customer customer, Table table, List<MenuItem> menuItems, LocalDate placedAt) {
    this.customer = customer;
    this.table = table;
    this.menuItems = menuItems;
    this.placedAt = placedAt;
  }

  public boolean addItems(MenuItem... items) {
    return Collections.addAll(menuItems, items);
  }

  public Customer getCustomer() {
    return customer;
  }

  public Table getTable() {
    return table;
  }

  public List<MenuItem> getMenuItems() {
    return menuItems;
  }

  public LocalDate getPlacedAt() {
    return placedAt;
  }
}
