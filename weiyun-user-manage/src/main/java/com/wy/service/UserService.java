package com.wy.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wy.bean.User;
import com.wy.common.bean.PageResult;
import com.wy.common.enums.ExceptionEnums;
import com.wy.common.exception.WyException;
import com.wy.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import tk.mybatis.mapper.entity.Example;

import javax.validation.constraints.Max;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public void addUser(User user){
        
    }

    public void updateUser(User user) {
    }

    public void deleteUser(Long userId) {
        
    }

    // 分页查看用户
    public PageResult<User> userList(Integer page,Integer size,Integer vip,String orderBy,
                                     Integer live_status,Integer type1,Integer type2) {
        PageHelper.startPage(page-1,Math.max(size,20));
        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("vip",vip)
                .andEqualTo("type1",type1)
                .andEqualTo("type2",type2)
                .andEqualTo("live_status",live_status);
        example.orderBy("id"+orderBy);
        List<User> users = userMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(users)){
            throw new WyException(ExceptionEnums.USER_NOT_FOUND);
        }
        PageInfo<User> pageInfo = new PageInfo<>(users);
        PageResult<User> pageResult = new PageResult<>();
        pageResult.setTotal(pageInfo.getTotal());
        pageResult.setItems(pageInfo.getList());
        pageResult.setTotalPage((long)pageInfo.getPages());
        return pageResult;
    }

}
