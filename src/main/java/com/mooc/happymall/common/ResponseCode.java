package com.mooc.happymall.common;

import lombok.Getter;

/**
 * Created by qm
 * @author Administrator
 */
@Getter
public enum ResponseCode {
    /**
     *返回状态码
     */
    SUCCESS(0,"SUCCESS"),
    ERROR(1,"ERROR"),
    NEED_LOGIN(10,"NEED_LOGIN"),
    ILLEGAL_ARGUMENT(2,"ILLEGAL_ARGUMENT");

    private final int code;
    private final String desc;


    ResponseCode(int code, String desc){
        this.code = code;
        this.desc = desc;
    }

}
