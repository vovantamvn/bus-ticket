package com.spring.app.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(insertable = false)
    private Integer id;

    @Column(unique = true, nullable = false)
    @Size(min = 3, max = 100)
    private String username;

    @Column(nullable = false)
    private String password;
}
