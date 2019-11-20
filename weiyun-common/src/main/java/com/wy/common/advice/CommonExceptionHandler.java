package com.wy.common.advice;


import com.wy.common.enums.ExceptionEnums;
import com.wy.common.exception.WyException;
import com.wy.common.vo.ExceptionResult;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CommonExceptionHandler {
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ExceptionResult> handlerException(WyException e){
        ExceptionEnums em = e.getExceptionEnums();
        return ResponseEntity.status(HttpStatus.OK).body(new ExceptionResult(em));
    }
}
