package com.wy.bean;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "tb_car")
@Data
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long user_id;
    private Long car_length;
    private Long type_id;
    private Long weight;
    private Long species_id;
    private String car_card;
    private String car_image;
    private String allowed_driver;//道路运营许可证图片
    private String driver;//随从司机
    private String driver_phone;
    private String driver_idcard;
    private String idcard_front_image;
    private String idcard_back_image;
}
