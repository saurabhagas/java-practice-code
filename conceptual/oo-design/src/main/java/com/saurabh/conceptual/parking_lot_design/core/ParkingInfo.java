package com.saurabh.conceptual.parking_lot_design.core;

import java.time.LocalDate;
import java.time.LocalTime;

public class ParkingInfo {
  private final LocalDate date;
  private final LocalTime entryTime;
  private final String parkingLotId;
  private double amountPaid;
  private LocalTime exitTime;

  public ParkingInfo(LocalDate date, LocalTime entryTime, String parkingLotId) {
    this.date = date;
    this.entryTime = entryTime;
    this.parkingLotId = parkingLotId;
  }

  public void setAmountPaid(double amountPaid) {
    this.amountPaid = amountPaid;
  }

  public void setExitTime(LocalTime exitTime) {
    this.exitTime = exitTime;
  }

  public LocalDate getDate() {
    return date;
  }

  public LocalTime getEntryTime() {
    return entryTime;
  }

  public String getParkingLotId() {
    return parkingLotId;
  }

  public double getAmountPaid() {
    return amountPaid;
  }

  public LocalTime getExitTime() {
    return exitTime;
  }

  @Override
  public String toString() {
    return "ParkingInfo{" +
      "date=" + date +
      ", duration=" + exitTime.minusHours(entryTime.getHour()) +
      ", parkingLotId='" + parkingLotId + '\'' +
      ", amountPaid=" + amountPaid +
      '}';
  }
}
