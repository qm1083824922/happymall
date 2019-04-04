package com.mooc.happymall.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

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

    @ApiModelProperty(name = "商品Id")
    private Integer id;

    @ApiModelProperty(name = "分类Id")
    private Integer categoryId;

    @ApiModelProperty(name = "商品名称")
    private String name;

    @ApiModelProperty(name = "商品副标题")
    private String subtitle;

    @ApiModelProperty(name = "商品大图")
    private String mainImage;

    @ApiModelProperty(name = "商品小图")
    private String subImages;

    @ApiModelProperty(name = "商品详情")
    private String detail;

    @ApiModelProperty(name = "商品价格")
    private BigDecimal price;

    @ApiModelProperty(name = "商品库存")
    private Integer stock;

    @ApiModelProperty(name = "商品状态")
    private Integer status;

    @ApiModelProperty(name = "创建时间")
    private Date createTime;

    @ApiModelProperty(name = "更新时间")
    private Date updateTime;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle == null ? null : subtitle.trim();
    }

    public String getMainImage() {
        return mainImage;
    }

    public void setMainImage(String mainImage) {
        this.mainImage = mainImage == null ? null : mainImage.trim();
    }

    public String getSubImages() {
        return subImages;
    }

    public void setSubImages(String subImages) {
        this.subImages = subImages == null ? null : subImages.trim();
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail == null ? null : detail.trim();
    }

}