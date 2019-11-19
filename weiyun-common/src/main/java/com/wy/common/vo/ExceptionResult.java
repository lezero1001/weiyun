package com.wy.common.vo;

import com.wy.common.enums.ExceptionEnums;
import lombok.Data;

@Data
public class ExceptionResult {
    private int status;
    private String message;
    private Long timestamp;

    public ExceptionResult(ExceptionEnums exceptionEnums){
        this.status = exceptionEnums.getCode();
        this.message = exceptionEnums.getMsg();
        this.timestamp = System.currentTimeMillis();
    }
}