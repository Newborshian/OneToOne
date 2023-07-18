package org.formation.hibernate.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Passport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String passportNumber;
    @OneToOne(mappedBy = "passport")
    private Customer customer;

    public Passport(String passportNumber) {
        this.passportNumber = passportNumber;
    }
    public Passport() {
    }
}
