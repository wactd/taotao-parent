package com.taotao.service;

import com.taotao.rest.pojo.CatResult;

/**
 * Created by tiger on 17-4-24.
 */
public interface ItemCatService {

    /**
     * 获取商品分类列表
     * @return
     */
    CatResult getItemCatList();

}
