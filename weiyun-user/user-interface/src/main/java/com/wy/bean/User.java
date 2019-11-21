package com.wy.bean;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Table(name = "tb_user")
@Data
public class User implements UserDetails {
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
    @Column(name = "role_id")
    private Integer roleId;
    //一个人可以关联多个角色
    //JoinTable:指明两个表中间的关联表.
    //name:中间中表中关联的主键名称
    //referencedColumnName:对应被关联的那个表的主键名称
    //注意;joinColumns与inverseJoinColumns的区别.
    //cascade:级联操作:级联更新/删除;
    //fetch:对象的加载策略:饥饿模式和延迟加载模式.
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    //JoinTable:设置多表关联时连接的表
    @JoinTable(name = "tb_role",
            joinColumns = @JoinColumn(name = "id", referencedColumnName = "role_id"))
    private List<Role> authorities;

    public void setAuthorities(List<Role> authorities){
        this.authorities = authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    public void setUsername(String phone) {
        this.phone = phone;
    }
    @Override
    public String getUsername() {
        return phone;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
