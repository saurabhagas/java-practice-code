package com.saurabh.conceptual.parking_lot_design.vehicle;

public class Vehicle {
  private final VehicleType vehicleType;
  private final String licensePlate;

  public Vehicle(VehicleType vehicleType, String licensePlate) {
    this.vehicleType = vehicleType;
    this.licensePlate = licensePlate;
  }

  public VehicleType getVehicleType() {
    return vehicleType;
  }

  public String getLicensePlate() {
    return licensePlate;
  }
}
