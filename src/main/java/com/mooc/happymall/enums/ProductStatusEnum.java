package com.mooc.happymall.enums;

import lombok.Getter;

/**
 * @author Administrator
 */

@Getter
public enum ProductStatusEnum {

    /**
     * 商品状态
     */
    ON_SALE(1,"在线");

    private String value;
    private int code;

    ProductStatusEnum(int code, String value){
        this.code = code;
        this.value = value;
    }
}
