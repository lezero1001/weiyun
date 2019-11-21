package com.wy.bean;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "car_specifs")
public class CarSpecifs {
    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
}
