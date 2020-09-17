package com.codegym.vn.models.house;

import com.codegym.vn.models.user.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
  public class House {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String nameHouse;
  private String bedroomNum;
  private String bathroomNum;
  private String description;
  private String priceOneDay;
  private Boolean status; // Da thue hay chua duoc thue

  @OneToOne
  private HouseAddress houseAddress;

  @ManyToOne
  private CategoryHome categoryHome;

  @OneToMany(mappedBy = "house")
  private Set<Booking> booking;

  @ManyToOne
  private User host;


  @ManyToMany
  private List<Feature> features;

  @OneToMany(mappedBy = "house")
  private List<Image> images;
}