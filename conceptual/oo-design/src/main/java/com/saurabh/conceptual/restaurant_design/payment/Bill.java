package com.saurabh.conceptual.restaurant_design.payment;

import com.saurabh.conceptual.restaurant_design.order.Order;

public class Bill {
  private final Order order;
  private Payment payment;

  public Bill(Order order, Payment payment) {
    this.order = order;
    this.payment = payment;
  }

  public PaymentStatus pay() {
    return PaymentStatus.PAID;
  }

  public PaymentStatus pay(PaymentMode newPaymentMode) {
    payment = new Payment(payment.getAmount(), newPaymentMode);
    return PaymentStatus.PAID;
  }
}
