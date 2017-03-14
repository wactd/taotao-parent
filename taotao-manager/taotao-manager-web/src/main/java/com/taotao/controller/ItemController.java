package com.taotao.controller;

import com.taotao.common.pojo.EUDataGridResult;
import com.taotao.pojo.TbItem;
import com.taotao.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 商品管理Controlller
 * Created by dongly on 17-3-14.
 */

@Controller
public class ItemController {

    @Autowired
    private ItemService itemService;

    @RequestMapping(value = "/item/{itemId}")
    @ResponseBody
    public TbItem selectTbItemById(@PathVariable(value = "itemId") Long itemId) {
        return itemService.selectItemById(itemId);
    }

    @RequestMapping(value = "/item/list")
    @ResponseBody
    public EUDataGridResult<TbItem> selectItems(@RequestParam(required = false, defaultValue = "1") Integer page,
                                                @RequestParam(required = false, defaultValue = "5") Integer rows) {
        EUDataGridResult<TbItem> result = itemService.selectItems(page, rows);
        return result;
    }

}
