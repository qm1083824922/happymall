package com.mooc.happymall.controller.portal;

import com.github.pagehelper.PageInfo;
import com.mooc.happymall.common.ServerResponse;
import com.mooc.happymall.service.IProductService;
import com.mooc.happymall.vo.ProductDetailVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by qm
 */

@RestController
@RequestMapping("/product/")
@Api(tags = "2.0", description = "商品相关接口", value = "商品相关接口")
public class ProductController {

    @Autowired
    private IProductService iProductService;

    @PostMapping("detail")
    @ApiOperation(value = "显示商品详情", notes = "显示商品详情")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "productId", value = "productId", required = true, dataType = "Integer")
    })
    public ServerResponse<ProductDetailVO> detail(Integer productId) {
        return iProductService.getProductDetail(productId);
    }

    @PostMapping("list")
    @ApiOperation(value = "显示商品列表", notes = "显示商品列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "keyword", value = "关键字", required = true, dataType = "String"),
            @ApiImplicitParam(name = "categoryId", value = "分类Id", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "pageNum", value = "第几页", dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "每页显示大小", dataType = "Integer"),
            @ApiImplicitParam(name = "orderBy", value = "排序方式", dataType = "String"),
    })
    public ServerResponse<PageInfo> list(@RequestParam(value = "keyword", required = false) String keyword,
                                         @RequestParam(value = "categoryId", required = false) Integer categoryId,
                                         @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                         @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                         @RequestParam(value = "orderBy", defaultValue = "") String orderBy) {
        return iProductService.getProductByKeywordCategory(keyword, categoryId, pageNum, pageSize, orderBy);
    }


}
