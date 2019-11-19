package com.wy.common.exception;

import com.wy.common.enums.ExceptionEnums;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class WlkgException extends RuntimeException {
    private ExceptionEnums exceptionEnums;
}
