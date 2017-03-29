package com.taotao.service;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbItemParam;

/**
 * Created by dongly on 17-3-29.
 */
public interface ItemParamService {

    TaotaoResult selectItemParamByCid(Long cid);

    TaotaoResult addItemParam(TbItemParam itemParam);
}
