package com.saurabh.conceptual.oop;

public class EnumsTest {
  public void testEnumFunctionality() {
    Season s = Season.SUMMER;

    // Utility methods
    System.out.println(s.name()); // SUMMER
    System.out.println(s.toString()); // SUMMER
    System.out.println(s.ordinal()); // Default 0-based order of this constant in the constant list. Can't be customized

    // Equality checks - can be performed because enum values are constants
    System.out.println(s.equals(Season.FALL)); // false
    System.out.println(s == Season.SUMMER); // true
    
    // Use in a switch
    Season season = Season.valueOf("SUMMER");
//    Season season = Season.valueOf("summer"); //IllegalArgumentException - No such enum constant
    switch (season) {
      case SUMMER:
      case SPRING:
      case WINTER:
      case FALL:
        System.out.println("enum: " + season);
        break;
      default:
        System.out.println("Unknown enum: " + season);
    }
    
    // Use in a for-each loop
    for (Season seasonEntry : Season.values()) { // Season.values() returns an array of Season values
      System.out.println(seasonEntry);
    }
    
    // Methods in enum
    System.out.println(season.getHours());
    System.out.println(season.getSeasonValue());
    season.printPermissions();
//    season.doSomething(); // Method not present in Season
//    Season.WINTER.doSomething(); // Extra method in anonymous class not visible - duh!
  }
}

enum Season {
  //  int number; // enum constant should be the 
  WINTER("winter", "11am-4pm") {
    @Override
    public void printPermissions() { System.out.println("Entry for VIPs only"); }

    public void doSomething() { System.out.println("Something something"); }
  },
  SUMMER("summer", "10am-5pm") {
    @Override
    public void printPermissions() {
      System.out.println("Entry for childern and the elderly");
    }

    public void doSomething() { System.out.println("Yo yo"); }
  },
  SPRING("spring", "11am-5pm"),
//  AUTUMN = 5, // Cannot assign custom "ordinal" values to enum constant like C/C++
  FALL("fall", "11am-5pm");

  private final String seasonValue;
  private final String hours;

  Season(String seasonValue, String hours) {
    this.hours = hours;
    this.seasonValue = seasonValue;
  }

  public void printPermissions() { System.out.println("Entry for everyone!"); }

  public String getSeasonValue() {
    return seasonValue;
  }

  public String getHours() {
    return hours;
  }
}

//enum ExtendedSeason extends Season {} // Can't extend enums because enum constructors are private
