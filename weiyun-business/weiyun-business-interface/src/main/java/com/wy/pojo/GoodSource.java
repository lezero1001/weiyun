package com.wy.pojo;

import lombok.Data;

import javax.persistence.*;

@Table(name = "car_source")
@Data
public class GoodSource {
  @Id
  @GeneratedValue(strategy= GenerationType.IDENTITY)
  private long id;
  @Column(name = "kind_id")
  private long kindId;
  @Column(name = "type_id")
  private long typeId;
  private long weight;
  @Column(name = "carry_unit_id")
  private long carryUnitId;
  @Column(name = "start_province_id")
  private long startProvinceId;
  @Column(name = "start_city_id")
  private long startCityId;
  @Column(name = "start_area_id")
  private long startAreaId;
  @Transient
  private String startPlace;
  @Column(name = "end_province_id")
  private long endProvinceId;
  @Column(name = "end_city_id")
  private long endCityId;
  @Column(name = "end_area_id")
  private long endAreaId;
  @Transient
  private String endPlace;
  @Column(name = "line_type_id")
  private long lineTypeId;
  @Transient
  private String lineType;




}
