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
@ApiModel(description = "订单",value = "订单")
public class OrderItem {

    @ApiModelProperty(name = "id",notes = "订单子表id")
    private Integer id;

    @ApiModelProperty(name = "orderNo",notes = "订单号")
    private Long orderNo;

    @ApiModelProperty(name = "productId",notes = "商品Id")
    private Integer productId;

    @ApiModelProperty(name = "productName",notes = "商品名称")
    private String productName;

    @ApiModelProperty(name = "productImage",notes = "商品图片")
    private String productImage;

    @ApiModelProperty(name = "currentUnitPrice",notes = "生成订单时的商品单价")
    private BigDecimal currentUnitPrice;

    @ApiModelProperty(name = "quantity",notes = "商品数量")
    private Integer quantity;

    @ApiModelProperty(name = "totalPrice",notes = "商品总价")
    private BigDecimal totalPrice;

    @ApiModelProperty(name = "createTime",notes = "创建时间")
    private Date createTime;

    @ApiModelProperty(name = "updateTime",notes = "更新时间")
    private Date updateTime;

    @ApiModelProperty(name = "userId",notes = "用户Id")
    private Integer userId;
}