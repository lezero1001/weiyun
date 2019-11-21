package com.wy.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wy.bean.User;
import com.wy.common.bean.PageResult;
import com.wy.common.enums.ExceptionEnums;
import com.wy.common.exception.WyException;
import com.wy.mapper.UserMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public void addUser(User user){
        user.setLiveStatus(1);
        userMapper.insertSelective(user);
    }

    public void updateUser(User user) {
        int rows = userMapper.updateByPrimaryKeySelective(user);
        if (rows == 0)
            throw new WyException(ExceptionEnums.USER_NOT_FOUND);
    }

    public void deleteUser(Long userId) {
        int rows = userMapper.deleteByPrimaryKey(userId);
        if (rows == 0)
        throw new WyException(ExceptionEnums.USER_NOT_FOUND);
    }

    // 分页查看用户
    public PageResult<User> userList(Integer page,Integer size,Integer vip,String orderBy,
                                     Integer liveStatus,Integer type1,Integer type2,String key) {
        PageHelper.startPage(page-1,Math.min(size,20));
        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("vip",vip)
                .andEqualTo("type1",type1)
                .andEqualTo("type2",type2)
                .andEqualTo("liveStatus",liveStatus);
        example.setOrderByClause("id "+orderBy);
        // 是否模糊查询
        if (StringUtils.isNotBlank(key)) {
            criteria.andLike("name", "%" + key + "%");
        }
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
