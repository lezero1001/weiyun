package com.wy.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "wy.sms")
public class SmsProperties {
    String accessKeyId;
    String accessKeySecret;
    String signName;
    String verifyCodeTemplate;
}
