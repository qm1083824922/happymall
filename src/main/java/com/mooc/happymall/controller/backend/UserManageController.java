package com.mooc.happymall.controller.backend;

import com.mooc.happymall.common.Const;
import com.mooc.happymall.common.ServerResponse;
import com.mooc.happymall.pojo.User;
import com.mooc.happymall.service.IUserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * Created by qm
 */

@RestController
@RequestMapping("/manage/user")
@Api(tags = "2.0", description = "用户管理", value = "用户管理")
public class UserManageController {

    @Autowired
    private IUserService iUserService;

    @RequestMapping(value="login",method = RequestMethod.POST)
    public ServerResponse<User> login(String username, String password, HttpSession session){
        ServerResponse<User> response = iUserService.login(username,password);
        if(response.isSuccess()){
            User user = response.getData();
            if(user.getRole() == Const.Role.ROLE_ADMIN){
                //说明登录的是管理员
                session.setAttribute(Const.CURRENT_USER,user);
                return response;
            }else{
                return ServerResponse.createByErrorMessage("不是管理员,无法登录");
            }
        }
        return response;
    }

}
