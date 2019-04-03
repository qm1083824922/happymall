package com.mooc.happymall.controller.portal;

import com.github.pagehelper.PageInfo;
import com.mooc.happymall.common.ServerResponse;
import com.mooc.happymall.service.IProductService;
import com.mooc.happymall.vo.ProductDetailVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by qm
 */

@RestController
@RequestMapping("/product/")
public class ProductController {

    @Autowired
    private IProductService iProductService;
    
    @PostMapping("detail")
    public ServerResponse<ProductDetailVO> detail(Integer productId){
        return iProductService.getProductDetail(productId);
    }

    @PostMapping("list")
    public ServerResponse<PageInfo> list(@RequestParam(value = "keyword",required = false) String keyword,
                                         @RequestParam(value = "categoryId",required = false) Integer categoryId,
                                         @RequestParam(value = "pageNum",defaultValue = "1") int pageNum,
                                         @RequestParam(value = "pageSize",defaultValue = "10") int pageSize,
                                         @RequestParam(value = "orderBy",defaultValue = "") String orderBy){
        return iProductService.getProductByKeywordCategory(keyword,categoryId,pageNum,pageSize,orderBy);
    }





}
