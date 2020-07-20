package com.saurabh.conceptual.restaurant_design.staff;

import com.saurabh.conceptual.restaurant_design.people.Person;

import java.time.LocalDate;

public class Employee extends Person {
  private final int id;
  private final LocalDate joinedOn;

  public Employee(String name, String email, String phone, int id, LocalDate joinedOn) {
    super(name, email, phone);
    this.id = id;
    this.joinedOn = joinedOn;
  }

  public int getId() {
    return id;
  }

  public LocalDate getJoinedOn() {
    return joinedOn;
  }

  @Override
  public String toString() {
    return "Employee{" +
        "id=" + id +
        ", joinedOn=" + joinedOn +
        '}';
  }
}
