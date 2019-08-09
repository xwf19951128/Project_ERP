package com.cskaoyan.service.qualifyMonitor;

import com.cskaoyan.bean.qualifyMonitor.Employee;

import java.util.List;

public interface EmployeeService {
    // 查询所有员工
    List<Employee> queryEmployee();
}
