package com.manager.subscription.controllers;

import com.manager.subscription.dtos.request.SubscriptionRequest;
import com.manager.subscription.models.Subscription;
import com.manager.subscription.services.ShareholderService;
import com.manager.subscription.services.SubscriptionManagementService;
import com.manager.subscription.services.SubscriptionService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/subscription")
public class SubscriptionController {

    private final SubscriptionService subscriptionService;
    private final SubscriptionManagementService subscriptionManagementService;

    public SubscriptionController(SubscriptionService subscriptionService, SubscriptionManagementService subscriptionManagementService) {
        this.subscriptionService = subscriptionService;
        this.subscriptionManagementService = subscriptionManagementService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addSubscription(@RequestBody SubscriptionRequest request) {
        subscriptionService.addSubscription(request);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Subscription> getSubscription(@PathVariable Integer id) {
        return subscriptionService.getSubscription(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Subscription updateSubscription(@PathVariable Integer id, @RequestBody SubscriptionRequest request) {
        return subscriptionService.updateSubscription(id, request);
    }

    @PutMapping("/{subscriptionId}/{shareholderId}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void addShareholder(@PathVariable Integer subscriptionId, @PathVariable Integer shareholderId) {
        subscriptionManagementService.addShareholderToSubscription(subscriptionId, shareholderId);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Subscription> getSubscriptions() {
        return subscriptionService.getSubscriptions();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteSubscription(@PathVariable Integer id) {
        subscriptionService.deleteSubscription(id);
    }
}
