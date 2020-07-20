package com.saurabh.conceptual.restaurant_design;

import com.saurabh.conceptual.restaurant_design.infra.Branch;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
  private final String name;
  private final String phone;
  private final String email;
  private final List<Branch> branches;

  public Restaurant(String name, String phone, String email, List<Branch> branches) {
    this.name = name;
    this.phone = phone;
    this.email = email;
    this.branches = new ArrayList<>(branches);
  }

  public void addBranch(Branch branch) {
    branches.add(branch);
  }

  public void removeBranch(Branch branch) {
    branches.remove(branch);
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

  public List<Branch> getBranches() {
    return branches;
  }

  @Override
  public String toString() {
    return "Restaurant{" +
        "name='" + name + '\'' +
        ", phone='" + phone + '\'' +
        ", email='" + email + '\'' +
        ", branches=" + branches +
        '}';
  }
}
