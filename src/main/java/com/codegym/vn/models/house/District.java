package com.codegym.vn.models.house;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class District {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String districtName;

    @ManyToOne
    private Province province;
}
