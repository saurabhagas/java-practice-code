package com.saurabh.conceptual.parking_lot_design.core;

import java.util.Map;

import com.saurabh.conceptual.parking_lot_design.audit.AuditInfo;
import com.saurabh.conceptual.parking_lot_design.money.RateCard;
import com.saurabh.conceptual.parking_lot_design.registration.RegistrationInfo;
import com.saurabh.conceptual.parking_lot_design.vehicle.Vehicle;
import com.saurabh.conceptual.parking_lot_design.vehicle.VehicleType;

public interface ParkingLot {
  boolean admitVehicle(Vehicle vehicle);

  void exitVehicle(Vehicle vehicle);

  AuditInfo getAuditInfo(Vehicle vehicle);

  String getId();

  String getName();

  Map<VehicleType, Integer> getCapacityByType();

  Integer getNumFloors();

  RegistrationInfo getRegistrationInfo();

  RateCard getRateCard();
}
