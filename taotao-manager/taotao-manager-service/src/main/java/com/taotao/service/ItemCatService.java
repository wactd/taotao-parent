package com.taotao.service;

import com.taotao.common.pojo.EuTreeNode;

import java.util.List;

/**
 * Created by dongly on 17-3-15.
 */
public interface ItemCatService {

    /**
     * 根据父节点查询子分类
     * @param parentId
     * @return
     */
    List<EuTreeNode> selectCatList(Long parentId);

}
