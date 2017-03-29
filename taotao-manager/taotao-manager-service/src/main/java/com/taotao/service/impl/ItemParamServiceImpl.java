package com.taotao.service.impl;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.mapper.TbItemParamMapper;
import com.taotao.pojo.TbItemParam;
import com.taotao.pojo.TbItemParamExample;
import com.taotao.service.ItemParamService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

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
        List<TbItemParam> itemParams = tbItemParamMapper.selectByExample(example);
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
}
