package com.wy.mapper;

import com.wy.bean.Role;
import com.wy.bean.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface UserMapper extends Mapper<User> {

    @Select("select r.role from tb_role r LEFT JOIN tb_user_role ur on r.id = ur.role_id \n" +
            "LEFT JOIN tb_user u on u.id = ur.user_id  where u.id = ${userId}")
    List<Role> selectRoles(@Param(value = "userId") Long userId);
}
