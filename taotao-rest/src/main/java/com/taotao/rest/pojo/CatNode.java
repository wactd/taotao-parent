package com.taotao.rest.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import sun.java2d.pipe.ValidatePipe;

import java.util.List;

/**
 * Created by tiger on 17-4-24.
 */
public class CatNode {

    @JSONField(name = "n")
    private String name;

    @JSONField(name = "u")
    private String url;

    @JSONField(name = "i")
    private List<?> item;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<?> getItem() {
        return item;
    }

    public void setItem(List<?> item) {
        this.item = item;
    }
}
