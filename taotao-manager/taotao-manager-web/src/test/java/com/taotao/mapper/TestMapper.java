package com.taotao.mapper;

import com.alibaba.druid.filter.AutoLoad;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;

/**
 * Created by dongly on 17-3-10.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class TestMapper {

    @Autowired
    private DataSource dataSource;

    @Test
    public void test() {
        System.out.println(dataSource);
    }
}
