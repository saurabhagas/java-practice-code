package com.saurabh.conceptual.parking_lot_design.registration;

public class ParkingLotOwner {
  private final String name;
  private final String licenseId;

  public ParkingLotOwner(String name, String licenseId) {
    this.name = name;
    this.licenseId = licenseId;
  }

  public String getName() {
    return name;
  }

  public String getLicenseId() {
    return licenseId;
  }
}
