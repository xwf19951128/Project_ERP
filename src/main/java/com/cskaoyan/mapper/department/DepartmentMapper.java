package com.cskaoyan.mapper.department;

import com.cskaoyan.bean.department.Department;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface DepartmentMapper {
    List<Department> getDepartmentList();

    int insertDepartment(Department department);

    Department queryDepartmentById(String departmentId);

    int deleteBatch(@Param("ids") String[] ids);

    int updateAll(Department department);

    int updateNote(Department department);

    List<Department> searchDepartmentById(String id);

    List<Department> searchDepartmentByName(String departmentName);
}
