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
@ApiModel(description = "支付信息",value = "支付信息")
public class PayInfo {

    @ApiModelProperty(name = "id",notes = "支付Id")
    private Integer id;

    @ApiModelProperty(name = "userId",notes = "用户Id")
    private Integer userId;

    @ApiModelProperty(name = "orderNo",notes = "订单号")
    private Long orderNo;

    @ApiModelProperty(name = "payPlatform",notes = "支付平台")
    private Integer payPlatform;

    @ApiModelProperty(name = "platformNumber",notes = "platformNumber")
    @NotBlank(message = "platformNumber不能为空")
    private String platformNumber;

    @ApiModelProperty(name = "platformStatus",notes = "支付宝支付状态")
    @NotBlank(message = "支付宝支付状态不能为空")
    private String platformStatus;

    @ApiModelProperty(name = "createTime",notes = "创建时间")
    private Date createTime;

    @ApiModelProperty(name = "updateTime",notes = "更新时间")
    private Date updateTime;

}