package com.wy.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 */
public class PasswordUtil {

    public static String encode(String raw) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(raw);
    }

    public static boolean match(String raw, String pwd) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.matches(raw, pwd);
    }



}
