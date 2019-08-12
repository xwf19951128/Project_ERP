package com.cskaoyan.controller.schedule;

import com.cskaoyan.bean.schedule.MessageBean;
import com.cskaoyan.service.schedule.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 这是一个执行删除操作的Controller
 */
@Controller
public class Editor_DeleteController {
    @Autowired
    ScheduleService service;
    @RequestMapping("/order/delete_batch")
    @ResponseBody
    public MessageBean DeleteOrderConfirm(String[] ids){
        if(service.deleteOrderByID(ids)==ids.length){
            return new MessageBean("200","ok",null);
        }
        return new MessageBean("500","删除失败",null );
    }
    @RequestMapping("/custom/delete_batch")
    @ResponseBody
    public MessageBean DeleteCustomConfirm(String[] ids){
        if(service.deleteCustomByID(ids)==ids.length){
            return new MessageBean("200","ok",null);
        }
        return new MessageBean("500","删除失败",null );
    }
    @RequestMapping("/product/delete_batch")
    @ResponseBody
    public MessageBean DeleteProductConfirm(String[] ids){
        if(service.deleteProductByID(ids)==ids.length){
            return new MessageBean("200","ok",null);
        }
        return new MessageBean("500","删除失败",null );
    }
    @RequestMapping("/work/delete_batch")
    @ResponseBody
    public MessageBean DeleteWorkConfirm(String[] ids){
        if(service.deleteWorkByID(ids)==ids.length){
            return new MessageBean("200","ok",null);
        }
        return new MessageBean("500","删除失败",null );
    }
    @RequestMapping("/manufacture/delete_batch")
    @ResponseBody
    public MessageBean DeleteManufactureConfirm(String[] ids){
        if(service.deleteManufactureByID(ids)==ids.length){
            return new MessageBean("200","ok",null);
        }
        return new MessageBean("500","删除失败",null );
    }
    @RequestMapping("/task/delete_batch")
    @ResponseBody
    public MessageBean delete(String[] ids){
        int result = service.deleteTaskByIds(ids);
        if (result==ids.length){
            return new MessageBean("200","ok",null);
        }
        return new MessageBean("404","false",null);
    }
}
