package com.wy.controller;

import com.wy.bean.User;
import com.wy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    /**发送手机验证码*/
    @GetMapping("/code")
    public ResponseEntity<Void> sendVerifyCode(String phone) {
        Boolean boo = this.userService.sendVerifyCode(phone);
        return ResponseEntity.ok(null);
    }

    /**
     * 根据用户名和密码查询用户
     * @param username
     * @param password
     * @return
     */
    @GetMapping("/query")
    public ResponseEntity<User> queryUser(
            @RequestParam("username") String username,
            @RequestParam("password") String password
    ) {
        User user = this.userService.queryUser(username, password);
        return ResponseEntity.ok(user);
    }

    /**注册*/
    @GetMapping("/register")
    public ResponseEntity<Void> register(User user, @RequestParam("code") String code){
        this.userService.register(user, code);
        return ResponseEntity.ok(null);
    }
}
