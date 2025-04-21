package com.manager.subscription.models;

import com.manager.subscription.enuns.Periodicity;
import com.manager.subscription.enuns.Type;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Type type;
    @Column(nullable = false)
    private Periodicity periodicity;
    @Column(nullable = false)
    private int paymentLimit;
}
