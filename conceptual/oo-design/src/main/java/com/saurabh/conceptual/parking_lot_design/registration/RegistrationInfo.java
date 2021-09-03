package com.saurabh.conceptual.parking_lot_design.registration;

import java.time.LocalDateTime;

public class RegistrationInfo {
  private final double feePaid;
  private final LocalDateTime timestamp;
  private final ParkingLotOwner parkingLotOwner;

  public RegistrationInfo(ParkingLotOwner parkingLotOwner, LocalDateTime timestamp, double feePaid) {
    this.feePaid = feePaid;
    this.timestamp = timestamp;
    this.parkingLotOwner = parkingLotOwner;
  }

  public double getFeePaid() {
    return feePaid;
  }

  public LocalDateTime getTimestamp() {
    return timestamp;
  }

  public ParkingLotOwner getParkingLotOwner() {
    return parkingLotOwner;
  }
}
