package com.saurabh.conceptual.restaurant_design.payment;

public class Payment {
  private final double amount;
  private final PaymentMode paymentMode;

  public Payment(double amount, PaymentMode paymentMode) {
    this.amount = amount;
    this.paymentMode = paymentMode;
  }

  public double getAmount() {
    return amount;
  }

  public PaymentMode getPaymentMode() {
    return paymentMode;
  }
}
