package com.taotao.mapper;

import com.alibaba.druid.filter.AutoLoad;
import com.taotao.pojo.TbUser;
import com.taotao.pojo.TbUserExample;
import com.taotao.spring.SpringJunitTest;
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
    private TbUserMapper tbUserMapper;

    @Test
    public void selectByExampleTest() {
        TbUserExample example = new TbUserExample();
        List<TbUser> users = tbUserMapper.selectByExample(example);
        users.forEach(System.out::println);
    }

}
