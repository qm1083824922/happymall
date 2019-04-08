package com.mooc.happymall.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Administrator
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ApiModel(description = "商品信息",value = "商品信息")
public class Product {

    @ApiModelProperty(name = "id",notes = "商品Id")
    private Integer id;

    @ApiModelProperty(name = "categoryId",notes = "分类Id")
    private Integer categoryId;

    @ApiModelProperty(name = "name",notes = "商品名称")
    @NotBlank(message = "商品名称不能为空")
    private String name;

    @ApiModelProperty(name = "subtitle",notes = "商品副标题")
    @NotBlank(message = "商品副标题不能为空")
    private String subtitle;

    @ApiModelProperty(name = "mainImage",notes = "商品大图")
    @NotBlank(message = "商品副标题不能为空")
    private String mainImage;

    @ApiModelProperty(name = "subImages",notes = "商品小图")
    @NotBlank(message = "商品小图不能为空")
    private String subImages;

    @ApiModelProperty(name = "detail",notes = "商品详情")
    @NotBlank(message = "商品详情不能为空")
    private String detail;

    @ApiModelProperty(name = "price",notes = "商品价格")
    private BigDecimal price;

    @ApiModelProperty(name = "stock",notes = "商品库存")
    private Integer stock;

    @ApiModelProperty(name = "status",notes = "商品状态")
    private Integer status;

    @ApiModelProperty(name = "createTime",notes = "创建时间")
    private Date createTime;

    @ApiModelProperty(name = "updateTime",notes = "更新时间")
    private Date updateTime;

}