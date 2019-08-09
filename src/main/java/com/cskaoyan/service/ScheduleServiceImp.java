package com.cskaoyan.service;

import com.cskaoyan.bean.schedule.*;
import com.cskaoyan.mapper.schedule.ProductMapper;
import com.cskaoyan.mapper.schedule.ScheduleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleServiceImp implements ScheduleService{
    @Autowired
    ScheduleMapper scheduleMapper;
    @Autowired
    ProductMapper productMapper;

    @Override
    public SchedulList<Custom> queryCustomListByPage(Integer page, Integer rows) {
        return null;
    }

    @Override
    public SchedulList<Order> queryOrderListByPage(Integer page, Integer rows) {
        SchedulList<Order> list=new SchedulList();
        List<Order> admins= scheduleMapper.queryPage(rows,rows*(page-1));
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

    @Override
    public int updateCustom(Custom custom) {
        return scheduleMapper.updateCustom(custom);
    }

    @Override
    public int updateInfo(Custom custom) {
        return scheduleMapper.updateCustom(custom);
    }

    @Override
    public int updateInfo(Product product) {
        return productMapper.updateByPrimaryKeySelective(product);
    }
    @Override
    public int updateOrder(Order order) {
        return scheduleMapper.updateOrderAll(order);
    }

    @Override
    public int updateInfo(Manufacture manufacture) {
        return 0;
    }

    @Override
    public int updateInfo(Task task) {
        return 0;
    }

    @Override
    public int updateInfo(Work work) {
        return 0;
    }

    @Override
    public int updateInfo(Order order) {
        return scheduleMapper.updateByPrimaryKeySelective(order);
    }

    @Override
    public List<Custom> queryCustoms() {
        return scheduleMapper.queryCustoms();
    }
    @Override
    public List<Product> queryProducts() {
        return scheduleMapper.queryProducts();
    }

    @Override
    public int insertOrder(Order order) {
        return scheduleMapper.insert(order);
    }

    @Override
    public int deleteOrderByID(String id) {
        return scheduleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int deletepathByOid(String oid) {
        return scheduleMapper.deletepathByOid(oid);
    }
}
