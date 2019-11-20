package com.wy.service;

import com.wy.bean.User;
import com.wy.common.enums.ExceptionEnums;
import com.wy.common.exception.WlkgException;
import com.wy.common.utils.CodecUtils;
import com.wy.common.utils.NumberUtils;
import com.wy.mapper.UserMapper;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private AmqpTemplate amqpTemplate;

    static final String KEY_PREFIX = "user:code:phone:";

    /**用户登陆*/
    public User queryUser(String username, String password) {
        User user = new User();
        user.setName(username);
        User retUser = userMapper.selectOne(user);
        if(retUser == null){
            throw new WlkgException(ExceptionEnums.INVALID_USERNAME_PASSWORD);
        }

        String md5Pwd = CodecUtils.md5Hex(password,retUser.getSalt());
        if(!retUser.getPassword().equals(md5Pwd)){
            throw new WlkgException(ExceptionEnums.INVALID_USERNAME_PASSWORD);
        }else {
            return retUser;
        }
    }

    /**发送短信*/
    public Boolean sendVerifyCode(String phone) {
        String code = NumberUtils.generateCode(6);

        try {
            redisTemplate.opsForValue().set(KEY_PREFIX+phone,code,5, TimeUnit.MINUTES);

            Map<String,String> map = new HashMap<>();
            map.put("code",code);
            map.put("phone",phone);
            amqpTemplate.convertAndSend("wy.sms.exchange","sms.verify.code",map);
            return true;
        }catch (AmqpException e){
            e.printStackTrace();
            return false;
        }
    }


    /**注册*/
    public void register(User user, String code) {
        String prefix = KEY_PREFIX + user.getPhone();
        String redisCode = redisTemplate.opsForValue().get(prefix);
        //判断验证码是否正确
        if(!code.equals(redisCode)){
            throw new WlkgException(ExceptionEnums.CODE_CHECK_ERROR);
        }
        //生成盐
        String salt = CodecUtils.generateSalt();
        user.setSalt(salt);
        //对密码加密
        user.setPassword(CodecUtils.md5Hex(user.getPassword(),salt));

        //写入数据库
        if(userMapper.insert(user) == 1){
            //删除redis中的验证码
            redisTemplate.delete(prefix);
        }
    }
}
