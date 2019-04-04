package com.mooc.happymall.vo;

import io.swagger.annotations.ApiModel;
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
public class OrderProductVO {

    private List<OrderItemVO> orderItemVOList;

    private BigDecimal productTotalPrice;

    private String imageHost;

}
