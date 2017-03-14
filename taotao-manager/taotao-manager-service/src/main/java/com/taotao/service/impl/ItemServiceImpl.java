package com.taotao.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.common.pojo.EUDataGridResult;
import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemExample;
import com.taotao.service.ItemService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * 商品表service
 * Created by dongly on 17-3-14.
 */

@Service
public class ItemServiceImpl implements ItemService {

    @Resource
    private TbItemMapper tbItemMapper;

    @Override
    public TbItem selectItemById(Long itemId) {

        TbItemExample example = new TbItemExample();
        TbItemExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(itemId);
        List<TbItem> items = tbItemMapper.selectByExample(example);
        if (!CollectionUtils.isEmpty(items)) {
            return items.get(0);
        }
        return null;
    }

    @Override
    public EUDataGridResult<TbItem> selectItems(Integer page, Integer rows) {
        TbItemExample example = new TbItemExample();

        PageHelper.startPage(page, rows);
        List<TbItem> items = tbItemMapper.selectByExample(example);

        PageInfo<TbItem> pageInfo = new PageInfo<>(items);

        EUDataGridResult<TbItem> result = new EUDataGridResult<>();
        result.setTotal(pageInfo.getTotal());
        result.setRows(items);
        return result;
    }

}
