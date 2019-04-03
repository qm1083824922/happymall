package com.mooc.happymall.vo;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by qm
 */
@Getter
@Setter
public class CartVO {

    private List<CartProductVO> cartProductVOList;

    private BigDecimal cartTotalPrice;
    /**
     * 是否已经都勾选
     */
    private Boolean allChecked;

    private String imageHost;

}
