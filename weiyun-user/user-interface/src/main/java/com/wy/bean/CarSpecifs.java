package com.wy.bean;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "car_specifs")
public class CarSpecifs {
    @Id
    private Long id;
    private String name;
}
