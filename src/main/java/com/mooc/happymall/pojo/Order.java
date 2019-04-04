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

    @ApiModelProperty(name = "id",notes = "订单Id")
    private Integer id;

    @ApiModelProperty(name = "orderNo",notes = "订单编号")
    private Long orderNo;

    @ApiModelProperty(name = "userId",notes = "用户Id")
    private Integer userId;

    @ApiModelProperty(name = "shippingId",notes = "")
    private Integer shippingId;

    @ApiModelProperty(name = "payment",notes = "实际付款金额")
    private BigDecimal payment;

    @ApiModelProperty(name = "paymentType",notes = "支付类型")
    private Integer paymentType;

    @ApiModelProperty(name = "postage",notes = "运费")
    private Integer postage;

    @ApiModelProperty(name = "status",notes = "订单状态")
    private Integer status;

    @ApiModelProperty(name = "paymentTime",notes = "支付时间")
    private Date paymentTime;

    @ApiModelProperty(name = "sendTime",notes = "发货时间")
    private Date sendTime;

    @ApiModelProperty(name = "endTime",notes = "交易完成时间")
    private Date endTime;

    @ApiModelProperty(name = "closeTime",notes = "交易关闭时间")
    private Date closeTime;

    @ApiModelProperty(name = "createTime",notes = "创建时间")
    private Date createTime;

    @ApiModelProperty(name = "updateTime",notes = "更新时间")
    private Date updateTime;
}