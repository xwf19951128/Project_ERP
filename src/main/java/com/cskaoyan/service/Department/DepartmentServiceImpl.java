package com.cskaoyan.service;

import com.cskaoyan.bean.Department;
import com.cskaoyan.mapper.DepartmentMapper;
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
}
