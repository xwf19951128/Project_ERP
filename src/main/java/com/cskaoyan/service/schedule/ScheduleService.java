package com.cskaoyan.service.schedule;

import com.cskaoyan.bean.schedule.*;

import java.util.List;

public interface ScheduleService {


    List<Custom> queryCustomListByPage(Integer page, Integer rows);

    SchedulList<Order> queryOrderListByPage(Integer page, Integer rows);

    SchedulList<Product> queryProductListByPage(Integer page, Integer rows);

    SchedulList<Work> queryWorkListByPage(Integer page, Integer rows);

    SchedulList<Manufacture> queryManufactureByPage(Integer page, Integer rows);

    SchedulList<Task> queryTaskByPage(Integer page, Integer rows);

    SchedulList<Order> searchOrderListByID(String searchValue, Integer page, Integer rows);

    Custom queryCustomByID(Integer id);

    Product queryProductByID(Integer pid);
    List<Order> queryOrders();

    int updateCustom(Custom custom);

    int updateInfo(Custom custom);
    int updateInfo(Product product);

    int updateOrder(Order order);

    int updateInfo(Manufacture manufacture);
    int updateInfo(Task task);
    int updateInfo(Work work);
    int updateInfo(Order order);

    List<Custom> queryCustoms();

    List<Product> queryProducts();

    int insertOrder(Order order);

    int deleteOrderByID(String id);

    SchedulList<Order> searchOrderListByProduct(String searchValue, int page, int rows);

    SchedulList<Order> searchOrderListByCustom(String searchValue, int page, int rows);

    int insertTask(Task custom);

    int insertManufacture(Manufacture custom);

    int insertWork(Work custom);

    int insertProduct(Product custom);

    int insertCustom(Custom custom);

    int deleteManufactureByID(String ids);

    int deleteWorkByID(String ids);

    int deleteProductByID(String ids);

    int deleteCustomByID(String ids);

    SchedulList<Manufacture> searchManufactureByOrderID(String searchValue, int page, int rows);

    SchedulList<Manufacture> searchManufactureByTecName(String searchValue, int page, int rows);

    SchedulList<Manufacture> searchManufactureByID(String searchValue, int page, int rows);

    SchedulList<Work> queryWorkProcessByProcessId(String searchValue, int page, int rows);

    SchedulList<Work> searchWorkByDev(String searchValue, int page, int rows);

    SchedulList<Work> searchWorkProductListByName(String searchValue, int page, int rows);

    SchedulList<Work> searchWorkByID(String searchValue, int page, int rows);

    SchedulList<Product> searchProductByType(String searchValue, int page, int rows);

    SchedulList<Product> searchProductListByName(String searchValue, int page, int rows);

    SchedulList<Product> searchProductByID(String searchValue, int page, int rows);

    SchedulList<Custom> searchCustomListByName(String searchValue, int page, int rows);

    SchedulList<Custom> searchCustomListByID(String searchValue, int page, int rows);

    List<Manufacture> queryManufacture();

    Manufacture queryManufactureById(String id);

    List<Work> queryWorkList();

    Work queryWorkById(String id);

    int deleteTaskByIds(String[] ids);

    SchedulList<Task> searchTaskByManufactureSn(String searchValue, int page, int rows);

    SchedulList<Task> searchTaskByWorkId(String searchValue, int page, int rows);

    SchedulList<Task> searchTaskByTaskId(String searchValue, int page, int rows);
}
