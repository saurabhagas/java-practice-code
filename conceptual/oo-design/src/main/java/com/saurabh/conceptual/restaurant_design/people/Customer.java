package com.saurabh.conceptual.restaurant_design.people;

public class Customer extends Person {
  private final int id;

  public Customer(String name, String email, String phone, int id) {
    super(name, email, phone);
    this.id = id;
  }

  public int getId() {
    return id;
  }
}
