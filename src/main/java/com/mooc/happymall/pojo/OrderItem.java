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

    @ApiModelProperty(name = "订单子表id")
    private Integer id;

    @ApiModelProperty(name = "订单号")
    private Long orderNo;

    @ApiModelProperty(name = "商品Id")
    private Integer productId;

    @ApiModelProperty(name = "商品名称")
    private String productName;

    @ApiModelProperty(name = "商品图片")
    private String productImage;

    @ApiModelProperty(name = "生成订单时的商品单价")
    private BigDecimal currentUnitPrice;

    @ApiModelProperty(name = "商品数量")
    private Integer quantity;

    @ApiModelProperty(name = "商品总价")
    private BigDecimal totalPrice;

    @ApiModelProperty(name = "创建时间")
    private Date createTime;

    @ApiModelProperty(name = "更新时间")
    private Date updateTime;

    @ApiModelProperty(name = "用户Id")
    private Integer userId;
}