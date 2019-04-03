package com.mooc.happymall.service;

import com.mooc.happymall.common.ServerResponse;
import com.mooc.happymall.vo.CartVO;

/**
 * Created by qm
 */
public interface ICartService {
    ServerResponse<CartVO> add(Integer userId, Integer productId, Integer count);
    ServerResponse<CartVO> update(Integer userId, Integer productId, Integer count);
    ServerResponse<CartVO> deleteProduct(Integer userId, String productIds);

    ServerResponse<CartVO> list (Integer userId);
    ServerResponse<CartVO> selectOrUnSelect (Integer userId, Integer productId, Integer checked);
    ServerResponse<Integer> getCartProductCount(Integer userId);
}
