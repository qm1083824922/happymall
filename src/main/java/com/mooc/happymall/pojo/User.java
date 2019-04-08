package com.mooc.happymall.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ApiModel(description = "用户信息",value = "用户信息")
public class User {

    @ApiModelProperty(name = "id",notes = "用户Id")
    private Integer id;

    @ApiModelProperty(name = "username",notes = "用户名")
    @NotBlank(message = "用户名不能为空")
    @Size(min=3, max=20, message="用户名长度只能在3-20之间")
    private String username;

    @ApiModelProperty(name = "password",notes = "密码")
    @NotBlank(message = "密码不能为空")
    @Size (min=6, max=18, message="密码长度只能在6-18之间")
    private String password;

    @ApiModelProperty(name = "email",notes = "邮箱")
    @NotBlank(message = "邮箱不能为空")
    @Pattern(regexp="[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}", message="邮件格式错误")
    private String email;

    @ApiModelProperty(name = "phone",notes = "手机号")
    @NotBlank(message = "手机号不能为空")
    @Pattern(regexp="^(13[0-9]|14[579]|15[0-3,5-9]|16[6]|17[0135678]|18[0-9]|19[89])\\\\d{8}$", message="手机号格式错误")
    private String phone;

    @ApiModelProperty(name = "question",notes = "密保")
    @NotBlank(message = "密保不能为空")
    private String question;

    @ApiModelProperty(name = "answer",notes = "密保答案")
    @NotBlank(message = "密保答案不能为空")
    private String answer;

    @ApiModelProperty(name = "role",notes = "用户角色")
    private Integer role;

    @ApiModelProperty(name = "createTime",notes = "创建时间")
    private Date createTime;

    @ApiModelProperty(name = "updateTime",notes = "更新时间")
    private Date updateTime;

}