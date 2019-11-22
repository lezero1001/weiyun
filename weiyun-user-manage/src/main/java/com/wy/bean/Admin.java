package com.wy.bean;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;

@Data
@Table(name = "tb_admin")
public class Admin {

    private Long id;
    @Column(name = "name")
    private String username;

    private String password;
    @Column(name = "role_id")
    private Integer roleId;

}
