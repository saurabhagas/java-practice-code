package com.saurabh.conceptual.restaurant_design.staff;

import com.saurabh.conceptual.restaurant_design.order.MenuItem;

import java.time.LocalDate;

public class Chef extends Employee {
  public Chef(String name, String email, String phone, int id, LocalDate joinedOn) {
    super(name, email, phone, id, joinedOn);
  }

  public void prepareItem(MenuItem item) {

  }
}
