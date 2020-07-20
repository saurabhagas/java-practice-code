package com.saurabh.conceptual.restaurant_design.infra;

import com.saurabh.conceptual.restaurant_design.people.Customer;
import com.saurabh.conceptual.restaurant_design.reservation.Reservation;
import com.saurabh.conceptual.restaurant_design.reservation.ReservationStatus;
import com.saurabh.source.common.IntSequenceGenerator;

import java.time.LocalDate;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BranchCoordinator {
  private final Map<Table, List<LocalDate>> tableReservation = new HashMap<>();
  private final IntSequenceGenerator sequenceGenerator = new IntSequenceGenerator(0);

  public BranchCoordinator() {
    // Create 10 tables
    for (int i = 0; i < 10; i++) {
      tableReservation.put(new Table(sequenceGenerator.next()), null);
    }
  }

  public List<Table> getAvailableTables(LocalDate time) {
    return Collections.emptyList();
  }

  public ReservationStatus reserveTable(Customer customer, LocalDate time) {
    return ReservationStatus.CONFIRMED;
  }

  public ReservationStatus cancelReservation(Reservation reservation) {
    return ReservationStatus.CANCELED;
  }
}
