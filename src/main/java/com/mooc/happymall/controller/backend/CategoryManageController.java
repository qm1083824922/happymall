package com.mooc.happymall.controller.backend;

import com.mooc.happymall.common.Const;
import com.mooc.happymall.common.ResponseCode;
import com.mooc.happymall.common.ServerResponse;
import com.mooc.happymall.pojo.User;
import com.mooc.happymall.service.ICategoryService;
import com.mooc.happymall.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * Created by qm
 */
@RestController
@RequestMapping("/manage/category")
@Api(tags = "2.0", description = "分类管理", value = "分类管理")
public class CategoryManageController {


    @Autowired
    private IUserService iUserService;

    @GetMapping("set_category_name")
    @ApiOperation(value = "添加", notes = "添加分类")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "categoryId", value = "categoryId", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "categoryName", value = "categoryName", required = true, dataType = "String")
    })
    public ServerResponse setCategoryName(HttpSession session, Integer categoryId, String categoryName) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), "用户未登录,请登录");
        }
        if (iUserService.checkAdminRole(user).isSuccess()) {
            //更新categoryName
            return iCategoryService.updateCategoryName(categoryId, categoryName);
        } else {
            return ServerResponse.createByErrorMessage("无权限操作,需要管理员权限");
        }
    }

    @Autowired
    private ICategoryService iCategoryService;

    @GetMapping(value = "add_category")
    @ApiOperation(value = "添加", notes = "添加分类")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "categoryName", value = "categoryName", required = true, dataType = "String"),
            @ApiImplicitParam(name = "parentId", value = "父分类", required = true, dataType = "Integer")
    })
    public ServerResponse addCategory(HttpSession session, String categoryName, @RequestParam(value = "parentId", defaultValue = "0") int parentId) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), "用户未登录,请登录");
        }
        //校验一下是否是管理员
        if (iUserService.checkAdminRole(user).isSuccess()) {
            //是管理员
            //增加我们处理分类的逻辑
            return iCategoryService.addCategory(categoryName, parentId);

        } else {
            return ServerResponse.createByErrorMessage("无权限操作,需要管理员权限");
        }
    }

    @GetMapping("get_category")
    @ApiOperation(value = "获取", notes = "获取子分类")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "categoryId", value = "获取子分类", required = true, dataType = "Integer")
    })
    public ServerResponse getChildrenParallelCategory(HttpSession session, @RequestParam(value = "categoryId", defaultValue = "0") Integer categoryId) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), "用户未登录,请登录");
        }
        if (iUserService.checkAdminRole(user).isSuccess()) {
            //查询子节点的category信息,并且不递归,保持平级
            return iCategoryService.getChildrenParallelCategory(categoryId);
        } else {
            return ServerResponse.createByErrorMessage("无权限操作,需要管理员权限");
        }
    }

    @GetMapping("get_deep_category")
    @ApiOperation(value = "获取", notes = "获取分类与子分类")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "categoryId", value = "父分类Id", required = true, dataType = "Integer")
    })
    public ServerResponse getCategoryAndDeepChildrenCategory(HttpSession session, @RequestParam(value = "categoryId", defaultValue = "0") Integer categoryId) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), "用户未登录,请登录");
        }
        if (iUserService.checkAdminRole(user).isSuccess()) {
            //查询当前节点的id和递归子节点的id
            //0->10000->100000
            return iCategoryService.selectCategoryAndChildrenById(categoryId);

        } else {
            return ServerResponse.createByErrorMessage("无权限操作,需要管理员权限");
        }
    }
}
