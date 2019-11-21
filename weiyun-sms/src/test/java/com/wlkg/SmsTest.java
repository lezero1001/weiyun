package com.wlkg;

import com.wy.WySmsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = WySmsService.class)
public class SmsTest {
    @Autowired
    private AmqpTemplate amqpTemplate;

    @Test
    public void sendTest() {
        Map<String,String> map = new HashMap<>();
        map.put("phone", "13004004329");
        map.put("code","666233");
        amqpTemplate.convertAndSend("wy.sms.exchange","sms.verify.code",map);

    }
}