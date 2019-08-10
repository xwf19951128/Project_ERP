package com.cskaoyan.controller.schedule;

import com.cskaoyan.bean.schedule.*;
import com.cskaoyan.bean.technology.Process;
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
    public List<Custom> showCustomList(int page, int rows, HttpServletRequest request, HttpServletResponse response){
        ArrayList<String> list = new ArrayList<>();
        list.add("order:add");
        list.add("order:edit");
        list.add("order:delete");
        request.getSession().setAttribute("sysPermissionList",list);
        return service.queryCustomListByPage(page,rows);
    }
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
    @RequestMapping("/order/list")
    @ResponseBody
    public SchedulList<Order> showOrderList(int page, int rows, HttpServletRequest request, HttpServletResponse response){
        return service.queryOrderListByPage(page,rows);
    }

    @RequestMapping("/product/list")
    @ResponseBody
    public List<Product> showProductList(int page, int rows , HttpServletRequest request, HttpServletResponse response){
        ArrayList<String> list = new ArrayList<>();
        list.add("order:add");
        list.add("order:edit");
        list.add("order:delete");
        request.getSession().setAttribute("sysPermissionList",list);
        return service.queryProductListByPage(page,rows);
    }
    @RequestMapping("/work/list")
    @ResponseBody
    public List<Work> showWorkList(int page, int rows , HttpServletRequest request, HttpServletResponse response){
        ArrayList<String> list = new ArrayList<>();
        list.add("order:add");
        list.add("order:edit");
        list.add("order:delete");
        request.getSession().setAttribute("sysPermissionList",list);
        return service.queryWorkListByPage(page,rows);
    }
    @RequestMapping("/manufacture/list")
    @ResponseBody
    public List<Manufacture> showManufactureList(int page, int rows , HttpServletRequest request, HttpServletResponse response){
        ArrayList<String> list = new ArrayList<>();
        list.add("order:add");
        list.add("order:edit");
        list.add("order:delete");
        request.getSession().setAttribute("sysPermissionList",list);
        return service.queryManufactureByPage(page,rows);
    }
    @RequestMapping("/task/list")
    @ResponseBody
    public List<Task> showTaskList(int page, int rows , HttpServletRequest request, HttpServletResponse response){
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
    @RequestMapping("/custom/edit_judge")
    @ResponseBody
    public String goEditC(){
        return null;
    }
    @RequestMapping("/product/edit_judge")
    @ResponseBody
    public String goEditP(){
        return null;
    }
    @RequestMapping("/order/edit_judge")
    @ResponseBody
    public String goEditOrderNote(){
        return null;
    }
    @RequestMapping("/order/edit")
    public String goEditOrder(){
        return "/WEB-INF/jsp/order_edit.jsp";
    }
    @RequestMapping("/order/add_judge")
    @ResponseBody
    public String goAddOrder(){
        return null;
    }
    @RequestMapping("/order/add")
    public String goAddOrder0(){
        return "/WEB-INF/jsp/order_add.jsp";
    }
    @RequestMapping("/order/delete_judge")
    @ResponseBody
    public String goDeleteOrder(){
        return null;
    }
    @RequestMapping("/custom/get_data")
    @ResponseBody
    public List<Custom> getAllCustom(){
        return service.queryCustoms();
    }
    @RequestMapping("/product/get_data")
    @ResponseBody
    public List<Product> getAllProducts(){
        return service.queryProducts();
    }

    @RequestMapping("/order/get_data")
    @ResponseBody
    public List<Order> getAllOrder(){
        return service.queryOrders();
    }
    @RequestMapping("/process/get_data")
    @ResponseBody
    public List<Process> getAllProcess(){
        return null;
    }
}
