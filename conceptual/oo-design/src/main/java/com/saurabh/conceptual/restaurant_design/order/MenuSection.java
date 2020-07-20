package com.saurabh.conceptual.restaurant_design.order;

import java.util.List;

public class MenuSection {
  private final String sectionName;
  private final List<MenuItem> sectionItems;

  public MenuSection(String sectionName, List<MenuItem> sectionItems) {
    this.sectionName = sectionName;
    this.sectionItems = sectionItems;
  }

  public String getSectionName() {
    return sectionName;
  }

  public List<MenuItem> getSectionItems() {
    return sectionItems;
  }

  @Override
  public String toString() {
    return "SectionName='" + sectionName + '\'' +
        ", sectionItems=" + sectionItems;
  }
}
