package com.cskaoyan.mapper.qualifyMonitor;

import com.cskaoyan.bean.qualifyMonitor.Employee;

import java.util.List;

public interface EmployeeMapper {
    // 查询所有员工
    List<Employee> queryEmployee();
}
