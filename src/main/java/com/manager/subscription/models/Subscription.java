package com.manager.subscription.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    @NotNull
    @Size(min = 3, max = 100)
    private String name;
    @Column
    @NotNull
    private Integer maximumNumberOfShareholders;
    @Column
    @NotNull
    private Integer numberOfShareholders;
    private Double price;
    @JoinColumn
    @NotNull
    @ManyToOne
    private Payment payment;
    @JoinTable(
            name = "subscription_shareholder",
            joinColumns = @JoinColumn(name = "subscription_id"),
            inverseJoinColumns = @JoinColumn(name = "shareholder_id")
    )
    @ManyToMany
    @JsonBackReference
    private List<Shareholder> shareholders;

    public Subscription(String name, Integer maximumNumberOfShareholders, Double price, Payment payment) {
        this.name = name;
        this.maximumNumberOfShareholders = maximumNumberOfShareholders;
        this.price = price;
        this.payment = payment;
    }

    public Subscription() {

    }
}
