package com.taotao.service.impl;

import com.alibaba.fastjson.JSON;
import com.taotao.rest.pojo.CatResult;
import com.taotao.service.ItemCatService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by tiger on 17-4-24.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class ItemCatServiceImplTest {

    @Autowired
    private ItemCatService itemCatService;

    @Test
    public void getItemCatList() throws Exception {
        CatResult itemCatList = itemCatService.getItemCatList();
        System.out.println(JSON.toJSONString(itemCatList));
    }

}