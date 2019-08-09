package com.cskaoyan.bean.technology;

import java.util.List;

public class QueryResult<T> {
    List<T> rows;
    int total;

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "QueryResult{" +
                "rows=" + rows +
                ", total=" + total +
                '}';
    }
}
