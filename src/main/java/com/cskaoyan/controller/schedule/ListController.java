package com.cskaoyan.controller.schedule;

import com.cskaoyan.bean.schedule.*;
import com.cskaoyan.mapper.schedule.ScheduleMapper;
import com.cskaoyan.service.schedule.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * 这是一个获取列表的Controller
 */
@Controller
public class ListController {
    @Autowired
    ScheduleService service;
    @Autowired
    ScheduleMapper scheduleMapper;
    /**
     * 以下部分是显示列表操作
     */
    @RequestMapping("/custom/list")
    @ResponseBody
    public List<Custom> showCustomList(int page, int rows, HttpServletRequest request, HttpServletResponse response){
        return service.queryCustomListByPage(page,rows);
    }
    @RequestMapping("/order/list")
    @ResponseBody
    public SchedulList<Order> showOrderList(int page, int rows, HttpServletRequest request, HttpServletResponse response){
        return service.queryOrderListByPage(page,rows);
    }

    @RequestMapping("/product/list")
    @ResponseBody
    public SchedulList<Product> showProductList(int page, int rows , HttpServletRequest request, HttpServletResponse response){
        return service.queryProductListByPage(page,rows);
    }
    @RequestMapping("/work/list")
    @ResponseBody
    public SchedulList<Work> showWorkList(int page, int rows , HttpServletRequest request, HttpServletResponse response){
        return service.queryWorkListByPage(page,rows);
    }
    @RequestMapping("/manufacture/list")
    @ResponseBody
    public SchedulList<Manufacture> showManufactureList(int page, int rows , HttpServletRequest request, HttpServletResponse response){
        return service.queryManufactureByPage(page,rows);
    }
    @RequestMapping("/task/list")
    @ResponseBody
    public SchedulList<Task> showTaskList(int page, int rows , HttpServletRequest request, HttpServletResponse response){
        return service.queryTaskByPage(page,rows);
    }
    /**
     * 以下部分是模糊查询的列表显示
     */
    @ResponseBody
    @RequestMapping("/order/search_order_by_orderId")
    public SchedulList<Order> searchOrderList(String searchValue, int page, int rows){
        return service.searchOrderListByID(searchValue,page,rows);
    }
    @ResponseBody
    @RequestMapping("/order/search_order_by_orderCustom")
    public SchedulList<Order> searchOrderListC(String searchValue,int page,int rows){
        return service.searchOrderListByCustom(searchValue,page,rows);
    }
    @ResponseBody
    @RequestMapping("/order/search_order_by_orderProduct")
    public SchedulList<Order> searchOrderListP(String searchValue,int page,int rows){
        return service.searchOrderListByProduct(searchValue,page, rows);
    }
    //
    @ResponseBody
    @RequestMapping("/custom/search_custom_by_customId")
    public SchedulList<Custom> searchCustomList(String searchValue, int page, int rows){
        return service.searchCustomListByID(searchValue,page,rows);
    }
    @ResponseBody
    @RequestMapping("/custom/search_custom_by_customName")
    public SchedulList<Custom> searchCustomListN(String searchValue,int page,int rows){
        return service.searchCustomListByName(searchValue,page,rows);
    }
    //
    @ResponseBody
    @RequestMapping("/product/search_product_by_productId")
    public SchedulList<Product> searchProductByID(String searchValue,int page,int rows){
        return service.searchProductByID(searchValue,page, rows);
    }
    @ResponseBody
    @RequestMapping("/product/search_product_by_productName")
    public SchedulList<Product> searchProductListByName(String searchValue, int page, int rows){
        return service.searchProductListByName(searchValue,page,rows);
    }
    @ResponseBody
    @RequestMapping("/product/search_product_by_productType")
    public SchedulList<Product> searchProductByType(String searchValue,int page,int rows){
        return service.searchProductByType(searchValue,page,rows);
    }
    //
    @ResponseBody
    @RequestMapping("/work/search_work_by_workId")
    public SchedulList<Work> searchWorkByID(String searchValue,int page,int rows){
        return service.searchWorkByID(searchValue,page, rows);
    }
    @ResponseBody
    @RequestMapping("/work/search_work_by_workProduct")
    public SchedulList<Work> searchWorkProductListByName(String searchValue, int page, int rows){
        return service.searchWorkProductListByName(searchValue,page,rows);
    }
    @ResponseBody
    @RequestMapping("/work/search_work_by_workDevice")
    public SchedulList<Work> searchWorkByDev(String searchValue,int page,int rows){
        return service.searchWorkByDev(searchValue,page,rows);
    }
    @RequestMapping("/work/search_work_by_workProcess")
    @ResponseBody
    public SchedulList<Work> queryWorkProcessByProcessId(String searchValue,int page,int rows){
        return service.queryWorkProcessByProcessId(searchValue,page,rows);
    }
    /*
     */
    @ResponseBody
    @RequestMapping("/manufacture/search_manufacture_by_manufactureSn")
    public SchedulList<Manufacture> searchManufactureByID(String searchValue,int page,int rows){
        return service.searchManufactureByID(searchValue,page, rows);
    }
    @ResponseBody
    @RequestMapping("/manufacture/search_manufacture_by_manufactureOrderId")
    public SchedulList<Manufacture> searchManufactureByOrderID(String searchValue, int page, int rows){
        return service.searchManufactureByOrderID(searchValue,page,rows);
    }
    @ResponseBody
    @RequestMapping("/manufacture/search_manufacture_by_manufactureTechnologyName")
    public SchedulList<Manufacture> searchManufactureByTecName(String searchValue,int page,int rows){
        return service.searchManufactureByTecName(searchValue,page,rows);
    }
    /*模糊查询：根据生产派工编号查询派工管理*/
    @RequestMapping("/task/search_task_by_taskId")
    @ResponseBody
    public SchedulList<Task> searchTaskByTaskId(String searchValue, int page,int rows){
        return service.searchTaskByTaskId(searchValue,page,rows);
    }
    /*模糊查询：根据作业编号查询派工管理*/
    @RequestMapping("/task/search_task_by_taskWorkId")
    @ResponseBody
    public  SchedulList<Task> searchTaskByWorkId(String searchValue, int page,int rows){
        return service.searchTaskByWorkId(searchValue,page,rows);
    }
    /*模糊查询：根据生产批号查询派工管理*/
    @RequestMapping("/task/search_task_by_taskManufactureSn")
    @ResponseBody
    public SchedulList<Task> searchTaskByManufactureSn(String searchValue, int page, int rows){
        return service.searchTaskByManufactureSn(searchValue,page,rows);
    }
    /**
     * 以下部分是获取下拉列表的操作
     */
    @RequestMapping("/custom/get_data")
    @ResponseBody
    public List<Custom> getAllCustoms(){
        return service.queryCustoms();
    }
    @RequestMapping("/product/get_data")
    @ResponseBody
    public List<Product> getAllProducts(){
        return service.queryProducts();
    }
    @RequestMapping("/order/get_data")
    @ResponseBody
    public List<Order> getAllOrders(){
        return service.queryOrders();
    }
    @RequestMapping("/manufacture/get_data")
    @ResponseBody
    public List<Manufacture> getAllManufactures(){
        List<Manufacture> manufactures = service.queryManufacture();
        return manufactures;
    }
    @RequestMapping("/work/get_data")
    @ResponseBody
    public List<Work> getAllWorks(){
        return service.queryWorkList();
    }
}
