package com.cskaoyan.controller.schedule;

import com.cskaoyan.bean.schedule.*;
import com.cskaoyan.mapper.schedule.ScheduleMapper;
import com.cskaoyan.service.schedule.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 这是获取单个类的Controller
 */
@Controller
public class GetDataController {
    @Autowired
    ScheduleService service;
    @Autowired
    ScheduleMapper mapper;
    @RequestMapping("/custom/get/{cid}")
    @ResponseBody
    public Custom showCustom(@PathVariable("cid") int id){
        return service.queryCustomByID(id);
    }
    @RequestMapping("/order/get/{id}")
    @ResponseBody
    public Order showOrder(@PathVariable("id") String id){
        return mapper.selectByPrimaryKey(id);
    }
    @RequestMapping("/product/get/{pid}")
    @ResponseBody
    public Product showProduct(@PathVariable("pid") int pid){
        return service.queryProductByID(pid);
    }
    @RequestMapping("/manufacture/get/{id}")
    @ResponseBody
    public Manufacture getOneManufacture(@PathVariable("id") String id){
        return service.queryManufactureById(id);
    }
    @RequestMapping("/work/get/{id}")
    @ResponseBody
    public Work showWork(@PathVariable("id") String id){
        return service.queryWorkById(id);
    }
    @RequestMapping("/task/get/{id}")
    @ResponseBody
    public Task showTask(@PathVariable("id") String id){
        return service.queryTaskById(id);
    }
}
