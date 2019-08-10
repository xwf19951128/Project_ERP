package com.cskaoyan.controller.qualifyMonitor;

import com.cskaoyan.bean.qualifyMonitor.Employee;
import com.cskaoyan.bean.qualifyMonitor.Product;
import com.cskaoyan.service.qualifyMonitor.EmployeeService;
import com.cskaoyan.service.qualifyMonitor.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class AddController {

    @Autowired
    ProductService productService;

    @Autowired
    EmployeeService employeeService;



    // 获取员工名称
    @RequestMapping("/employee/get_data")
    @ResponseBody
    public List<Employee> getEmployee() {
        List<Employee> employees = employeeService.queryEmployee();
        return employees;
    }

}
