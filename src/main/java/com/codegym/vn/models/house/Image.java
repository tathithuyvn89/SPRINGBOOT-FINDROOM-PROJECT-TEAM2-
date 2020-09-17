package com.codegym.vn.models.house;

import com.codegym.vn.models.house.House;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String srcImg;

    @ManyToOne()
    private House house;

}