package com.mooc.happymall.service;


import com.mooc.happymall.common.ServerResponse;
import com.mooc.happymall.pojo.Category;

import java.util.List;

/**
 * Created by qm
 */
public interface ICategoryService {
    ServerResponse addCategory(String categoryName, Integer parentId);
    ServerResponse updateCategoryName(Integer categoryId, String categoryName);
    ServerResponse<List<Category>> getChildrenParallelCategory(Integer categoryId);
    ServerResponse<List<Integer>> selectCategoryAndChildrenById(Integer categoryId);

}
