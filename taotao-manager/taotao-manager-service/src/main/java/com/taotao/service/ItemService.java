package com.taotao.service;

import com.taotao.common.pojo.EUDataGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbItem;

/**
 * Created by dongly on 17-3-14.
 */
public interface ItemService {

    /**
     * 根据商品Id查询商品
     * @param itemId
     * @return
     */
    TbItem  selectItemById(Long itemId);

    /**
     * 分页查询商品列表
     * @param page
     * @param rows
     * @return
     */
    EUDataGridResult<TbItem> selectItems(Integer page, Integer rows);

    /**
     * 添加上爬
     * @param tbItem
     * @return
     */
    TaotaoResult addItem(TbItem tbItem);
}
