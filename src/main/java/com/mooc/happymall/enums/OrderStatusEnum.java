package com.mooc.happymall.enums;

import lombok.Getter;

/**
 * @author Administrator
 */

@Getter
public enum OrderStatusEnum {
    /**
     * 订单状态
     */
    CANCELED(0,"已取消"),
    NO_PAY(10,"未支付"),
    PAID(20,"已付款"),
    SHIPPED(40,"已发货"),
    ORDER_SUCCESS(50,"订单完成"),
    ORDER_CLOSE(60,"订单关闭");

    OrderStatusEnum(int code, String value){
        this.code = code;
        this.value = value;
    }
    private String value;
    private int code;

    public static OrderStatusEnum codeOf(int code){
        for(OrderStatusEnum orderStatusEnum : values()){
            if(orderStatusEnum.getCode() == code){
                return orderStatusEnum;
            }
        }
        throw new RuntimeException("没有找到对应的枚举");
    }
}
