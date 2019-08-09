package com.cskaoyan.service;

import com.cskaoyan.bean.*;

import java.util.List;

public interface ScheduleService {


    SchedulList<Custom> queryCustomListByPage(Integer page, Integer rows);

    SchedulList<Order> queryOrderListByPage(Integer page, Integer rows);

    SchedulList<Product> queryProductListByPage(Integer page, Integer rows);

    SchedulList<Work> queryWorkListByPage(Integer page, Integer rows);

    SchedulList<Manufacture> queryManufactureByPage(Integer page, Integer rows);

    SchedulList<Task> queryTaskByPage(Integer page, Integer rows);

    SchedulList<Order> searchOrderListByID(Integer searchValue, Integer page, Integer rows);

    Custom queryCustomByID(Integer id);

    Product queryProductByID(Integer pid);
    List<Order> queryOrders();
}
