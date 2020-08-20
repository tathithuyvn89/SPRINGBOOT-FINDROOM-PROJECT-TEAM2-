package com.codegym.vn.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
  public class House {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String nameHouse;
  private String address;
  private String bedroomNum;
  private String bathroomNum;
  private String description;
  private String priceOneDay;
  private Boolean status; // Da thue hay chua duoc thue

  @ManyToOne
  private CategoryHome categoryHome;

  @ManyToOne
  private CategoryRoom categoryRoom;

  @ManyToOne

  private Host host;
}