package com.wy.pojo;


import lombok.Data;


import javax.persistence.*;


/**
 * 车源信息
 */

@Table(name = "car_source")
@Data
public class CarSource {
  @Id
  @GeneratedValue(strategy= GenerationType.IDENTITY)
  private long id;
  @Column(name = "type_id")
  private long typeId;
  @Transient
  private String type;
  @Column(name = "weight")
  private long weight;
  @Column(name = "carry_unit_id")
  private long carryUnitId;
  @Transient
  private String carry;
  @Column(name = "car_specifs_id")
  private long carSpecifsId;
  @Transient
  private String carSpecifs;
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
  @Column(name = "price")
  private long price;
  @Column(name = "price_unit_id")
  private long priceUnitId;

  private String name;

  private String phone;

  private String email;

  private String qq;


}
