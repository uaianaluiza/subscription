package com.manager.subscription.dtos.request;

import com.manager.subscription.enuns.Periodicity;
import com.manager.subscription.enuns.Type;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentRequest {

    private Type type;
    private Periodicity periodicity;
    private int paymentLimit;
}
