package com.manager.subscription.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Shareholder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    @NotBlank
    @Size(min = 3, max = 100)
    private String name;
    @Column
    @NotBlank
    @Size(min = 11, max = 13)
    private String telephone;
    @Column
    @ManyToMany(mappedBy = "shareholders")
    @JsonManagedReference
    private List<Subscription> subscriptions;

}
