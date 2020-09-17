package com.codegym.vn.models.house;

import com.codegym.vn.models.house.District;
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
