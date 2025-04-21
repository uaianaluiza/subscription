package com.manager.subscription.dtos.response;

import com.manager.subscription.models.Payment;
import com.manager.subscription.models.Shareholder;

import java.util.List;

public class SubscriptionResponse {

    private int id;
    private String name;
    private int maximumNumberOfShareholders;
    private int numberOfShareholders;
    private Double price;
    private Payment payment;
    private List<Shareholder> shareholders;
}
