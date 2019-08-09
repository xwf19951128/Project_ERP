package com.cskaoyan.service.qualifyMonitor;

import com.cskaoyan.bean.qualifyMonitor.Employee;
import com.cskaoyan.mapper.qualifyMonitor.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;

    @Override
    public List<Employee> queryEmployee() {
        return employeeMapper.queryEmployee();
    }
}
