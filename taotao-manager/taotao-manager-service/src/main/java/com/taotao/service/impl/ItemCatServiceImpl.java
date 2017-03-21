package com.taotao.service.impl;

import com.taotao.common.pojo.EuTreeNode;
import com.taotao.mapper.TbItemCatMapper;
import com.taotao.pojo.TbItemCat;
import com.taotao.pojo.TbItemCatExample;
import com.taotao.service.ItemCatService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dongly on 17-3-15.
 */

@Service
public class ItemCatServiceImpl implements ItemCatService {

    @Resource
    private TbItemCatMapper tbItemCatMapper;

    @Override
    public List<EuTreeNode> selectCatList(Long parentId) {

        TbItemCatExample example = new TbItemCatExample();
        TbItemCatExample.Criteria criteria = example.createCriteria();
        criteria.andParentIdEqualTo(parentId);

        List<TbItemCat> itemCats = tbItemCatMapper.selectByExample(example);

        List<EuTreeNode> treeNodes = new ArrayList<>();
        itemCats.forEach((tbItemCat -> {
            EuTreeNode treeNode = new EuTreeNode();
            treeNode.setId(tbItemCat.getId());
            treeNode.setState(tbItemCat.getIsParent() ? "closed" : "open");
            treeNode.setText(tbItemCat.getName());
            treeNodes.add(treeNode);
        }));

        return treeNodes;
    }
}
