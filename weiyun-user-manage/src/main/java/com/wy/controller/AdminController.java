package com.wy.controller;

import com.wy.bean.Admin;
import com.wy.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {
    @Autowired
    private AdminService adminService;

    @PostMapping("/login")
    public ResponseEntity<Void> login(Admin admin){
        adminService.login(admin);
        return ResponseEntity.ok(null);
    }
}
