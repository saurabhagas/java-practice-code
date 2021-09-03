package com.saurabh.conceptual.parking_lot_design.money;

import java.util.Map;

import com.saurabh.conceptual.parking_lot_design.vehicle.VehicleType;

public class HourlyRateCard implements RateCard {
  private final Map<VehicleType, Double> rateByVehicleType;

  public HourlyRateCard(Map<VehicleType, Double> rateByVehicleType) {
    this.rateByVehicleType = rateByVehicleType;
  }

  @Override
  public double getRateFor(VehicleType vehicleType) {
    return rateByVehicleType.get(vehicleType);
  }
}
