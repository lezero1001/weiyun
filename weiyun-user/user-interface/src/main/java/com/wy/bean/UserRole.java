package com.wy.bean;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "tb_user_role")
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "user_id")
    private Long userId;
    @Column(name = "role_id")
    private Long roleId;
}
