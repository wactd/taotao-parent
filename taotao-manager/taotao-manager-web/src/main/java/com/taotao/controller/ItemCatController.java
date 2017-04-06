package com.taotao.controller;

import com.taotao.common.pojo.EuTreeNode;
import com.taotao.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 商品分类管理
 * Created by dongly on 17-3-15.
 */

@Controller
public class ItemCatController {

    @Autowired
    private ItemCatService itemCatService;

    @RequestMapping(value = "/item/cat/list")
    @ResponseBody
    public List<EuTreeNode> selectItemCat(@RequestParam(value = "id", required = false, defaultValue = "0") Long id) {

        List<EuTreeNode> treeNodes = itemCatService.selectCatList(id);

        return treeNodes;
    }

}