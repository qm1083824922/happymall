package com.mooc.happymall.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ApiModel(description = "订单信息",value = "订单信息")
public class Order {

    @ApiModelProperty(name = "订单Id")
    private Integer id;

    @ApiModelProperty(name = "订单编号")
    private Long orderNo;

    @ApiModelProperty(name = "用户Id")
    private Integer userId;

    @ApiModelProperty(name = "")
    private Integer shippingId;

    @ApiModelProperty(name = "实际付款金额")
    private BigDecimal payment;

    @ApiModelProperty(name = "支付类型")
    private Integer paymentType;

    @ApiModelProperty(name = "运费")
    private Integer postage;

    @ApiModelProperty(name = "订单状态")
    private Integer status;

    @ApiModelProperty(name = "支付时间")
    private Date paymentTime;

    @ApiModelProperty(name = "发货时间")
    private Date sendTime;

    @ApiModelProperty(name = "交易完成时间")
    private Date endTime;

    @ApiModelProperty(name = "交易关闭时间")
    private Date closeTime;

    @ApiModelProperty(name = "创建时间")
    private Date createTime;

    @ApiModelProperty(name = "更新时间")
    private Date updateTime;
}