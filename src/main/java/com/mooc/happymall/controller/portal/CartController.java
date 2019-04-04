package com.mooc.happymall.controller.portal;

import com.mooc.happymall.common.Const;
import com.mooc.happymall.common.ResponseCode;
import com.mooc.happymall.common.ServerResponse;
import com.mooc.happymall.pojo.User;
import com.mooc.happymall.service.ICartService;
import com.mooc.happymall.vo.CartVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
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
@RequestMapping("/cart/")
@Api(tags = "2.0", description = "购物车相关接口", value = "购物车相关接口")
public class CartController {

    @Autowired
    private ICartService iCartService;
    
    @PostMapping("list")
    @ApiOperation(value = "列表", notes = "显示购物车中的商品")
    public ServerResponse<CartVO> list(HttpSession session){
        User user = (User)session.getAttribute(Const.CURRENT_USER);
        if(user == null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),ResponseCode.NEED_LOGIN.getDesc());
        }
        return iCartService.list(user.getId());
    }

    @PostMapping("add")
    @ApiOperation(value = "添加", notes = "添加商品到购物车")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "count", value = "商品数量", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "productId", value = "商品Id", required = true, dataType = "Integer")
    })
    public ServerResponse<CartVO> add(HttpSession session, Integer count, Integer productId){
        User user = (User)session.getAttribute(Const.CURRENT_USER);
        if(user == null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),ResponseCode.NEED_LOGIN.getDesc());
        }
        return iCartService.add(user.getId(),productId,count);
    }

    @PostMapping("update")
    @ApiOperation(value = "更新", notes = "更新商品到购物车")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "count", value = "商品数量", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "productId", value = "商品Id", required = true, dataType = "Integer")
    })
    public ServerResponse<CartVO> update(HttpSession session, Integer count, Integer productId){
        User user = (User)session.getAttribute(Const.CURRENT_USER);
        if(user == null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),ResponseCode.NEED_LOGIN.getDesc());
        }
        return iCartService.update(user.getId(),productId,count);
    }

    @PostMapping("delete_product")
    @ApiOperation(value = "删除", notes = "删除购物车中的商品")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "productIds", value = "商品Id", required = true, dataType = "String")
    })
    public ServerResponse<CartVO> deleteProduct(HttpSession session, String productIds){
        User user = (User)session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
        }
        return iCartService.deleteProduct(user.getId(),productIds);
    }
    
    @PostMapping("select_all")
    @ApiOperation(value = "全选", notes = "全部选中购物车中的商品")
    public ServerResponse<CartVO> selectAll(HttpSession session){
        User user = (User)session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getDesc());
        }
        return iCartService.selectOrUnSelect(user.getId(),null,Const.Cart.CHECKED);
    }

    @PostMapping("un_select_all")
    @ApiOperation(value = "全反选", notes = "全反选购物车中的商品")
    public ServerResponse<CartVO> unSelectAll(HttpSession session){
        User user = (User)session.getAttribute(Const.CURRENT_USER);
        if(user == null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),ResponseCode.NEED_LOGIN.getDesc());
        }
        return iCartService.selectOrUnSelect(user.getId(),null,Const.Cart.UN_CHECKED);
    }
    
    @PostMapping("select")
    @ApiOperation(value = "单选", notes = "单独选中")
    public ServerResponse<CartVO> select(HttpSession session, Integer productId){
        User user = (User)session.getAttribute(Const.CURRENT_USER);
        if(user == null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),ResponseCode.NEED_LOGIN.getDesc());
        }
        return iCartService.selectOrUnSelect(user.getId(),productId,Const.Cart.CHECKED);
    }

    @PostMapping("un_select")
    @ApiOperation(value = "单独反选", notes = "单独反选")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "productId", value = "商品Id", required = true, dataType = "Integer")
    })
    public ServerResponse<CartVO> unSelect(HttpSession session, Integer productId){
        User user = (User)session.getAttribute(Const.CURRENT_USER);
        if(user == null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),ResponseCode.NEED_LOGIN.getDesc());
        }
        return iCartService.selectOrUnSelect(user.getId(),productId,Const.Cart.UN_CHECKED);
    }

    /**
     * 查询当前用户的购物车里面的产品数量,如果一个产品有10个,那么数量就是10.
     */
    @PostMapping("get_cart_product_count")
    @ApiOperation(value = "查询", notes = "查询购物车中的数量")
    public ServerResponse<Integer> getCartProductCount(HttpSession session){
        User user = (User)session.getAttribute(Const.CURRENT_USER);
        if(user == null){
            return ServerResponse.createBySuccess(0);
        }
        return iCartService.getCartProductCount(user.getId());
    }
    

}
