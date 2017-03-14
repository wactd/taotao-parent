package com.taotao.mapper;

import com.alibaba.druid.filter.AutoLoad;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemExample;
import com.taotao.pojo.TbUser;
import com.taotao.pojo.TbUserExample;
import com.taotao.spring.SpringJunitTest;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.List;

/**
 * Created by dongly on 17-3-10.
 */
public class TestMapper extends SpringJunitTest{

    @Resource
    private TbItemMapper tbItemMapper;

    @Test
    public void selectByExampleTest() {

        TbItemExample example = new TbItemExample();


        Page<TbItem> page = PageHelper.startPage(1, 1);

        List<TbItem> tbItems =tbItemMapper.selectByExample(example);

        List<TbItem> result = page.getResult();
        System.out.println(JSONObject.toJSONString(page));

        Assert.assertEquals(tbItems.size(), result.size());
    }

}
