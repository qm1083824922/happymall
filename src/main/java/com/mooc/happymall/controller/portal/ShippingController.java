package com.mooc.happymall.controller.portal;

import com.github.pagehelper.PageInfo;
import com.mooc.happymall.common.Const;
import com.mooc.happymall.common.ResponseCode;
import com.mooc.happymall.common.ServerResponse;
import com.mooc.happymall.pojo.Shipping;
import com.mooc.happymall.pojo.User;
import com.mooc.happymall.service.IShippingService;
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
@RequestMapping("/shipping/")
@Api(tags = "2.0", description = "商品相关接口", value = "商品相关接口")
public class ShippingController {

    @Autowired
    private IShippingService iShippingService;

    @PostMapping("add")
    @ApiOperation(value = "增加收货地址", notes = "增加收货地址")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "shipping", value = "shipping",required = true,dataType = "Shipping"),
    })
    public ServerResponse add(HttpSession session, Shipping shipping) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
        }
        return iShippingService.add(user.getId(), shipping);
    }

    @PostMapping("delete")
    @ApiOperation(value = "删除收货地址", notes = "删除收货地址")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "shippingId", value = "shippingId",required = true,dataType = "Integer"),
    })
    public ServerResponse delete(HttpSession session, Integer shippingId) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
        }
        return iShippingService.delete(user.getId(), shippingId);
    }

    @PostMapping("update")
    @ApiOperation(value = "更新收货地址", notes = "更新收货地址")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "shipping", value = "shipping",required = true,dataType = "Shipping"),
    })
    public ServerResponse update(HttpSession session, Shipping shipping) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
        }
        return iShippingService.update(user.getId(), shipping);
    }

    @PostMapping("select")
    @ApiOperation(value = "选择收货地址", notes = "选择收货地址")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "shippingId", value = "shippingId",required = true,dataType = "Integer"),
    })
    public ServerResponse<Shipping> select(HttpSession session, Integer shippingId) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
        }
        return iShippingService.select(user.getId(), shippingId);
    }

    @PostMapping("list")
    @ApiOperation(value = "显示收货地址", notes = "显示收货地址")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "第几页",required = true,dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "每页显示大小",required = true,dataType = "Integer"),
    })
    public ServerResponse<PageInfo> list(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                         @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                         HttpSession session) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
        }
        return iShippingService.list(user.getId(), pageNum, pageSize);
    }


}
