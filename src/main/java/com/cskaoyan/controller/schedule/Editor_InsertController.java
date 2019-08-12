package com.cskaoyan.controller.schedule;

import com.cskaoyan.bean.schedule.*;
import com.cskaoyan.service.schedule.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 增加记录操作的Controller
 */
@Controller
public class Editor_InsertController {
    @Autowired
    ScheduleService service;
    @RequestMapping("/order/insert")
    @ResponseBody
    public MessageBean insertOrder(Order order){
        if(service.insertOrder(order)==1){
            return new MessageBean("200","ok",null);
        }
        return new MessageBean("404","修改失败",null );
    }
    @RequestMapping("/custom/insert")
    @ResponseBody
    public MessageBean insertCustom(Custom custom){
        if(service.insertCustom(custom)==1){
            return new MessageBean("200","ok",null);
        }
        return new MessageBean("404","添加失败",null );
    }
    @RequestMapping("/product/insert")
    @ResponseBody
    public MessageBean insertProduct(Product custom){
        if(service.insertProduct(custom)==1){
            return new MessageBean("200","ok",null);
        }
        return new MessageBean("404","添加失败",null );
    }
    @RequestMapping("/work/insert")
    @ResponseBody
    public MessageBean insertWork(Work custom){
        if(service.insertWork(custom)==1){
            return new MessageBean("200","ok",null);
        }
        return new MessageBean("404","添加失败",null );
    }
    @RequestMapping("/manufacture/insert")
    @ResponseBody
    public MessageBean insertManufacture(Manufacture custom){
        if(service.insertManufacture(custom)==1){
            return new MessageBean("200","ok",null);
        }
        return new MessageBean("404","添加失败",null );
    }
    @RequestMapping("/task/insert")
    @ResponseBody
    public MessageBean insert(Task task){
        int i = service.insertTask(task);
        if (i==1)
        { return new MessageBean("200","ok",null);
        }
        return new MessageBean("404","false",null);
    }
}
