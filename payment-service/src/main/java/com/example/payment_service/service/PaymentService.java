package com.example.payment_service.service;

import com.example.payment_service.entity.Payment;

import java.util.List;

public interface PaymentService {
    Payment createPayment(Payment payment);
    List<Payment> getAllPayments();
    Payment getPaymentById(Long id);
    Payment updatePayment(Long id, Payment paymentDetails);
    void deletePayment(Long id);
}
