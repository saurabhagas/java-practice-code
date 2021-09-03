package com.saurabh.conceptual.parking_lot_design.money;

import com.saurabh.conceptual.parking_lot_design.vehicle.VehicleType;

public interface RateCard {
  double getRateFor(VehicleType vehicleType);
}
