package com.taotao.service;

import com.taotao.common.pojo.EUDataGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbItemParam;
import com.taotao.pojo.TbItemParamExt;

import java.util.List;

/**
 * Created by dongly on 17-3-29.
 */
public interface ItemParamService {

    TaotaoResult selectItemParamByCid(Long cid);

    TaotaoResult addItemParam(TbItemParam itemParam);

    EUDataGridResult<TbItemParamExt> selectItemList(Integer page, Integer rows);

    TaotaoResult deleteItemParam(List<Long> ids);
}
