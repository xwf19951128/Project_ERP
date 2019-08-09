package com.cskaoyan.controller.department;

import com.cskaoyan.bean.department.Department;
import com.cskaoyan.bean.department.DepartmentPage;
import com.cskaoyan.bean.login.SysUser;
import com.cskaoyan.service.Department.DepartmentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("department/")
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;


    /*首次点击标签*/
    @RequestMapping("find")
    public String find(HttpServletRequest request) {
        List<String> sysPermissionList = new ArrayList<>();
        sysPermissionList.add("Department:add");
        sysPermissionList.add("Department:edit");
        sysPermissionList.add("Department:delete");
        request.getSession().setAttribute("sysPermissionList",sysPermissionList);
        return "/WEB-INF/jsp/department_list.jsp";
    }

    /*查询*/
    @RequestMapping("list")
    @ResponseBody
    public DepartmentPage getDepartmentList(int page, int rows) {
        DepartmentPage departmentPage = new DepartmentPage();
        PageHelper.startPage(page,rows);
        List<Department> departmentList = departmentService.getDepartmentList();
        PageInfo<Department> pageInfo = new PageInfo<>(departmentList);
        long total = pageInfo.getTotal();
        departmentPage.setRows(departmentList);
        departmentPage.setTotal((int) total);
//        System.out.println(departmentList);
        return departmentPage;
    }

    /*增加判断*/
    @RequestMapping("add_judge")
    @ResponseBody
    public Map<String,String> addJudge() {
        Map<String,String> data = new HashMap<>();
        return data;
    }

    @RequestMapping("add")
    public String add() {
        return "/WEB-INF/jsp/department_add.jsp";
    }

    /*删除判断*/
    @RequestMapping("delete_judge")
    @ResponseBody
    public Map<String, String> deleteJudge() {
        Map<String,String> data = new HashMap<>();
        return data;
    }


    /*新增*/
    @RequestMapping("insert")
    @ResponseBody
    public Map<String, Object> insertDepartment(Department department) {
        Map<String, Object> data = new HashMap<>();
        Department isExist = departmentService.queryDepartmentById(department);
        if (isExist == null) {
            int i = departmentService.insertDepartment(department);
            if (i > 0) {
                data.put("status", 200);
                data.put("msg", "OK");
            }
        } else {
            data.put("msg","该部门编号已经存在，请更换部门编号！");
        }
        return data;
    }

  /*删除*/
    @RequestMapping("delete_batch")
    @ResponseBody
    public Map<String,Object> deleteBatch(String[] ids) {
        Map<String, Object> data = new HashMap<>();
        int i = departmentService.deleteBatch(ids);
        if (i > 0) {
            data.put(("msg"),"OK");
            data.put("status",200);
            data.put("data",null);
        } else {
            data.put("msg","删除失败");
        }
        return data;
    }
}
