package com.cskaoyan.bean.employee;



import java.util.List;

public class EmployeePage {

    private List<Employee> rows;


    private int total;

    public List<Employee> getRows() {
        return rows;
    }

    public void setRows(List<Employee> rows) {
        this.rows = rows;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }


}
