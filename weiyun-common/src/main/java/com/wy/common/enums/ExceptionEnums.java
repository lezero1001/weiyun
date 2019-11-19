package com.wy.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum ExceptionEnums {
    CODE_CHECK_ERROR(1000,"验证码不正确"),
    PRICE_CANNOT_BE_NULL(400,"价格不能为空"),
    CATEGORY_NOT_FOUND(404,"分类为空"),
    GOODS_NOT_FOUND(404,"商品为空"),
    SPEC_PARAM_NOT_FOUND(304,"规格为空"),
    GOODS_UPDATE_ERROR(501,"修改商品失败") ,
    INVALID_USERNAME_PASSWORD(1002,"用户名或密码不正确");
    private int code;
    private String msg;
}
