package com.taotao.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.common.pojo.EUDataGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.mapper.TbItemParamMapper;
import com.taotao.pojo.*;
import com.taotao.service.ItemParamService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.SystemPropertyUtils;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by dongly on 17-3-29.
 * 规格参数模板
 */

@Service
public class ItemParamServiceImpl implements ItemParamService {

    @Resource
    private TbItemParamMapper tbItemParamMapper;

    @Override
    public TaotaoResult selectItemParamByCid(Long cid) {
        TbItemParamExample example = new TbItemParamExample();
        TbItemParamExample.Criteria criteria = example.createCriteria();
        criteria.andItemCatIdEqualTo(cid);
        List<TbItemParam> itemParams = tbItemParamMapper.selectByExampleWithBLOBs(example);
        if (!CollectionUtils.isEmpty(itemParams)) {
            return TaotaoResult.ok(itemParams.get(0));
        }
        return TaotaoResult.ok();
    }

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public TaotaoResult addItemParam(TbItemParam itemParam) {

        itemParam.setCreated(new Date());
        itemParam.setUpdated(new Date());

        tbItemParamMapper.insertSelective(itemParam);

        return TaotaoResult.ok();
    }

    @Override
    public EUDataGridResult<TbItemParamExt> selectItemList(Integer page, Integer rows) {
        Page page1 = PageHelper.startPage(page, rows);
        List<TbItemParamExt> extList = tbItemParamMapper.selectTbItemParamList(null);

        PageInfo<TbItemParamExt> pageInfo = new PageInfo<>(extList);

        EUDataGridResult<TbItemParamExt> result = new EUDataGridResult<>();
        result.setTotal(pageInfo.getTotal());
        result.setRows(extList);
        return result;
    }

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public TaotaoResult deleteItemParam(List<Long> ids) {
        TbItemParamExample example = new TbItemParamExample();
        TbItemParamExample.Criteria criteria = example.createCriteria();
        criteria.andIdIn(ids);
        int i = tbItemParamMapper.deleteByExample(example);
        return TaotaoResult.ok();
    }
}
