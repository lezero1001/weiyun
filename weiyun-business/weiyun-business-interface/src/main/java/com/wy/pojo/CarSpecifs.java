package com.wy.pojo;

import lombok.Data;

import javax.persistence.*;

/**
 * 装载物品种类
 */
@Table(name = "car_specifs")
@Data
public class CarSpecifs {
  @Id
  @GeneratedValue(strategy= GenerationType.IDENTITY)
  @Column(name = "id")
  private long id;
  @Column(name = "name")
  private String name;



}
