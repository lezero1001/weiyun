package com.wy.bean;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "car_type")
public class CarType {
    @Id
    private Long id;
    private String name;
}
