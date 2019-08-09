package com.cskaoyan.service;

import com.cskaoyan.bean.*;
import com.cskaoyan.mapper.ScheduleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.beans.Transient;
import java.util.List;

@Service
public class ScheduleServiceImp implements ScheduleService{
    @Autowired
    ScheduleMapper scheduleMapper;

    @Override
    public SchedulList<Custom> queryCustomListByPage(Integer page, Integer rows) {
        return null;
    }

    @Override
    public SchedulList<Order> queryOrderListByPage(Integer page, Integer rows) {
        SchedulList<Order> list=new SchedulList();
        List<Order> admins= scheduleMapper.queryPage(rows,rows*(page-1));
        for (Order admin : admins) {
            admin.setCustom(scheduleMapper.queryCustomByID(Integer.valueOf(admin.getCustomId())));
            admin.setProduct(scheduleMapper.queryProductByID(Integer.valueOf(admin.getProductId())));
        }
        list.setTotal(scheduleMapper.queryOrderCount().intValue());
        list.setRows(admins);
        return list;
    }

    @Override
    public SchedulList<Product> queryProductListByPage(Integer page, Integer rows) {
        return null;
    }

    @Override
    public SchedulList<Work> queryWorkListByPage(Integer page, Integer rows) {
        return null;
    }

    @Override
    public SchedulList<Manufacture> queryManufactureByPage(Integer page, Integer rows) {
        return null;
    }

    @Override
    public SchedulList<Task> queryTaskByPage(Integer page, Integer rows) {
        return null;
    }

    @Override
    public SchedulList<Order> searchOrderListByID(Integer searchValue, Integer page, Integer rows) {
        return null;
    }

    @Override
    public Custom queryCustomByID(Integer id) {
        return scheduleMapper.queryCustomByID(id);
    }

    @Override
    public Product queryProductByID(Integer pid) {
        return scheduleMapper.queryProductByID(pid);
    }

    @Override
    public List<Order> queryOrders() {
        return scheduleMapper.queryOrders();
    }
}
