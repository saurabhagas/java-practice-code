package com.saurabh.conceptual.restaurant_design.order;

public class MenuItem {
  private final String itemName;
  private final double price;

  public MenuItem(String itemName, double price) {
    this.itemName = itemName;
    this.price = price;
  }

  public static MenuItem from(String itemName, double price) {
    return new MenuItem(itemName, price);
  }

  public String getItemName() {
    return itemName;
  }

  public double getPrice() {
    return price;
  }
}
