package com.cskaoyan.bean.department;

import java.util.List;

public class DepartmentPage {

    private List<Department> rows;

    private int total;

    public List<Department> getRows() {
        return rows;
    }

    public void setRows(List<Department> rows) {
        this.rows = rows;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
