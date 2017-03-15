package com.taotao.common.pojo;

/**
 * EasyUI树形控件节点
 * Created by dongly on 17-3-15.
 */
public class EuTreeNode {

    private Long id;
    private String state;
    private String text;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
