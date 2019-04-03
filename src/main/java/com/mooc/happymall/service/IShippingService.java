package com.mooc.happymall.service;

import com.github.pagehelper.PageInfo;
import com.mooc.happymall.common.ServerResponse;
import com.mooc.happymall.pojo.Shipping;

/**
 * Created by qm
 */
public interface IShippingService {

    ServerResponse add(Integer userId, Shipping shipping);
    ServerResponse<String> delete(Integer userId, Integer shippingId);
    ServerResponse update(Integer userId, Shipping shipping);
    ServerResponse<Shipping> select(Integer userId, Integer shippingId);
    ServerResponse<PageInfo> list(Integer userId, int pageNum, int pageSize);

}
