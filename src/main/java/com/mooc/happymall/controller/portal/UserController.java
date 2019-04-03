package com.mooc.happymall.controller.portal;

import com.mooc.happymall.common.Const;
import com.mooc.happymall.common.ResponseCode;
import com.mooc.happymall.common.ServerResponse;
import com.mooc.happymall.pojo.User;
import com.mooc.happymall.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * Created by qm
 */
@RestController
@RequestMapping("/user/")
public class UserController {


    @Autowired
    private IUserService iUserService;


    /**
     * 用户登录
     * @param username
     * @param password
     * @param session
     * @return
     */
    @PostMapping(value = "login")
    public ServerResponse<User> login(String username, String password, HttpSession session){
        ServerResponse<User> response = iUserService.login(username,password);
        if(response.isSuccess()){
            session.setAttribute(Const.CURRENT_USER,response.getData());
        }
        return response;
    }

    @PostMapping(value = "logout")
    public ServerResponse<String> logout(HttpSession session){
        session.removeAttribute(Const.CURRENT_USER);
        return ServerResponse.createBySuccess();
    }

    @PostMapping(value = "register")
    public ServerResponse<String> register(User user){
        return iUserService.register(user);
    }


    @PostMapping(value = "check_valid")
    public ServerResponse<String> checkValid(String str, String type){
        return iUserService.checkValid(str,type);
    }


    @PostMapping(value = "get_user_info")
    public ServerResponse<User> getUserInfo(HttpSession session){
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if(user != null){
            return ServerResponse.createBySuccess(user);
        }
        return ServerResponse.createByErrorMessage("用户未登录,无法获取当前用户的信息");
    }


    @PostMapping(value = "forget_get_question")
    public ServerResponse forgetGetQuestion(String username){
        return iUserService.selectQuestion(username);
    }


    @PostMapping(value = "forget_check_answer")
    public ServerResponse<String> forgetCheckAnswer(String username, String question, String answer){
        return iUserService.checkAnswer(username,question,answer);
    }


    @PostMapping(value = "forget_reset_password")
    public ServerResponse<String> forgetRestPassword(String username, String passwordNew, String forgetToken){
        return iUserService.forgetResetPassword(username,passwordNew,forgetToken);
    }



    @PostMapping(value = "reset_password")
    public ServerResponse<String> resetPassword(HttpSession session, String passwordOld, String passwordNew){
        User user = (User)session.getAttribute(Const.CURRENT_USER);
        if(user == null){
            return ServerResponse.createByErrorMessage("用户未登录");
        }
        return iUserService.resetPassword(passwordOld,passwordNew,user);
    }


    @PostMapping(value = "update_information")
    public ServerResponse<User> updateInformation(HttpSession session, User user){
        User currentUser = (User)session.getAttribute(Const.CURRENT_USER);
        if(currentUser == null){
            return ServerResponse.createByErrorMessage("用户未登录");
        }
        user.setId(currentUser.getId());
        user.setUsername(currentUser.getUsername());
        ServerResponse<User> response = iUserService.updateInformation(user);
        if(response.isSuccess()){
            response.getData().setUsername(currentUser.getUsername());
            session.setAttribute(Const.CURRENT_USER,response.getData());
        }
        return response;
    }

    @PostMapping(value = "get_information")
    public ServerResponse<User> getInformation(HttpSession session){
        User currentUser = (User)session.getAttribute(Const.CURRENT_USER);
        if(currentUser == null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),"未登录,需要强制登录status=10");
        }
        return iUserService.getInformation(currentUser.getId());
    }






























}
