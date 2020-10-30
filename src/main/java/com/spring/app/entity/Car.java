package com.spring.app.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Car extends BaseEntity {

    private String name;

    private String licensePlate;

    @ManyToOne
    private User owner;
}
