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

@Controller
public class ScheduleController {
    @Autowired
    ScheduleService service;
    @Autowired
    ScheduleMapper scheduleMapper;
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
    //
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
    @RequestMapping("/custom/get/{cid}")
    @ResponseBody
    public Custom showCustom(@PathVariable("cid") int id){
       return service.queryCustomByID(id);
    }
    @RequestMapping("/order/get/{id}")
    @ResponseBody
    public Order showOrder(@PathVariable("id") String id){
        return scheduleMapper.selectByPrimaryKey(id);
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
    @RequestMapping("/work/edit_judge")
    @ResponseBody
    public String goEditWork0(){
        return null;
    }
    @RequestMapping("/manufacture/edit_judge")
    @ResponseBody
    public String goEditmanufacture0(){
        return null;
    }

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
    @RequestMapping("/order/add_judge")
    @ResponseBody
    public String goAddOrder(){
        return null;
    }
    @RequestMapping("/custom/add_judge")
    @ResponseBody
    public String goAddCustom0(){
        return null;
    }
    @RequestMapping("/product/add_judge")
    @ResponseBody
    public String goAddProduct0(){
        return null;
    }
    @RequestMapping("/work/add_judge")
    @ResponseBody
    public String goAddWork0(){
        return null;
    }
    @RequestMapping("/manufacture/add_judge")
    @ResponseBody
    public String goAddManufacture0(){
        return null;
    }
//    @RequestMapping("/task/add_judge")
//    @ResponseBody
//    public String goAddTask0(){
//        return null;
//    }
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
//    @RequestMapping("/task/add")
//    public String goAddTask(){
//        return "/WEB-INF/jsp/task_add.jsp";
//    }

    @RequestMapping("/order/delete_judge")
    @ResponseBody
    public String goDeleteOrder(){
        return null;
    }
    @RequestMapping("/custom/delete_judge")
    @ResponseBody
    public String goDC(){
        return null;
    }
    @RequestMapping("/product/delete_judge")
    @ResponseBody
    public String goDP(){
        return null;
    }
    @RequestMapping("/work/delete_judge")
    @ResponseBody
    public String goDW(){
        return null;
    }
    @RequestMapping("/manufacture/delete_judge")
    @ResponseBody
    public String goDM(){return null;
    }
//    @RequestMapping("/task/delete_judge")
//    @ResponseBody
//    public String goDT(){
//        return null;
//    }
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
}
