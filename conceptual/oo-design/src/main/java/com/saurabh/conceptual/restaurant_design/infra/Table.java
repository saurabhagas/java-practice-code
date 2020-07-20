package com.saurabh.conceptual.restaurant_design.infra;

import com.saurabh.conceptual.restaurant_design.people.Customer;
import com.saurabh.conceptual.restaurant_design.reservation.ReservationStatus;

import java.time.LocalDate;

public class Table {
  private final int id;
  private Customer customer;
  private LocalDate occupiedAt;
  private ReservationStatus reservationStatus;
  private LocalDate reservedAt;

  public Table(int id) {
    this.id = id;
  }

  public void reserve(Customer customer, LocalDate reservedAt) {
    this.customer = customer;
    this.reservationStatus = ReservationStatus.CONFIRMED;
    this.reservedAt = reservedAt;
  }

  public void cancelReservation() {
    reservationStatus = ReservationStatus.CANCELED;
    reservedAt = null;
  }

  public void occupy(Customer customer, LocalDate occupiedAt) {
    this.customer = customer;
    this.occupiedAt = occupiedAt;
  }

  public void release() {
    occupiedAt = null;
    customer = null;
  }
}
