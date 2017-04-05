package com.taotao.controller;

import com.taotao.service.ItemParamItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by dongly on 17-4-6.
 */

@Controller
public class ItemParamItemController {

    @Autowired
    private ItemParamItemService itemParamItemService;


    // @RequestMapping(value = "/showItemValue/${itemId}")
    @RequestMapping(value = "/query/showItemValue/{itemId}")
    public String showItemParam(@PathVariable Long itemId, Model model) {
        String s = itemParamItemService.selectItemParamItemByItemId(itemId);
        model.addAttribute("itemParam", s);
        return "item";
    }

}
