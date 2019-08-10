package com.cskaoyan.service.employee;

import com.cskaoyan.bean.employee.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getEmployeeList();

    Employee queryEmployeeById(Employee employee);

    int insertEmployee(Employee employee);

    int deleteBatch(String[] ids);

    int updateAll(Employee employee);


    List<Employee> searchEmployeeById(String term);

    List<Employee> searchEmployeeByEmpName(String term);

    List<Employee> searchEmployeeByDepartmentName(String term);
}
