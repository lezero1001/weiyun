package com.wy.controller;

import com.wy.bean.User;
import com.wy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    /**发送手机验证码*/
    @PostMapping("/code")
    public ResponseEntity<Void> sendVerifyCode(String phone) {
        Boolean boo = this.userService.sendVerifyCode(phone);
        return ResponseEntity.ok(null);
    }


    /**注册*/
    @PostMapping("/register")
    public ResponseEntity<Void> register(User user, @RequestParam("code") String code){
        this.userService.register(user, code);
        return ResponseEntity.ok(null);
    }
}
