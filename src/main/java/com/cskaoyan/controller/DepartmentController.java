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
import java.util.List;

@Controller
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;


    @RequestMapping("department/find")
    public String find(HttpServletRequest request) {
        List<String> sysPermissionList = new ArrayList<>();
        sysPermissionList.add("Department:add");
        sysPermissionList.add("Department:edit");
        sysPermissionList.add("Department:delete");
        request.getSession().setAttribute("sysPermissionList",sysPermissionList);
        return "/WEB-INF/jsp/department_list.jsp";
    }

    @RequestMapping("department/list")
    @ResponseBody
    public List<Department> getDepartmentList(int page, int rows) {
        List<Department> departmentList = departmentService.getDepartmentList();
        System.out.println(departmentList);
        return departmentList;
    }

}
