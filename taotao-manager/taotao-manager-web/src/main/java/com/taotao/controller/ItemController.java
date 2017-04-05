package com.taotao.controller;

import com.taotao.common.pojo.EUDataGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbItem;
import com.taotao.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

/**
 * 商品管理Controlller
 * Created by dongly on 17-3-14.
 */

@Controller
public class ItemController {

    @Autowired
    private ItemService itemService;


    @ResponseBody
    @RequestMapping(value = "/item/save", method = RequestMethod.POST)
    public TaotaoResult addItem(TbItem tbItem, String desc, String itemParams) {
        TaotaoResult result = itemService.addItem(tbItem, desc, itemParams);
        return result;
    }


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
