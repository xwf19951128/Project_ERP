package com.cskaoyan.controller.schedule;

import com.cskaoyan.bean.schedule.*;
import com.cskaoyan.bean.technology.Process;
import com.cskaoyan.mapper.schedule.ScheduleMapper;
import com.cskaoyan.service.schedule.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * 这是一个控制跳转JSP页面的Controller
 */
@Controller
public class JSPController {
/*
find部分
 */
    @RequestMapping("/order/find")
    public String showOrderList( HttpServletRequest request){
        ArrayList<String> list = new ArrayList<>();
        list.add("order:add");
        list.add("order:edit");
        list.add("order:delete");
        request.getSession().setAttribute("sysPermissionList",list);
        return "/WEB-INF/jsp/order_list.jsp";
    }
    @RequestMapping("/custom/find")
    public String showCustomList( HttpServletRequest request){
        ArrayList<String> list = new ArrayList<>();
        list.add("custom:add");
        list.add("custom:edit");
        list.add("custom:delete");
        request.getSession().setAttribute("sysPermissionList",list);
        return "/WEB-INF/jsp/custom_list.jsp";
    }
    @RequestMapping("/product/find")
    public String showProductList( HttpServletRequest request){
        ArrayList<String> list = new ArrayList<>();
        list.add("product:add");
        list.add("product:edit");
        list.add("product:delete");
        request.getSession().setAttribute("sysPermissionList",list);
        return "/WEB-INF/jsp/product_list.jsp";
    }@RequestMapping("/work/find")
    public String showWorkList( HttpServletRequest request){
        ArrayList<String> list = new ArrayList<>();
        list.add("work:add");
        list.add("work:edit");
        list.add("work:delete");
        request.getSession().setAttribute("sysPermissionList",list);
        return "/WEB-INF/jsp/work_list.jsp";
    }
    @RequestMapping("/manufacture/find")
    public String showManufactureList( HttpServletRequest request){
        ArrayList<String> list = new ArrayList<>();
        list.add("manufacture:add");
        list.add("manufacture:edit");
        list.add("manufacture:delete");
        request.getSession().setAttribute("sysPermissionList",list);
        return "/WEB-INF/jsp/manufacture_list.jsp";
    }
    @RequestMapping("/task/find")
    public String showTaskList( HttpServletRequest request){
        ArrayList<String> list = new ArrayList<>();
        list.add("task:add");
        list.add("task:edit");
        list.add("task:delete");
        request.getSession().setAttribute("sysPermissionList",list);
        return "/WEB-INF/jsp/task_list.jsp";
    }
    /*
    edit部分
     */
    @RequestMapping("/order/edit")
    public String goEditOrder(){
        return "/WEB-INF/jsp/order_edit.jsp";
    }
    @RequestMapping("/custom/edit")
    public String goEditCustom(){
        return "/WEB-INF/jsp/custom_edit.jsp";
    }
    @RequestMapping("/product/edit")
    public String goEditProduct(){
        return "/WEB-INF/jsp/product_edit.jsp";
    }
    @RequestMapping("work/edit")
    public String goEditWork(){
        return "/WEB-INF/jsp/work_edit.jsp";
    }
    @RequestMapping("/manufacture/edit")
    public String goEditmanufacture(){
        return "/WEB-INF/jsp/manufacture_edit.jsp";
    }
    @RequestMapping("/task/edit")
    public String goEditTask(){
        return "/WEB-INF/jsp/task_edit.jsp";
    }
/*
add部分
 */
    @RequestMapping("/order/add")
    public String goAddOrder0(){
        return "/WEB-INF/jsp/order_add.jsp";
    }
    @RequestMapping("/custom/add")
    public String goAddCustom(){
        return "/WEB-INF/jsp/custom_add.jsp";
    }
    @RequestMapping("/product/add")
    public String goAddProduct(){
        return "/WEB-INF/jsp/product_add.jsp";
    }
    @RequestMapping("/work/add")
    public String goAddWork(){
        return "/WEB-INF/jsp/work_add.jsp";
    }
    @RequestMapping("/manufacture/add")
    public String goAddManufacture(){
        return "/WEB-INF/jsp/manufacture_add.jsp";
    }
    @RequestMapping("/task/add")
    public String goAddTask(){
        return "/WEB-INF/jsp/task_add.jsp";
    }
}
