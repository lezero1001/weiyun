package com.wy.controller;

import com.wy.bean.User;
import com.wy.common.bean.PageResult;
import com.wy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserManageController {

    @Autowired
    private UserService userService;

    /**
     * 添加个人用户或企业用户，返回状态码201
     * @param user
     * @return
     */
    @PostMapping("/UM/add")
    public ResponseEntity<Void> addUser(User user){
        userService.addUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    /**
     * 修改个人用户或企业用户信息,返回状态码204
     * @param user
     * @return
     */
    @PutMapping("/UM/update")
    public ResponseEntity<Void> updateUser(User user){
        userService.updateUser(user);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    /**
     * 删除用户信息，返回状态码200
     * @param userId
     * @return
     */
    @DeleteMapping("/UM/delete")
    public ResponseEntity<Void> deleteUser(Long userId){
        userService.deleteUser(userId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    /**
     * 分页查看用户基本信息，返回PageResult<User>，状态码200
     * @param page  页数
     * @param size  每页数据量
     * @param vip   0：不是vip 1：是vip
     * @param live_status   0：封号状态  1：活跃状态
     * @param type1 0：车主    1：货主
     * @param type2 0：个人    1：企业
     * @param orderBy desc：降序    asc：升序
     * @return
     */
    @GetMapping("/UM/list")
    public ResponseEntity<PageResult<User>> userList(@RequestParam(value = "page",defaultValue = "1") Integer page,
                                                     @RequestParam(value = "size",defaultValue = "10")Integer size,
                                                     @RequestParam(value = "vip",defaultValue = "0")Integer vip,
                                                     @RequestParam(value = "live_status",defaultValue = "1")Integer live_status,
                                                     @RequestParam(value = "type1",defaultValue = "0")Integer type1,
                                                     @RequestParam(value = "type2",defaultValue = "0")Integer type2,
                                                     @RequestParam(value = "orderBy",defaultValue = "desc")String orderBy){
        PageResult<User> pageResult = userService.userList(page, size, vip,orderBy, live_status, type1, type2);
        return ResponseEntity.ok(pageResult);
    }

}
