package com.saurabh.conceptual.parking_lot_design.core;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.saurabh.conceptual.parking_lot_design.audit.AuditInfo;
import com.saurabh.conceptual.parking_lot_design.money.RateCard;
import com.saurabh.conceptual.parking_lot_design.persistence.VehicleTracker;
import com.saurabh.conceptual.parking_lot_design.registration.RegistrationInfo;
import com.saurabh.conceptual.parking_lot_design.vehicle.Vehicle;
import com.saurabh.conceptual.parking_lot_design.vehicle.VehicleType;

public class SingleLevelParkingLot implements ParkingLot {
  private final String id;
  private final String name;
  private final Map<VehicleType, Integer> capacityByType;
  private final Map<VehicleType, Integer> occupationByType = new HashMap<>();
  private final RegistrationInfo registrationInfo;
  private final RateCard rateCard;
  private final VehicleTracker vehicleTracker;

  public SingleLevelParkingLot(String id, String name, Map<VehicleType, Integer> capacityByType,
                               RegistrationInfo registrationInfo, RateCard rateCard, VehicleTracker vehicleTracker) {
    this.id = id;
    this.name = name;
    this.capacityByType = capacityByType;
    this.registrationInfo = registrationInfo;
    this.rateCard = rateCard;
    this.vehicleTracker = vehicleTracker;
  }

  @Override
  public boolean admitVehicle(Vehicle vehicle) {
    Integer total = capacityByType.get(vehicle.getVehicleType());
    Integer occupation = occupationByType.getOrDefault(vehicle.getVehicleType(), 0);
    if (occupation < total) {
      occupationByType.put(vehicle.getVehicleType(), occupation + 1);
      vehicleTracker.addVehicle(vehicle, id);
    }
    return !occupation.equals(total);
  }

  @Override
  public void exitVehicle(Vehicle vehicle) {
    Integer occupation = occupationByType.get(vehicle.getVehicleType());
    if (occupation == null) {
      throw new IllegalStateException("No vehicles found");
    }
    occupationByType.put(vehicle.getVehicleType(), occupation - 1);
    vehicleTracker.removeVehicle(vehicle);
  }

  @Override
  public AuditInfo getAuditInfo(Vehicle vehicle) {
    return vehicleTracker.getAuditInfo(vehicle);
  }

  @Override
  public String getId() {
    return id;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public Map<VehicleType, Integer> getCapacityByType() {
    return Collections.unmodifiableMap(capacityByType);
  }

  @Override
  public Integer getNumFloors() {
    return 1;
  }

  @Override
  public RegistrationInfo getRegistrationInfo() {
    return registrationInfo;
  }

  @Override
  public RateCard getRateCard() {
    return rateCard;
  }
}
