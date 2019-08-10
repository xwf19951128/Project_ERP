package com.cskaoyan.controller.employee;

import com.cskaoyan.bean.employee.Employee;
import com.cskaoyan.bean.employee.EmployeePage;
import com.cskaoyan.service.employee.EmployeeService;
import com.cskaoyan.util.JsonFindResult;
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
@RequestMapping("employee/")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    /*首次点击标签*/
    @RequestMapping("find")
    public String find(HttpServletRequest request) {
        List<String> sysPermissionList = new ArrayList<>();
        sysPermissionList.add("employee:add");
        sysPermissionList.add("employee:edit");
        sysPermissionList.add("employee:delete");
        request.getSession().setAttribute("sysPermissionList",sysPermissionList);
        return "/WEB-INF/jsp/employee_list.jsp";
    }


    /*查*/
    @RequestMapping("list")
    @ResponseBody
    public EmployeePage getEmployeeList(int page, int rows) {
        EmployeePage employeePage = new EmployeePage();
        PageHelper.startPage(page,rows);
        List<Employee> employeeList = employeeService.getEmployeeList();
        PageInfo<Employee> pageInfo = new PageInfo<>(employeeList);
        long total = pageInfo.getTotal();
        employeePage.setRows(employeeList);
        employeePage.setTotal((int) total);
        return employeePage;
    }

    //给其他模块提供一个获取数据的方法
    @RequestMapping("get_data")
    @ResponseBody
    public List<Employee> get_data(){
        List<Employee> employeeList = employeeService.getEmployeeList();
        return employeeList;
    }

    /*增加判断*/
    @RequestMapping("add_judge")
    @ResponseBody
    public Map<String,String> addJudge() {
        return new HashMap<>();
    }

    /*修改判断*/
    @RequestMapping("edit_judge")
    @ResponseBody
    public Map<String, Object> editJudge() {
        return new HashMap<>();
    }

    /*删除判断*/
    @RequestMapping("delete_judge")
    @ResponseBody
    public Map<String, Object> deleteJudge() {
        return new HashMap<>();
    }

    /*跳转增加窗口*/
    @RequestMapping("edit")
    public String edit() {
        return "/WEB-INF/jsp/employee_edit.jsp";
    }

    /*跳转编辑*/
    @RequestMapping("add")
    public String add() {
        return "/WEB-INF/jsp/employee_add.jsp";
    }

    /*增加方法*/
    @RequestMapping("insert")
    @ResponseBody
    public Map<String, Object> insert(Employee employee) {
        Map<String, Object> data = new HashMap<>();
        Employee isExist = employeeService.queryEmployeeById(employee);
        if (isExist == null) {
            int i = employeeService.insertEmployee(employee);
            if (i > 0) {
                data.put("status", 200);
                data.put("msg", "OK");
            }
        } else {
            data.put("msg","该员工编号已经存在，请更换员工编号!");
        }
        return data;
    }

    /*删除*/
    @RequestMapping("delete_batch")
    @ResponseBody
    public Map<String,Object> deleteBatch(String[] ids) {
        Map<String, Object> data = new HashMap<>();
        int i = employeeService.deleteBatch(ids);
        if (i > 0) {
            data.put(("msg"),"OK");
            data.put("status",200);
            data.put("data",null);
        } else {
            data.put("msg","删除失败");
        }
        return data;
    }

    /*修改方法*/
    @RequestMapping("update_all")
    @ResponseBody
    public Map<String,Object> updateAll(Employee employee) {
        Map<String, Object> data = new HashMap<>();
        int i = employeeService.updateAll(employee);
        if (i > 0) {
            data.put("status", 200);
            data.put("msg", "OK");
        } else {
            data.put("msg","服务器开小差了");
        }
        return data;
    }

    /*id模糊查询*/
    @RequestMapping("search_employee_by_employeeId")
    @ResponseBody
    public EmployeePage searchEmployeeByEmpId(String searchValue, int page, int rows) {
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder term = stringBuilder.append("%").append(searchValue).append("%");  // 拼接查詢條件
        PageHelper.startPage(page,rows);
        List<Employee> list = employeeService.searchEmployeeById(term.toString());

        PageInfo<Employee> pageInfo = new PageInfo<>(list);
        long total = pageInfo.getTotal();
        EmployeePage employeePage = new EmployeePage();
        employeePage.setRows(list);
        employeePage.setTotal(((int) total));
        return employeePage;
    }

    /*员工姓名模糊查询*/
    @RequestMapping("search_employee_by_employeeName")
    @ResponseBody
    public EmployeePage searchEmployeeByEmpName(String searchValue, int page, int rows) {
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder term = stringBuilder.append("%").append(searchValue).append("%");  // 拼接查詢條件

        PageHelper.startPage(page,rows);
        List<Employee> list = employeeService.searchEmployeeByEmpName(term.toString());
        PageInfo<Employee> pageInfo = new PageInfo<>(list);
        long total = pageInfo.getTotal();
        EmployeePage employeePage = new EmployeePage();

        employeePage.setRows(list);
        employeePage.setTotal(((int) total));
        return employeePage;
    }

    @RequestMapping("search_employee_by_departmentName")
    @ResponseBody
    public EmployeePage searchEmployeeByDepartmentName(String searchValue, int page, int rows) {
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder term = stringBuilder.append("%").append(searchValue).append("%");  // 拼接查詢條件

        PageHelper.startPage(page,rows);
        List<Employee> list = employeeService.searchEmployeeByDepartmentName(term.toString());
        PageInfo<Employee> pageInfo = new PageInfo<>(list);
        long total = pageInfo.getTotal();
        EmployeePage employeePage = new EmployeePage();

        employeePage.setRows(list);
        employeePage.setTotal(((int) total));
        return employeePage;
    }

}
