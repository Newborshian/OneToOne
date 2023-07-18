package org.formation.hibernate.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private  String name;
    @OneToOne
    @MapsId
    private Passport passport;

    public Customer() {
    }

    public Customer(String name, Passport passport) {
        this.name = name;
        this.passport = passport;
    }
}
