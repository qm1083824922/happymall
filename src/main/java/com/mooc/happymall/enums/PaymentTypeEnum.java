package com.mooc.happymall.enums;

import com.mooc.happymall.common.Const;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author Administrator
 */

@Getter
public enum PaymentTypeEnum {
    /**
     * 支付类型
     */
    ONLINE_PAY(1,"在线支付");

    private String value;
    private int code;

    PaymentTypeEnum(int code, String value){
        this.code = code;
        this.value = value;
    }

    public static PaymentTypeEnum codeOf(int code){
        for(PaymentTypeEnum paymentTypeEnum : values()){
            if(paymentTypeEnum.getCode() == code){
                return paymentTypeEnum;
            }
        }
        throw new RuntimeException("没有找到对应的枚举");
    }
}
