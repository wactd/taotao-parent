package com.taotao.common.pojo;

import java.util.List;

/**
 * Created by dongly on 17-3-14.
 */

public class EUDataGridResult<T> {

    private Long total;
    private List<T> rows;

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
