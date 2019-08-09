package com.cskaoyan.service.department;

import com.cskaoyan.bean.department.Department;

import java.util.List;

public interface DepartmentService {
    List<Department> getDepartmentList();

    int insertDepartment(Department department);

    Department queryDepartmentById(Department department);

    int deleteBatch(String[] ids);

    int updateAll(Department department);

    int updateNote(Department department);

    List<Department> searchDepartmentById(String condition);

    List<Department> searchDepartmentByName(String departmentName);
}
