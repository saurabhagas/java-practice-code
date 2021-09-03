package com.saurabh.conceptual.parking_lot_design;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import com.saurabh.conceptual.parking_lot_design.core.ParkingLot;
import com.saurabh.conceptual.parking_lot_design.core.SingleLevelParkingLot;
import com.saurabh.conceptual.parking_lot_design.money.Calculator;
import com.saurabh.conceptual.parking_lot_design.money.HourlyRateCard;
import com.saurabh.conceptual.parking_lot_design.money.RateCard;
import com.saurabh.conceptual.parking_lot_design.persistence.VehicleTracker;
import com.saurabh.conceptual.parking_lot_design.registration.ParkingLotOwner;
import com.saurabh.conceptual.parking_lot_design.registration.RegistrationInfo;
import com.saurabh.conceptual.parking_lot_design.vehicle.Vehicle;
import com.saurabh.conceptual.parking_lot_design.vehicle.VehicleType;

public class Main {
  private static List<Vehicle> vehicles;
  private static List<ParkingLot> parkingLots;

  public static void main(String[] args) {
    seedData();

    admitVehicle(parkingLots.get(0), vehicles.get(0));
    exitVehicle(parkingLots.get(0), vehicles.get(0));
    audit(parkingLots.get(0), vehicles.get(0));
  }

  private static void seedData() {
    parkingLots = addParkingLots();
    vehicles = addSampleVehicles();
  }

  private static List<ParkingLot> addParkingLots() {
    List<ParkingLot> parkingLots = new ArrayList<>();
    Random random = new Random();
    parkingLots.add(new SingleLevelParkingLot(UUID.randomUUID().toString(), "lot-1",
      createCapacities(), createRegistrationInfo(random.nextInt()), createRateCard(), createVehicleTracker(createRateCard())));
    parkingLots.add(new SingleLevelParkingLot(UUID.randomUUID().toString(), "lot-2",
      createCapacities(), createRegistrationInfo(random.nextInt()), createRateCard(), createVehicleTracker(createRateCard())));
    parkingLots.add(new SingleLevelParkingLot(UUID.randomUUID().toString(), "lot-3",
      createCapacities(), createRegistrationInfo(random.nextInt()), createRateCard(), createVehicleTracker(createRateCard())));
    parkingLots.add(new SingleLevelParkingLot(UUID.randomUUID().toString(), "lot-4",
      createCapacities(), createRegistrationInfo(random.nextInt()), createRateCard(), createVehicleTracker(createRateCard())));
    parkingLots.add(new SingleLevelParkingLot(UUID.randomUUID().toString(), "lot-5",
      createCapacities(), createRegistrationInfo(random.nextInt()), createRateCard(), createVehicleTracker(createRateCard())));
    return parkingLots;
  }

  private static VehicleTracker createVehicleTracker(RateCard rateCard) {
    return new VehicleTracker(new Calculator(rateCard));
  }

  private static void admitVehicle(ParkingLot parkingLot, Vehicle vehicle) {
    boolean admitted = parkingLot.admitVehicle(vehicle);
    if (admitted) {
      System.out.println("Vehicle with id: " + vehicles.get(0).getLicensePlate()
        + " admitted into parking lot: " + parkingLots.get(0).getId());
    } else {
      System.out.println("Vehicle with id: " + vehicles.get(0).getLicensePlate()
        + " could not be admitted into parking lot: " + parkingLots.get(0).getId());
    }
  }

  private static void exitVehicle(ParkingLot parkingLot, Vehicle vehicle) {
    parkingLot.exitVehicle(vehicle);
  }

  private static void audit(ParkingLot parkingLot, Vehicle vehicle) {
    System.out.println(parkingLot.getAuditInfo(vehicle));
  }

  private static List<Vehicle> addSampleVehicles() {
    List<Vehicle> vehicles = new ArrayList<>();
    vehicles.add(new Vehicle(VehicleType.SMALL, "DL 12 3456"));
    vehicles.add(new Vehicle(VehicleType.MEDIUM, "DL 12 4563"));
    vehicles.add(new Vehicle(VehicleType.MEDIUM, "DL 12 5634"));
    vehicles.add(new Vehicle(VehicleType.LARGE, "DL 12 6543"));
    vehicles.add(new Vehicle(VehicleType.LARGE, "DL 12 6435"));
    return vehicles;
  }

  private static Map<VehicleType, Integer> createCapacities() {
    Map<VehicleType, Integer> capacityByType = new HashMap<>();
    capacityByType.put(VehicleType.SMALL, 5);
    capacityByType.put(VehicleType.MEDIUM, 5);
    capacityByType.put(VehicleType.LARGE, 5);
    return capacityByType;
  }

  private static RegistrationInfo createRegistrationInfo(int suffix) {
    ParkingLotOwner owner = new ParkingLotOwner("Mr. X" + suffix, "GSTIN007-" + suffix);
    return new RegistrationInfo(owner, LocalDateTime.now(), 10000);
  }

  private static RateCard createRateCard() {
    Map<VehicleType, Double> rateByVehicleType = new HashMap<>();
    rateByVehicleType.put(VehicleType.SMALL, 10.0);
    rateByVehicleType.put(VehicleType.MEDIUM, 20.0);
    rateByVehicleType.put(VehicleType.LARGE, 30.0);
    return new HourlyRateCard(rateByVehicleType);
  }
}
