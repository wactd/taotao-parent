package com.taotao.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.taotao.mapper.TbItemParamItemMapper;
import com.taotao.pojo.TbItemParamItem;
import com.taotao.pojo.TbItemParamItemExample;
import com.taotao.service.ItemParamItemService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Created by dongly on 17-4-6.
 */

@Service
public class ItemParamItemServiceImpl implements ItemParamItemService {

    @Resource
    private TbItemParamItemMapper tbItemParamItemMapper;


    @Override
    public String selectItemParamItemByItemId(Long itemId) {

        TbItemParamItemExample example = new TbItemParamItemExample();
        TbItemParamItemExample.Criteria criteria = example.createCriteria();
        criteria.andItemIdEqualTo(itemId);

        List<TbItemParamItem> paramItems = tbItemParamItemMapper.selectByExampleWithBLOBs(example);

        if (CollectionUtils.isEmpty(paramItems)) {
            return "";
        }

        String paramData = paramItems.get(0).getParamData();

        // List<Map> maps = JSON.parseArray(paramData, Map.class);
        List<Map<String, Object>> maps = JSON.parseObject(paramData,
                new TypeReference<List<Map<String, Object>>>() {});

        StringBuffer sb = new StringBuffer();
        sb.append("<table cellpadding=\"0\" cellspacing=\"1\" width=\"100%\" border=\"1\" class=\"Ptable\">\n");
        sb.append("    <tbody>\n");
        for (Map<String, Object> m1 : maps) {
            sb.append("        <tr>\n");
            sb.append("            <th class=\"tdTitle\" colspan=\"2\">" + m1.get("group") + "</th>\n");
            sb.append("        </tr>\n");
            // List<Map> list2 = (List<Map>) m1.get("params");
            List<Map<String, Object>> list2 = JSON.parseObject(m1.get("params").toString(),
                    new TypeReference<List<Map<String, Object>>>() {
                    });
            for (Map<String, Object> m2 : list2) {
                sb.append("        <tr>\n");
                sb.append("            <td class=\"tdTitle\">" + m2.get("k") + "</td>\n");
                sb.append("            <td>" + m2.get("v") + "</td>\n");
                sb.append("        </tr>\n");
            }
        }
        sb.append("    </tbody>\n");
        sb.append("</table>");
        return sb.toString();
    }

}
