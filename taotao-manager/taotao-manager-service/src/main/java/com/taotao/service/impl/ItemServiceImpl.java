package com.taotao.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.common.pojo.EUDataGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemExample;
import com.taotao.service.ItemService;
import com.taotao.utils.IDUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.Date;
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

    @Override
    public TaotaoResult addItem(TbItem tbItem) {
        // item不全
        // 生成商品ID
        long itemId = IDUtils.genItemId();
        tbItem.setId(itemId);
        // 商品的状态
        tbItem.setStatus(Byte.parseByte("1"));
        tbItem.setCreated(new Date());
        tbItem.setUpdated(new Date());
        // 插入到数据库
        tbItemMapper.insert(tbItem);
        return TaotaoResult.ok();
    }

}
