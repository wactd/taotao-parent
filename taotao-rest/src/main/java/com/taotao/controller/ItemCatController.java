package com.taotao.controller;

import com.alibaba.fastjson.JSONPObject;
import com.taotao.rest.pojo.CatResult;
import com.taotao.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by tiger on 17-5-2.
 * 商品分类列表
 */

@Controller
public class ItemCatController {

    @Autowired
    private ItemCatService itemCatService;

    @RequestMapping(value = "/itemcat/list")
    @ResponseBody
    public Object getItemCatList(String callback) {
        CatResult catList = itemCatService.getItemCatList();

        JSONPObject object = new JSONPObject(callback);
        object.addParameter(catList);
        return object;
    }


}
