package com.wy.bean;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;

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
    @Column(name = "other_phone")
    private String otherPhone;
    private Integer type1;
    private Integer type2;
    private Integer vip;
    @Column(name = "live_status")
    private Integer liveStatus;//账号状态
    @Column(name = "idcard")
    private String idCard;
    @Column(name = "company_name")
    private String companyName;
    @Column(name = "company_image")
    private String companyImage;// 公司营业执照
    @Column(name = "contacts_name")
    private String contactsName; // 联系人姓名
    @Column(name = "contacts_idcard")
    private String contactsIdcard;
    @Column(name = "contacts_phone")
    private String contactsPhone;
}
