package com.codegym.vn.models.house;

import com.codegym.vn.models.house.House;
import com.codegym.vn.models.user.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
  public class Booking {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private Date checkinDay;
  private Date checkoutDay;
  private int  vote;
  private String feedback;
  private double payment;

  @ManyToOne
  private User customer;


  @ManyToOne
  private House house;
}