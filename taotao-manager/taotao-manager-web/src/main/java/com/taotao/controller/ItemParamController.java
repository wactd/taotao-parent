package com.taotao.controller;

import com.taotao.common.pojo.EUDataGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbItemParam;
import com.taotao.pojo.TbItemParamExt;
import com.taotao.service.ItemParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by dongly on 17-3-29.
 * 商品规格参数模板
 */

@Controller
@RequestMapping(value = "/item/param")
public class ItemParamController {

    @Autowired
    private ItemParamService itemParamByCidService;

    @RequestMapping(value = "/query/itemcatid/{itemCatId}")
    @ResponseBody
    public TaotaoResult selectItemParamByCid(@PathVariable Long itemCatId) {

        TaotaoResult result = itemParamByCidService.selectItemParamByCid(itemCatId);

        return result;
    }

    @RequestMapping(value = "/save/{cid}")
    @ResponseBody
    public TaotaoResult addItemParam(@PathVariable Long cid, String paramData) {
        TbItemParam itemParam = new TbItemParam();
        itemParam.setItemCatId(cid);
        itemParam.setParamData(paramData);
        TaotaoResult result = itemParamByCidService.addItemParam(itemParam);
        return result;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public EUDataGridResult<TbItemParamExt> selectItemList(@RequestParam(required = false, defaultValue = "1") Integer page,
                                                           @RequestParam(required = false, defaultValue = "5") Integer rows) {
        EUDataGridResult<TbItemParamExt> dataGridResult = itemParamByCidService.selectItemList(page, rows);
        return dataGridResult;
    }


    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public TaotaoResult deleteItemParam(@RequestParam List<Long> ids) {

        return itemParamByCidService.deleteItemParam(ids);
    }
}
