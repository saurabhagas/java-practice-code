package com.saurabh.conceptual.parking_lot_design.money;

import java.time.Duration;

import com.saurabh.conceptual.parking_lot_design.vehicle.VehicleType;

public class Calculator {
  private final RateCard rateCard;

  public Calculator(RateCard rateCard) {
    this.rateCard = rateCard;
  }

  public double getTotalAmount(VehicleType type, Duration duration) {
    double rate = rateCard.getRateFor(type);
    return duration.toHours() * rate;
  }
}
