package com.cskaoyan.service.schedule;

import com.cskaoyan.bean.schedule.*;
import com.cskaoyan.bean.technology.Technology;
import com.cskaoyan.mapper.schedule.*;
import com.cskaoyan.service.technology.TechnologyService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ScheduleServiceImp implements ScheduleService{
    @Autowired
    ScheduleMapper scheduleMapper;
    @Autowired
    ProductMapper productMapper;
@Autowired
    ManufactureMapper manufactureMapper;
@Autowired
    WorkMapper workMapper;
@Autowired
    TaskMapper taskMapper;
@Autowired
CustomMapper customMapper;
@Autowired
TechnologyService technologyMapper;
    @Override
    public List<Custom> queryCustomListByPage(Integer page, Integer rows) {

        PageHelper.startPage(page,rows);return customMapper.queryList();
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
        PageHelper.startPage(page,rows);
        List<Product> list=productMapper.queryList();
        SchedulList<Product> schedulList = new SchedulList<>();
        PageInfo<Product> pageInfo = new PageInfo<>(list);
        schedulList.setTotal((int) pageInfo.getTotal());
        schedulList.setRows(list);
        return schedulList;
    }

    @Override
    public SchedulList<Work> queryWorkListByPage(Integer page, Integer rows) {
        List<Work> list=workMapper.queryList(rows,rows*(page-1));
        SchedulList<Work> schedulList = new SchedulList<>();
        schedulList.setTotal(workMapper.queryCount());
        schedulList.setRows(list);
        return schedulList;
    }

    @Override
    public SchedulList<Manufacture> queryManufactureByPage(Integer page, Integer rows) {
        List<Manufacture> list=manufactureMapper.queryList(rows*(page-1),rows);
        SchedulList<Manufacture> schedulList = new SchedulList<>();
        schedulList.setTotal(manufactureMapper.countNumber());
        schedulList.setRows(list);
        return schedulList;
    }

    @Override
    public SchedulList<Task> queryTaskByPage(Integer page, Integer rows) {
        PageHelper.startPage(page,rows);
        List<Task> list=taskMapper.queryList();
        SchedulList<Task> schedulList = new SchedulList<>();
        PageInfo<Task> pageInfo = new PageInfo<>(list);
        schedulList.setTotal((int) pageInfo.getTotal());
        schedulList.setRows(list);
        return schedulList;
    }

    @Override
    public SchedulList<Order> searchOrderListByID(String searchValue, Integer page, Integer rows) {
        PageHelper.startPage(page,rows);
        SchedulList<Order> orderSchedulList = new SchedulList<>();
        List<Order> list=scheduleMapper.queryOrdersByID("%"+searchValue+"%");
        PageInfo<Order> pageInfo = new PageInfo<>(list);
        orderSchedulList.setTotal((int) pageInfo.getTotal());
        orderSchedulList.setRows( list);
        return orderSchedulList;
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
        return customMapper.updateByPrimaryKeySelective(custom);
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
        return manufactureMapper.updateByPrimaryKeySelective(manufacture);
    }

    @Override
    public int updateInfo(Task task) {
        return taskMapper.updateByPrimaryKeySelective(task);
    }

    @Override
    public int updateInfo(Work work) {
        return workMapper.updateByPrimaryKeySelective(work);
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
    public SchedulList<Order> searchOrderListByProduct(String searchValue, int page, int rows) {
        PageHelper.startPage(page,rows);
        SchedulList<Order> orderSchedulList = new SchedulList<>();
        List<Order> list=scheduleMapper.queryOrdersByP("%"+searchValue+"%");
        PageInfo<Order> pageInfo = new PageInfo<>(list);
        orderSchedulList.setTotal((int) pageInfo.getTotal());
        orderSchedulList.setRows(list );
        return orderSchedulList;
    }

    @Override
    public SchedulList<Order> searchOrderListByCustom(String searchValue, int page, int rows) {
        PageHelper.startPage(page,rows);
        SchedulList<Order> orderSchedulList = new SchedulList<>();
        List<Order> list=scheduleMapper.queryOrdersByC("%"+searchValue+"%");
        PageInfo<Order> pageInfo = new PageInfo<>(list);
        orderSchedulList.setTotal((int) pageInfo.getTotal());
        orderSchedulList.setRows(list );
        return orderSchedulList;
    }

    @Override
    public int insertTask(Task custom) {
        return taskMapper.insert(custom);
    }

    @Override
    public int insertManufacture(Manufacture custom) {
        return manufactureMapper.insert(custom);
    }

    @Override
    public int insertWork(Work custom) {
        return workMapper.insert(custom);
    }

    @Override
    public int insertProduct(Product custom) {
        return productMapper.insert(custom);
    }

    @Override
    public int insertCustom(Custom custom) {
        return customMapper.insert(custom);
    }

    @Override
    public int deleteManufactureByID(String ids) {
        return manufactureMapper.deleteByPrimaryKey(ids);
    }

    @Override
    public int deleteWorkByID(String ids) {
        return workMapper.deleteByPrimaryKey(ids);
    }

    @Override
    public int deleteProductByID(String ids) {
        return productMapper.deleteByPrimaryKey(ids);
    }

    @Override
    public int deleteCustomByID(String ids) {
        return customMapper.deleteByPrimaryKey(ids);
    }

    @Override
    public SchedulList<Manufacture> searchManufactureByOrderID(String searchValue, int page, int rows) {
        return null;
    }

    @Override
    public SchedulList<Manufacture> searchManufactureByTecName(String searchValue, int page, int rows) {
        return null;
    }

    @Override
    public SchedulList<Manufacture> searchManufactureByID(String searchValue, int page, int rows) {
        return null;
    }

    @Override
    public SchedulList<Work> queryWorkProcessByProcessId(String searchValue, int page, int rows) {
        return null;
    }

    @Override
    public SchedulList<Work> searchWorkByDev(String searchValue, int page, int rows) {
        return null;
    }

    @Override
    public SchedulList<Work> searchWorkProductListByName(String searchValue, int page, int rows) {
        return null;
    }

    @Override
    public SchedulList<Work> searchWorkByID(String searchValue, int page, int rows) {
        return null;
    }

    @Override
    public SchedulList<Product> searchProductByType(String searchValue, int page, int rows) {
        return null;
    }

    @Override
    public SchedulList<Product> searchProductListByName(String searchValue, int page, int rows) {
        return null;
    }

    @Override
    public SchedulList<Product> searchProductByID(String searchValue, int page, int rows) {
        return null;
    }

    @Override
    public SchedulList<Custom> searchCustomListByName(String searchValue, int page, int rows) {
        PageHelper.startPage(page,rows);
        SchedulList<Custom> customSchedulList = new SchedulList<>();
        List<Custom> list=customMapper.searchCustomListByName("%"+searchValue+"%");
        PageInfo<Custom> pageInfo = new PageInfo<>(list);
        customSchedulList.setTotal((int) pageInfo.getTotal());
        customSchedulList.setRows(list );
        return customSchedulList;
    }

    @Override
    public SchedulList<Custom> searchCustomListByID(String searchValue, int page, int rows) {
        PageHelper.startPage(page,rows);
        SchedulList<Custom> customSchedulList = new SchedulList<>();
        List<Custom> list=customMapper.searchCustomListByID("%"+searchValue+"%");
        PageInfo<Custom> pageInfo = new PageInfo<>(list);
        customSchedulList.setTotal((int) pageInfo.getTotal());
        customSchedulList.setRows(list );
        return customSchedulList;

    }
}
