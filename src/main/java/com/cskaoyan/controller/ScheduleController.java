package com.cskaoyan.controller;

import com.cskaoyan.bean.*;
import com.cskaoyan.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ScheduleController {
    @Autowired
    ScheduleService service;
    @RequestMapping("/custom/list")
    @ResponseBody
    public SchedulList<Custom> showCustomList(int page,int rows,HttpServletRequest request, HttpServletResponse response){
        ArrayList<String> list = new ArrayList<>();
        list.add("order:add");
        list.add("order:edit");
        list.add("order:delete");
        request.getSession().setAttribute("sysPermissionList",list);
        return service.queryCustomListByPage(page,rows);
    }
    @RequestMapping("/order/find")
    public String showOrderList( HttpServletRequest request, HttpServletResponse response){
        ArrayList<String> list = new ArrayList<>();
        list.add("order:add");
        list.add("order:edit");
        list.add("order:delete");
        request.getSession().setAttribute("sysPermissionList",list);
        return "/WEB-INF/jsp/order_list.jsp";
    }
    @RequestMapping("/order/list")
    @ResponseBody
    public SchedulList<Order> showOrderList( int page, int rows,HttpServletRequest request, HttpServletResponse response){
        return service.queryOrderListByPage(page,rows);
    }

    @RequestMapping("/product/list")
    @ResponseBody
    public SchedulList<Product> showProductList(int page, int rows , HttpServletRequest request, HttpServletResponse response){
        ArrayList<String> list = new ArrayList<>();
        list.add("order:add");
        list.add("order:edit");
        list.add("order:delete");
        request.getSession().setAttribute("sysPermissionList",list);
        return service.queryProductListByPage(page,rows);
    }
    @RequestMapping("/work/list")
    @ResponseBody
    public SchedulList<Work> showWorkList(int page, int rows , HttpServletRequest request, HttpServletResponse response){
        ArrayList<String> list = new ArrayList<>();
        list.add("order:add");
        list.add("order:edit");
        list.add("order:delete");
        request.getSession().setAttribute("sysPermissionList",list);
        return service.queryWorkListByPage(page,rows);
    }
    @RequestMapping("/manufacture/list")
    @ResponseBody
    public SchedulList<Manufacture> showManufactureList(int page, int rows , HttpServletRequest request, HttpServletResponse response){
        ArrayList<String> list = new ArrayList<>();
        list.add("order:add");
        list.add("order:edit");
        list.add("order:delete");
        request.getSession().setAttribute("sysPermissionList",list);
        return service.queryManufactureByPage(page,rows);
    }
    @RequestMapping("/task/list")
    @ResponseBody
    public SchedulList<Task> showTaskList(int page, int rows , HttpServletRequest request, HttpServletResponse response){
        ArrayList<String> list = new ArrayList<>();
        list.add("order:add");
        list.add("order:edit");
        list.add("order:delete");
        request.getSession().setAttribute("sysPermissionList",list);
        return service.queryTaskByPage(page,rows);
    }
    @ResponseBody
    @RequestMapping("/order/search_order_by_orderId")
    public SchedulList<Order> searchOrderList(int searchValue,int page,int rows){
        ArrayList<String> list = new ArrayList<>();
        list.add("order:add");
        list.add("order:edit");
        list.add("order:delete");
        return service.searchOrderListByID(searchValue,page,rows);
    }
    @RequestMapping("/custom/get/{cid}")
    @ResponseBody
    public Custom showCustom(@PathVariable("cid") int id){
       return service.queryCustomByID(id);
    }
    @RequestMapping("/product/get/{pid}")
    @ResponseBody
    public Product showProduct(@PathVariable("pid") int pid){
        return service.queryProductByID(pid);
    }
}
