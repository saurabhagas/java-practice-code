package com.saurabh.conceptual.restaurant_design.order;

import java.util.List;

public class Menu {
  private final List<MenuSection> menuSections;

  public Menu(List<MenuSection> menuSections) {
    this.menuSections = menuSections;
  }

  public List<MenuSection> getSections() {
    return menuSections;
  }
}
