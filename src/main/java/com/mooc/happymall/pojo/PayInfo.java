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
@ApiModel(description = "支付信息",value = "支付信息")
public class PayInfo {

    private Integer id;

    @ApiModelProperty(name = "用户Id")
    private Integer userId;

    @ApiModelProperty(name = "订单号")
    private Long orderNo;

    @ApiModelProperty(name = "支付平台")
    private Integer payPlatform;

    @ApiModelProperty(name = "支付宝支付流水号")
    private String platformNumber;

    @ApiModelProperty(name = "支付宝支付状态")
    private String platformStatus;

    @ApiModelProperty(name = "创建时间")
    private Date createTime;

    @ApiModelProperty(name = "更新时间")
    private Date updateTime;

    public String getPlatformNumber() {
        return platformNumber;
    }

    public void setPlatformNumber(String platformNumber) {
        this.platformNumber = platformNumber == null ? null : platformNumber.trim();
    }

    public String getPlatformStatus() {
        return platformStatus;
    }

    public void setPlatformStatus(String platformStatus) {
        this.platformStatus = platformStatus == null ? null : platformStatus.trim();
    }

}