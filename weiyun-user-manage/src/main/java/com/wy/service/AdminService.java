package com.wy.service;

import com.wy.bean.Admin;
import com.wy.common.enums.ExceptionEnums;
import com.wy.common.exception.WyException;
import com.wy.mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    private AdminMapper adminMapper;

    public void login(Admin admin) {
        Admin res = adminMapper.selectOne(admin);
        if (res == null) {
            new WyException(ExceptionEnums.ADMIN_NOT_FOUND);
        }
    }
}
