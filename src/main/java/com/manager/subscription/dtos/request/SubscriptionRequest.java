package com.manager.subscription.dtos.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SubscriptionRequest {

    private String name;
    private int maximumNumberOfShareholders;
    private int numberOfShareholders;
    private Double price;
    private int payment;

}
