package com.cskaoyan.mapper.department;

import com.cskaoyan.bean.department.Department;
import com.cskaoyan.bean.department.DepartmentPage;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface DepartmentMapper {
    List<Department> getDepartmentList();

    int insertDepartment(Department department);

    Department queryDepartmentById(String departmentId);

    int deleteBatch(@Param("ids") String[] ids);
}
