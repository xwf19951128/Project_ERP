package com.cskaoyan.mapper.employee;

import com.cskaoyan.bean.employee.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmployeeMapper {
    List<Employee> getEmployeeList();

    Employee queryEmployeeById(String empId);

    int insertEmployee(Employee employee);

    int deleteBatch(@Param("ids") String[] ids);

    int updateAll(Employee employee);

    List<Employee> searchEmployeeByEmpName(String term);

    List<Employee> searchEmployeeById(String term);

    List<Employee> searchEmployeeByDepartmentName(String term);
}
