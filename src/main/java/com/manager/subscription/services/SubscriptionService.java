package com.manager.subscription.services;

import com.manager.subscription.dtos.request.SubscriptionRequest;
import com.manager.subscription.enuns.Type;
import com.manager.subscription.models.Payment;
import com.manager.subscription.models.Subscription;
import com.manager.subscription.repositorys.SubscriptionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubscriptionService {

    private final SubscriptionRepository repository;
    private final PaymentService paymentService;

    public SubscriptionService(SubscriptionRepository repository, PaymentService paymentService) {
        this.repository = repository;
        this.paymentService = paymentService;
    }

    public void addSubscription(SubscriptionRequest request) {
        Subscription subscription = new Subscription();
        subscription.setName(request.getName());
        subscription.setPrice(request.getPrice());
        subscription.setMaximumNumberOfShareholders(request.getMaximumNumberOfShareholders());
        subscription.setNumberOfShareholders(request.getNumberOfShareholders());
        Payment payment = paymentService.getPaymentById(request.getPayment());
        subscription.setPayment(payment);

        repository.save(subscription);
    }

    public Optional<Subscription> getSubscription(Integer id) {
        try {
            return repository.findById(id);
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    public Subscription updateSubscription(Integer id, SubscriptionRequest request) {
        Subscription subscription = getSubscription(id).orElse(null);
        subscription.setName(request.getName());
        subscription.setPrice(request.getPrice());
        Payment payment = paymentService.getPaymentById(request.getPayment());
        subscription.setPayment(payment);
        subscription.setMaximumNumberOfShareholders(request.getMaximumNumberOfShareholders());
        subscription.setNumberOfShareholders(request.getNumberOfShareholders());

        return repository.save(subscription);
    }

    public List<Subscription> getSubscriptions() {
        return repository.findAll();
    }

    public void deleteSubscription(Integer id) {
        repository.deleteById(id);
    }

    public Double calculatePaymentFraction(Integer id) {
        Subscription subscription = getSubscription(id).orElse(null);
        if (subscription.getPayment().getType() == Type.FRACTION) {
            return subscription.getPrice() / subscription.getNumberOfShareholders();
        } else
            return subscription.getPrice();
    }
}
