package com.cskaoyan.service.Department;

import com.cskaoyan.bean.department.Department;
import com.cskaoyan.bean.department.DepartmentPage;

import java.util.List;

public interface DepartmentService {
    List<Department> getDepartmentList();

    int insertDepartment(Department department);

    Department queryDepartmentById(Department department);

    int deleteBatch(String[] ids);
}
