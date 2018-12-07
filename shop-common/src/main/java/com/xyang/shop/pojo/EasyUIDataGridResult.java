package com.xyang.shop.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2018/12/3 0003.
 */
public class EasyUIDataGridResult implements Serializable{

    private Long total;

    private List rows;

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List getRows() {
        return rows;
    }

    public void setRows(List rows) {
        this.rows = rows;
    }
}
