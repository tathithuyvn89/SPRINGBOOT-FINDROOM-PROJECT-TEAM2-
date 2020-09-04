package com.codegym.vn.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class HouseAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToOne
    private District district;
}
