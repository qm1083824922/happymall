package com.mooc.happymall.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ApiModel(description = "收货地址",value = "收货地址")
public class Shipping {

    @ApiModelProperty(name = "id",notes = "收货地址Id")
    private Integer id;

    @ApiModelProperty(name = "userId",notes = "用户Id")
    private Integer userId;

    @ApiModelProperty(name = "receiverName",notes = "收货人姓名")
    @NotBlank(message = "收货人姓名不能为空")
    private String receiverName;

    @ApiModelProperty(name = "receiverName",notes = "收货人固定电话")
    @NotBlank(message = "收货人固定电话不能为空")
    private String receiverPhone;

    @ApiModelProperty(name = "receiverMobile",notes = "收货人移动电话")
    @NotBlank(message = "收货人移动电话不能为空")
    private String receiverMobile;

    @ApiModelProperty(name = "receiverProvince",notes = "省")
    @NotBlank(message = "省不能为空")
    private String receiverProvince;

    @ApiModelProperty(name = "receiverCity",notes = "市")
    @NotBlank(message = "市不能为空")
    private String receiverCity;

    @ApiModelProperty(name = "receiverDistrict",notes = "区")
    @NotBlank(message = "区不能为空")
    private String receiverDistrict;

    @ApiModelProperty(name = "receiverAddress",notes = "收货地址")
    @NotBlank(message = "收货地址不能为空")
    private String receiverAddress;

    @ApiModelProperty(name = "receiverZip",notes = "邮编")
    @NotBlank(message = "邮编不能为空")
    private String receiverZip;

    @ApiModelProperty(name = "createTime",notes = "创建时间")
    private Date createTime;

    @ApiModelProperty(name = "updateTime",notes = "更新时间")
    private Date updateTime;

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName == null ? null : receiverName.trim();
    }

    public String getReceiverPhone() {
        return receiverPhone;
    }

    public void setReceiverPhone(String receiverPhone) {
        this.receiverPhone = receiverPhone == null ? null : receiverPhone.trim();
    }

    public String getReceiverMobile() {
        return receiverMobile;
    }

    public void setReceiverMobile(String receiverMobile) {
        this.receiverMobile = receiverMobile == null ? null : receiverMobile.trim();
    }

    public String getReceiverProvince() {
        return receiverProvince;
    }

    public void setReceiverProvince(String receiverProvince) {
        this.receiverProvince = receiverProvince == null ? null : receiverProvince.trim();
    }

    public String getReceiverCity() {
        return receiverCity;
    }

    public void setReceiverCity(String receiverCity) {
        this.receiverCity = receiverCity == null ? null : receiverCity.trim();
    }

    public String getReceiverDistrict() {
        return receiverDistrict;
    }

    public void setReceiverDistrict(String receiverDistrict) {
        this.receiverDistrict = receiverDistrict == null ? null : receiverDistrict.trim();
    }

    public String getReceiverAddress() {
        return receiverAddress;
    }

    public void setReceiverAddress(String receiverAddress) {
        this.receiverAddress = receiverAddress == null ? null : receiverAddress.trim();
    }

    public String getReceiverZip() {
        return receiverZip;
    }

    public void setReceiverZip(String receiverZip) {
        this.receiverZip = receiverZip == null ? null : receiverZip.trim();
    }
}