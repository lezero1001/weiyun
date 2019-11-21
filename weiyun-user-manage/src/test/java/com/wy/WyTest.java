package com.wy;

import com.wy.bean.User;
import com.wy.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = WyUserManageApp.class)
public class WyTest {

    @Autowired
    private UserMapper userMapper;
    int i = 1;

    public void addTest(){
        User user = new User();
        user.setLiveStatus(1);
        user.setVip(0);
        user.setEmail("243243@qq.com");
        user.setIdCard("4345454324544");
        user.setPhone("18023453456");
        user.setPassword("123456");
        user.setType1(0);
        user.setType2(0);
        user.setName("ccc"+i);
        i++;
        userMapper.insertSelective(user);

    }
    @Test
    public void t(){
        for (int j = 0; j < 10; j++) {
            addTest();
        }
    }
}
