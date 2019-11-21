package com.wy.pojo;

import lombok.Data;

import javax.persistence.*;

/**
 * 区名
 */
@Table(name = "areas")
@Data
public class Areas {
  @Id
  @GeneratedValue(strategy= GenerationType.IDENTITY)
  @Column(name = "id")
  private long id;
  @Column(name = "area_id")
  private String areaId;
  @Column(name = "area")
  private String area;
  @Column(name = "city_id")
  private String cityId;


}
