package com.mooc.happymall.controller.portal;

import com.mooc.happymall.common.Const;
import com.mooc.happymall.common.ResponseCode;
import com.mooc.happymall.common.ServerResponse;
import com.mooc.happymall.pojo.User;
import com.mooc.happymall.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * Created by qm
 */
@RestController
@RequestMapping("/user/")
@Api(tags = "2.0", description = "用户相关接口", value = "用户相关接口")
@Slf4j
public class UserController {


    @Autowired
    private IUserService iUserService;

    /**
     * 用户登录
     *
     * @param username
     * @param password
     * @param session
     * @return
     */
    @PostMapping(value = "login")
    @ApiOperation(value = "用户登录", notes = "用户登录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名", required = true, dataType = "String"),
            @ApiImplicitParam(name = "password", value = "密码", required = true, dataType = "String"),
    })
    public ServerResponse<User> login(String username, String password, HttpSession session) {
        ServerResponse<User> response = iUserService.login(username, password);
        if (response.isSuccess()) {
            session.setAttribute(Const.CURRENT_USER, response.getData());
        }
        return response;
    }

    @PostMapping(value = "logout")
    @ApiOperation(value = "用户登出", notes = "用户登出")
    public ServerResponse<String> logout(HttpSession session) {
        session.removeAttribute(Const.CURRENT_USER);
        return ServerResponse.createBySuccess();
    }

    @PostMapping(value = "register")
    @ApiOperation(value = "用户注册", notes = "用户注册")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "user", value = "user", required = true, dataType = "User"),
    })
    public ServerResponse<String> register(User user) {
        return iUserService.register(user);
    }

    @PostMapping(value = "check_valid")
    @ApiOperation(value = "验证合法性", notes = "验证合法性")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "str", value = "", required = true, dataType = "String"),
            @ApiImplicitParam(name = "type", value = "", required = true, dataType = "String"),
    })
    public ServerResponse<String> checkValid(String str, String type) {
        return iUserService.checkValid(str, type);
    }


    @PostMapping(value = "get_user_info")
    @ApiOperation(value = "获取用户信息", notes = "获取用户信息")
    public ServerResponse<User> getUserInfo(HttpSession session) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user != null) {
            return ServerResponse.createBySuccess(user);
        }
        return ServerResponse.createByErrorMessage("用户未登录,无法获取当前用户的信息");
    }


    @PostMapping(value = "forget_get_question")
    @ApiOperation(value = "获取用户信息", notes = "获取用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名", required = true, dataType = "String"),
    })
    public ServerResponse forgetGetQuestion(String username) {
        return iUserService.selectQuestion(username);
    }


    @PostMapping(value = "forget_check_answer")
    @ApiOperation(value = "验证密保", notes = "验证密保")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名", required = true, dataType = "String"),
            @ApiImplicitParam(name = "question", value = "密保问题", required = true, dataType = "String"),
            @ApiImplicitParam(name = "answer", value = "密保答案", required = true, dataType = "String"),
    })
    public ServerResponse<String> forgetCheckAnswer(String username, String question, String answer) {
        return iUserService.checkAnswer(username, question, answer);
    }


    @PostMapping(value = "forget_reset_password")
    @ApiOperation(value = "忘记密码", notes = "忘记密码")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名", required = true, dataType = "String"),
            @ApiImplicitParam(name = "passwordNew", value = "新密码", required = true, dataType = "String"),
            @ApiImplicitParam(name = "forgetToken", value = "密保", required = true, dataType = "String"),
    })
    public ServerResponse<String> forgetRestPassword(String username, String passwordNew, String forgetToken) {
        return iUserService.forgetResetPassword(username, passwordNew, forgetToken);
    }


    @PostMapping(value = "reset_password")
    @ApiOperation(value = "重置密码", notes = "重置密码")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "passwordOld", value = "旧密码", required = true, dataType = "String"),
            @ApiImplicitParam(name = "passwordOld", value = "新密码", required = true, dataType = "String"),
    })
    public ServerResponse<String> resetPassword(HttpSession session, String passwordOld, String passwordNew) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorMessage("用户未登录");
        }
        return iUserService.resetPassword(passwordOld, passwordNew, user);
    }


    @PostMapping(value = "update_information")
    @ApiOperation(value = "更新用户信息", notes = "更新用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "user", value = "user", required = true, dataType = "User"),
    }) 
    public ServerResponse<User> updateInformation(HttpSession session, @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            log.error("【创建收货地址】参数不正确, user={}", user);
            return ServerResponse.createByErrorMessage(bindingResult.getFieldError().getDefaultMessage());
        }
        User currentUser = (User) session.getAttribute(Const.CURRENT_USER);
        if (currentUser == null) {
            return ServerResponse.createByErrorMessage("用户未登录");
        }
        user.setId(currentUser.getId());
        user.setUsername(currentUser.getUsername());
        ServerResponse<User> response = iUserService.updateInformation(user);
        if (response.isSuccess()) {
            response.getData().setUsername(currentUser.getUsername());
            session.setAttribute(Const.CURRENT_USER, response.getData());
        }
        return response;
    }

    @PostMapping(value = "get_information")
    @ApiOperation(value = "查询用户信息", notes = "查询用户信息")
    public ServerResponse<User> getInformation(HttpSession session) {
        User currentUser = (User) session.getAttribute(Const.CURRENT_USER);
        if (currentUser == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), "未登录,需要强制登录status=10");
        }
        return iUserService.getInformation(currentUser.getId());
    }


}
