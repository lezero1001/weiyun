package com.wy.controller;

import com.wy.bean.Admin;
import com.wy.bean.User;
import com.wy.common.bean.PageResult;
import com.wy.service.AdminService;
import com.wy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserManageController {

    @Autowired
    private UserService userService;
    @Autowired
    private AdminService adminService;

    /**
     * 添加个人用户或企业用户，返回状态码201
     * @param user
     * @return
     */
    @PostMapping("/add")
    public ResponseEntity<Void> addUser(User user){
        switch (user.getType1()){
            case 0:user.setRoleId(3);break;// 身份为车主，赋予权限为车主
            case 1:user.setRoleId(4);break;// 身份为货主，赋予权限为货主
        }
        userService.addUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    /**
     * 修改个人用户或企业用户信息,返回状态码204
     * @param user
     * @return
     */
    @PutMapping("/update")
    public ResponseEntity<Void> updateUser(User user){
        userService.updateUser(user);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    /**
     * 删除用户信息，返回状态码200
     * @param userId
     * @return
     */
    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteUser(Long userId){
        userService.deleteUser(userId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    /**
     * 分页查看用户基本信息，返回PageResult<User>，状态码200
     * @param page  页数
     * @param size  每页数据量
     * @param vip   0：不是vip 1：是vip
     * @param liveStatus   0：封号状态  1：活跃状态
     * @param type1 0：车主    1：货主
     * @param type2 0：个人    1：企业
     * @param orderBy desc：降序    asc：升序
     * @param key 模糊查询关键字
     * @return
     */
    @GetMapping("/list")
    public ResponseEntity<PageResult<User>> userList(@RequestParam(value = "page",defaultValue = "1") Integer page,
                                                     @RequestParam(value = "size",defaultValue = "10")Integer size,
                                                     @RequestParam(value = "vip",defaultValue = "0")Integer vip,
                                                     @RequestParam(value = "liveStatus",defaultValue = "1")Integer liveStatus,
                                                     @RequestParam(value = "type1",defaultValue = "0")Integer type1,
                                                     @RequestParam(value = "type2",defaultValue = "0")Integer type2,
                                                     @RequestParam(value = "orderBy",defaultValue = "asc")String orderBy,
                                                     @RequestParam(value = "key",required = false)String key){
        PageResult<User> pageResult = userService.userList(page, size, vip,orderBy, liveStatus, type1, type2,key);
        return ResponseEntity.ok(pageResult);
    }

    /**
     * 初始化用户密码 返回状态码204
     * @param userId 用户id
     * @return
     */
    @PutMapping("/operation")
    public ResponseEntity<Void> userOperation(Long userId,
                                              @RequestParam(value = "changeLive",required = false)Integer liveStatus){
        userService.userOperation(userId,liveStatus);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PostMapping("/login")
    public ResponseEntity<Boolean> login(@RequestBody Admin admin){
        Boolean boo = adminService.login(admin);
        return ResponseEntity.ok(boo);
    }


}
