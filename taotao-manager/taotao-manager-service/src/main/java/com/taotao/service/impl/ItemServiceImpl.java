package com.taotao.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.common.pojo.EUDataGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.mapper.TbItemDescMapper;
import com.taotao.mapper.TbItemMapper;
import com.taotao.mapper.TbItemParamItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemDesc;
import com.taotao.pojo.TbItemExample;
import com.taotao.pojo.TbItemParamItem;
import com.taotao.service.ItemService;
import com.taotao.utils.IDUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 商品表service
 * Created by dongly on 17-3-14.
 */

@Service
public class ItemServiceImpl implements ItemService {

    @Resource
    private TbItemMapper tbItemMapper;

    @Resource
    private TbItemDescMapper tbItemDescMapper;

    @Resource
    private TbItemParamItemMapper tbItemParamItemMapper;

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
        example.setOrderByClause("created desc");
        PageHelper.startPage(page, rows);
        List<TbItem> items = tbItemMapper.selectByExample(example);

        PageInfo<TbItem> pageInfo = new PageInfo<>(items);

        EUDataGridResult<TbItem> result = new EUDataGridResult<>();
        result.setTotal(pageInfo.getTotal());
        result.setRows(items);
        return result;
    }

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public TaotaoResult addItem(TbItem tbItem, String desc, String itemParam) {
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

        // 添加商品描述信息
        addItemDesc(itemId, desc);

        // 添加规格参数
        addItemParamItem(itemId, itemParam);

        return TaotaoResult.ok();
    }

    private void addItemDesc(Long itemId, String desc) {
        TbItemDesc itemDesc = new TbItemDesc();
        itemDesc.setItemId(itemId);
        itemDesc.setItemDesc(desc);
        itemDesc.setCreated(new Date());
        itemDesc.setUpdated(new Date());
        tbItemDescMapper.insertSelective(itemDesc);
    }

    private TaotaoResult addItemParamItem(Long itemId, String itemParam) {

        TbItemParamItem paramItem = new TbItemParamItem();
        paramItem.setParamData(itemParam);
        paramItem.setItemId(itemId);
        paramItem.setCreated(new Date());
        paramItem.setUpdated(new Date());

        tbItemParamItemMapper.insertSelective(paramItem);

        return TaotaoResult.ok();
    }

}
