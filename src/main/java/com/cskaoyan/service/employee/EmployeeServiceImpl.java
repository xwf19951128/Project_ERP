package com.cskaoyan.service.employee;

import com.cskaoyan.bean.employee.Employee;
import com.cskaoyan.mapper.employee.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;

    @Override
    public List<Employee> getEmployeeList() {
        return employeeMapper.getEmployeeList();
    }

    @Override
    public Employee queryEmployeeById(Employee employee) {
        return employeeMapper.queryEmployeeById(employee.getEmpId());
    }

    @Override
    public int insertEmployee(Employee employee) {
        return employeeMapper.insertEmployee(employee);
    }

    @Override
    public int deleteBatch(String[] ids) {
        return employeeMapper.deleteBatch(ids);
    }

    @Override
    public int updateAll(Employee employee) {
        return employeeMapper.updateAll(employee);
    }

    @Override
    public List<Employee> searchEmployeeById(String term) {
        return employeeMapper.searchEmployeeById(term);
    }

    @Override
    public List<Employee> searchEmployeeByEmpName(String term) {
        return employeeMapper.searchEmployeeByEmpName(term);
    }

    @Override
    public List<Employee> searchEmployeeByDepartmentName(String term) {
        return employeeMapper.searchEmployeeByDepartmentName(term);
    }
}
