package com.wy.pojo;

import lombok.Data;

import javax.persistence.*;

/**
 * 城市
 */
@Table(name = "cities")
@Data
public class Cities {
  @Id
  @GeneratedValue(strategy= GenerationType.IDENTITY)
  @Column(name = "id")
  private long id;
  @Column(name = "cityid")
  private String cityid;
  @Column(name = "city")
  private String city;
  @Column(name = "provinceid")
  private String provinceid;




}
