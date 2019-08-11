package com.cskaoyan.controller.department;

import com.cskaoyan.bean.department.Department;
import com.cskaoyan.bean.department.DepartmentPage;

import com.cskaoyan.service.department.DepartmentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
        sysPermissionList.add("department:add");
        sysPermissionList.add("department:edit");
        sysPermissionList.add("department:delete");
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

    /*修改判断*/
    @RequestMapping("edit_judge")
    @ResponseBody
    public Map<String, String> editJudge() {
        return new HashMap<>();
    }

    /*跳转修改页面*/
    @RequestMapping("edit")
    public String edit() {
        return "/WEB-INF/jsp/department_edit.jsp";
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

    /*提交修改所有信息*/
    @RequestMapping("update_all")
    @ResponseBody
    public Map<String, Object> updateAll(Department department) {
        Map<String, Object> data = new HashMap<>();
        int i = departmentService.updateAll(department);
        if (i > 0) {
            data.put("status",200);
            data.put("msg","OK");
            data.put("data",null);
        } else {
            data.put("meg","服务器开小差了，请稍后再试");
        }
        return data;
    }

    @RequestMapping("update_note")
    @ResponseBody
    public Map<String, Object> updateNote(Department department) {
        Map<String,Object> data = new HashMap<>();
        int i = departmentService.updateNote(department);
        if (i > 0) {
            data.put("status",200);
            data.put("msg","OK");
            data.put("data",null);
        } else {
            data.put("meg","服务器开小差了，请稍后再试");
        }
        return data;
    }

    /*id的模糊查询*/
    @RequestMapping("search_department_by_departmentId")
    @ResponseBody
    public DepartmentPage searchDepartmentById(int searchValue,int rows, int page) {
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder condition = stringBuilder.append("%").append(searchValue).append("%");  // 拼接查詢條件
        PageHelper.startPage(page,rows);
        List<Department> list = departmentService.searchDepartmentById(condition.toString());
        PageInfo<Department> pageInfo = new PageInfo<>(list);
        long total = pageInfo.getTotal();
        DepartmentPage departmentPage = new DepartmentPage();
        departmentPage.setRows(list);
        departmentPage.setTotal(((int) total));
        return departmentPage;
    }

    /*部门名称的模糊查询*/
    @RequestMapping("search_department_by_departmentName")
    @ResponseBody
    public DepartmentPage searchDepartmentByDepartmentName(String searchValue, int page, int rows) {
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder condition = stringBuilder.append("%").append(searchValue).append("%");  // 拼接查詢條件
        PageHelper.startPage(page,rows);
        List<Department> list = departmentService.searchDepartmentByName(condition.toString());
        PageInfo<Department> pageInfo = new PageInfo<>(list);
        long total = pageInfo.getTotal();
        DepartmentPage departmentPage = new DepartmentPage();
        departmentPage.setRows(list);
        departmentPage.setTotal(((int) total));
        return departmentPage;
    }
}
