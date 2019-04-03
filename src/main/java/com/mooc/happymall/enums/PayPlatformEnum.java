package com.mooc.happymall.enums;

import lombok.Getter;

/**
 * @author Administrator
 */

@Getter
public enum PayPlatformEnum {
    /**
     * 支付平台
     */
    ALIPAY(1,"支付宝");

    private String value;
    private int code;

    PayPlatformEnum(int code, String value){
        this.code = code;
        this.value = value;
    }

}
