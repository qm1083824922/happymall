package com.mooc.happymall.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * Created by qm
 * 结合了产品和购物车的一个抽象对象
 * @author Administrator
 */
@Getter
@Setter
@ApiModel(description = "购物车中的商品",value = "购物车中的商品")
public class CartProductVO {

    private Integer id;

    private Integer userId;

    private Integer productId;

    @ApiModelProperty(notes = "购物车中此商品的数量")
    private Integer quantity;

    private String productName;

    private String productSubtitle;

    private String productMainImage;

    private BigDecimal productPrice;

    private Integer productStatus;

    private BigDecimal productTotalPrice;

    private Integer productStock;

    @ApiModelProperty(name = "此商品是否勾选")
    private Integer productChecked;

    @ApiModelProperty(name = "限制数量的一个返回结果")
    private String limitQuantity;

}
