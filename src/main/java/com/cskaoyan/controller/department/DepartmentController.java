package com.cskaoyan.controller;

import com.cskaoyan.bean.Department;
import com.cskaoyan.service.DepartmentService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("department/")
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;


    @RequestMapping("find")
    public String find(HttpServletRequest request) {
        List<String> sysPermissionList = new ArrayList<>();
        sysPermissionList.add("Department:add");
        sysPermissionList.add("Department:edit");
        sysPermissionList.add("Department:delete");
        request.getSession().setAttribute("sysPermissionList",sysPermissionList);
        return "/WEB-INF/jsp/department_list.jsp";
    }

    @RequestMapping("list")
    @ResponseBody
    public List<Department> getDepartmentList(int page, int rows) {
        List<Department> departmentList = departmentService.getDepartmentList();
        System.out.println(departmentList);
        return departmentList;
    }

    @RequestMapping("add")
    @ResponseBody
    public String add() {
        return "/WEB-INF/jsp/department_add.jsp";
    }



    @RequestMapping("insert")
    @ResponseBody
    public Map<String, Object> insertDepartment(Department department) {
        Map<String, Object> data = new HashMap<>();
        int i = departmentService.insertDepartment(department);
        if (i > 0) {
            data.put("status",200);
        } else if (i == 0) {
            data.put("status",500);
            data.put("msg","部门已存在");
        }
        return data;
    }
}
