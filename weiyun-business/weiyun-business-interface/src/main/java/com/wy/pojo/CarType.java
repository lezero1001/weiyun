package com.wy.pojo;


import lombok.Data;

import javax.persistence.*;

/**
 * 车辆种类
 */
@Table(name = "car_type")
@Data
public class CarType {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
   private long id;
    @Column(name = "name")
   private String name;



}
