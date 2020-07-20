package com.saurabh.conceptual.restaurant_design.staff;

import java.time.LocalDate;

public class Manager extends Employee {
  public Manager(String name, String email, String phone, int id, LocalDate joinedOn) {
    super(name, email, phone, id, joinedOn);
  }
}
