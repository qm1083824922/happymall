package com.mooc.happymall.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ApiModel(description = "购物车信息",value = "购物车信息")
public class Cart {

    private Integer id;

    @ApiModelProperty(name = "userId",notes = "用户Id")
    private Integer userId;

    @ApiModelProperty(name = "productId",notes = "商品Id")
    private Integer productId;

    @ApiModelProperty(name = "quantity",notes = "购物车数量")
    private Integer quantity;

    @ApiModelProperty(name = "checked",notes = "是否选择")
    private Integer checked;

    @ApiModelProperty(name = "createTime",notes = "创建时间")
    private Date createTime;

    @ApiModelProperty(name = "updateTime",notes = "创建时间")
    private Date updateTime;

}