package com.wy.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum ExceptionEnums {

    USER_NOT_FOUND(404,"用户不存在"),
    INVALID_USERNAME_PASSWORD(1002,"用户名或密码不正确");
    private int code;
    private String msg;
}
