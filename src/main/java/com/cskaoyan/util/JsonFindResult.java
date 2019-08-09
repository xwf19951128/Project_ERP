package com.cskaoyan.util;

import java.util.List;

/**
 * @Author: XiaoLei
 * @Date Created in 23:08 2019/8/8
 * 封装查询的信息
 */
public class JsonFindResult<T> {
    private int total;

    private List<T> rows;

    @Override
    public String toString() {
        return "JsonFindResult{" +
                "total=" + total +
                ", rows=" + rows +
                '}';
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
