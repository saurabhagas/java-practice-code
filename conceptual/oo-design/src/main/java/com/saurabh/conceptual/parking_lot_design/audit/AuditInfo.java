package com.saurabh.conceptual.parking_lot_design.audit;

import java.util.Queue;

import com.saurabh.conceptual.parking_lot_design.core.ParkingInfo;

public class AuditInfo {

  private final Queue<ParkingInfo> parkingInfos;

  public AuditInfo(Queue<ParkingInfo> parkingInfos) {
    this.parkingInfos = parkingInfos;
  }

  public Queue<ParkingInfo> getParkingInfos() {
    return parkingInfos;
  }

  @Override
  public String toString() {
    return "AuditInfo{" +
      "parkingInfos=" + parkingInfos +
      '}';
  }
}
