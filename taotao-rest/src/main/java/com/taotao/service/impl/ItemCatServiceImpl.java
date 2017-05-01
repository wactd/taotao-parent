package com.taotao.service.impl;

import com.taotao.mapper.TbItemCatMapper;
import com.taotao.pojo.TbItemCat;
import com.taotao.pojo.TbItemCatExample;
import com.taotao.rest.pojo.CatNode;
import com.taotao.rest.pojo.CatResult;
import com.taotao.service.ItemCatService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by tiger on 17-4-24.
 */

@Service
public class ItemCatServiceImpl implements ItemCatService {

    @Resource
    private TbItemCatMapper itemCatMapper;

    @Override
    public CatResult getItemCatList() {
        TbItemCatExample example = new TbItemCatExample();
        TbItemCatExample.Criteria criteria = example.createCriteria();
        criteria.andStatusEqualTo(1);
        List<TbItemCat> itemCats = itemCatMapper.selectByExample(example);
        List<?> list = getCatListByParentId(0L, itemCats);
        CatResult result = new CatResult();
        result.setData(list);
        return result;
    }

    private List<?> getCatListByParentId(Long parentId, List<TbItemCat> itemCats) {

        List<TbItemCat> tbItemCats = itemCats.stream().filter(tbItemCat ->
                                     tbItemCat.getParentId().equals(parentId)).collect(Collectors.toList());

        List resultList = new ArrayList<>();
        tbItemCats.forEach(itemCat -> {
            if (itemCat.getIsParent()) {
                CatNode node = new CatNode();
                if (0 == parentId) {
                    node.setName("<a href='/products/"+ itemCat.getId() +".html'>"+ itemCat.getName() +"</a>");
                } else {
                    node.setName(itemCat.getName());
                }
                node.setUrl("/products/"+ itemCat.getId() +".html");
                node.setItem(getCatListByParentId(itemCat.getId(), itemCats));
                resultList.add(node);
            } else {
                resultList.add("/products/"+itemCat.getId()+".html|" + itemCat.getName());
            }
        });

        return resultList;
    }
}
