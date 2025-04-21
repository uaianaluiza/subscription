package com.manager.subscription.services;

import com.manager.subscription.dtos.request.PaymentRequest;
import com.manager.subscription.models.Payment;
import com.manager.subscription.repositorys.PaymentRepository;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    private final PaymentRepository repository;

    public PaymentService(PaymentRepository repository) {
        this.repository = repository;
    }

    public Payment addPayment(PaymentRequest request) {
        Payment payment = new Payment();
        payment.setPaymentLimit(request.getPaymentLimit());
        payment.setPeriodicity(request.getPeriodicity());
        payment.setType(request.getType());
        return repository.save(payment);
    }

    public Payment getPaymentById(int id) {
        return repository.findById(id).orElse(null);
    }

    public void updatePayment(Integer id, PaymentRequest request) {
        Payment payment = getPaymentById(id);
        payment.setPaymentLimit(request.getPaymentLimit());
        payment.setPeriodicity(request.getPeriodicity());
        payment.setType(request.getType());
        repository.save(payment);
    }

    public void deletePaymentById(int id) {
        repository.deleteById(id);
    }

}
