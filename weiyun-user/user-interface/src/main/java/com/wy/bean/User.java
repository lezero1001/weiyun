package com.wy.bean;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "tb_user")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String phone;
    private String password;
    private String salt;
    private String email;
    private String company_name;
    private String other_phone;
    private String type1;
    private String type2;
    private String vip;
    private String live_status;
    private String idcard;
}
