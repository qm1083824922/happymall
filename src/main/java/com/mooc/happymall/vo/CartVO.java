package com.mooc.happymall.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by qm
 */
@Getter
@Setter
@ApiModel
public class CartVO {

    private List<CartProductVO> cartProductVOList;

    private BigDecimal cartTotalPrice;

    @ApiModelProperty(name = "是否已经都勾选")
    private Boolean allChecked;

    private String imageHost;

}
