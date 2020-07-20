package com.saurabh.conceptual.restaurant_design.people;

public class Person {
  private final String name;
  private final String email;
  private final String phone;

  public Person(String name, String email, String phone) {
    this.name = name;
    this.email = email;
    this.phone = phone;
  }

  public String getName() {
    return name;
  }

  public String getEmail() {
    return email;
  }

  public String getPhone() {
    return phone;
  }

  @Override
  public String toString() {
    return "Person{" +
        "name='" + name + '\'' +
        ", email='" + email + '\'' +
        ", phone='" + phone + '\'' +
        '}';
  }
}
