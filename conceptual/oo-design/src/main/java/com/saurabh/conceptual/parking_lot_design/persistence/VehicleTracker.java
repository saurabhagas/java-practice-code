package com.saurabh.conceptual.parking_lot_design.persistence;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

import com.saurabh.conceptual.parking_lot_design.audit.AuditInfo;
import com.saurabh.conceptual.parking_lot_design.core.ParkingInfo;
import com.saurabh.conceptual.parking_lot_design.money.Calculator;
import com.saurabh.conceptual.parking_lot_design.vehicle.Vehicle;

public class VehicleTracker {
  private final Map<String, Deque<ParkingInfo>> parkingInfoByLicensePlate = new HashMap<>();
  private final Calculator calculator;

  public VehicleTracker(Calculator calculator) {
    this.calculator = calculator;
  }

  public void addVehicle(Vehicle vehicle, String parkingLotId) {
    Deque<ParkingInfo> parkingInfos = parkingInfoByLicensePlate.get(vehicle.getLicensePlate());
    ParkingInfo parking = new ParkingInfo(LocalDate.now(), LocalTime.now(), parkingLotId);
    if (parkingInfos == null) {
      Deque<ParkingInfo> parkingInfo = new ArrayDeque<>();
      parkingInfo.push(parking);
      parkingInfoByLicensePlate.put(vehicle.getLicensePlate(), parkingInfo);
    } else {
      parkingInfos.add(parking);
    }
  }

  public void removeVehicle(Vehicle vehicle) {
    Deque<ParkingInfo> parkingInfos = parkingInfoByLicensePlate.get(vehicle.getLicensePlate());
    ParkingInfo currentParkingInfo = parkingInfos.peek();
    if (currentParkingInfo == null || currentParkingInfo.getExitTime() != null) {
      throw new IllegalStateException("No parking info associated with this vehicle");
    }
    LocalTime entryTime = currentParkingInfo.getEntryTime();
    int hour = LocalTime.now().plusHours(2).minusHours(entryTime.getHour()).getHour();
    double totalAmount = calculator.getTotalAmount(vehicle.getVehicleType(), Duration.ofHours(hour));

    currentParkingInfo.setAmountPaid(totalAmount);
    currentParkingInfo.setExitTime(LocalTime.now());
  }

  public AuditInfo getAuditInfo(Vehicle vehicle) {
    return new AuditInfo(parkingInfoByLicensePlate.get(vehicle.getLicensePlate()));
  }
}
