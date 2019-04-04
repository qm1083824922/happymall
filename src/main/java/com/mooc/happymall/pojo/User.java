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
@ApiModel(description = "用户信息",value = "用户信息")
public class User {
    private Integer id;

    @ApiModelProperty(name = "用户名")
    private String username;

    @ApiModelProperty(name = "用户密码")
    private String password;

    @ApiModelProperty(name = "用户邮箱")
    private String email;

    @ApiModelProperty(name = "用户手机号")
    private String phone;

    @ApiModelProperty(name = "用户密保")
    private String question;

    @ApiModelProperty(name = "用户密保答案")
    private String answer;

    @ApiModelProperty(name = "用户角色")
    private Integer role;

    @ApiModelProperty(name = "创建时间")
    private Date createTime;

    @ApiModelProperty(name = "更新时间")
    private Date updateTime;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question == null ? null : question.trim();
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer == null ? null : answer.trim();
    }


}