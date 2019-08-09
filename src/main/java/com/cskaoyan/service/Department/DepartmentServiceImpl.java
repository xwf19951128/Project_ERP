package com.cskaoyan.service.Department;

import com.cskaoyan.bean.department.Department;
import com.cskaoyan.bean.department.DepartmentPage;
import com.cskaoyan.mapper.department.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    DepartmentMapper departmentMapper;



    @Override
    public List<Department> getDepartmentList() {
        return departmentMapper.getDepartmentList();
    }

    @Override
    public int insertDepartment(Department department) {
        return departmentMapper.insertDepartment(department);
    }

    @Override
    public Department queryDepartmentById(Department department) {
        return departmentMapper.queryDepartmentById(department.getDepartmentId());
    }

    @Override
    public int deleteBatch(String[] ids) {
        return departmentMapper.deleteBatch(ids);
    }
}
