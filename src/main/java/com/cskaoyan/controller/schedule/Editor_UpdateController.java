package com.cskaoyan.controller.schedule;

import com.cskaoyan.bean.schedule.*;
import com.cskaoyan.service.schedule.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 执行更新操作的Controller
 */
@Controller
public class Editor_UpdateController {
    @Autowired
    ScheduleService service;
    /*
    以下部分是整体修改的操作
     */
    @RequestMapping("/order/update_all")
    @ResponseBody
    public MessageBean editorAll(Order order){
        if(service.updateOrder(order)==1){
            return new MessageBean("200","ok",null);
        }
        return new MessageBean("404","修改失败",null );
    }
    @RequestMapping("/custom/update_all")
    @ResponseBody
    public MessageBean editor(Custom custom){
        System.out.println(custom);
        if(service.updateInfo(custom)==1){
            return new MessageBean("200","ok",null);
        }
        return new MessageBean("404","修改失败",null );
    }
    @RequestMapping("/product/update_all")
    @ResponseBody
    public MessageBean editor(Product product){
        if(service.updateInfo(product)==1){
            return new MessageBean("200","ok",null);
        }
        return new MessageBean("404","修改失败",null );
    }
    @RequestMapping("/work/update_all")
    @ResponseBody
    public MessageBean editor(Work product){
        if(service.updateInfo(product)==1){
            return new MessageBean("200","ok",null);
        }
        return new MessageBean("404","修改失败",null );
    }
    @RequestMapping("/manufacture/update_all")
    @ResponseBody
    public MessageBean editor(Manufacture product){
        if(service.updateInfo(product)==1){
            return new MessageBean("200","ok",null);
        }
        return new MessageBean("404","修改失败",null );
    }
    @RequestMapping("/task/update_all")
    @ResponseBody
    public MessageBean update(Task task){
        int i = service.updateInfo(task);
        if (i==1){
            return new MessageBean("200","ok",null);
        }
        return new MessageBean("500","false",null);
    }
    /*
    以下部分是仅更新NOTE的操作部分
     */
    @RequestMapping("/order/update_note")
    @ResponseBody
    public MessageBean editor(Order order){
        if(service.updateInfo(order)==1){
            return new MessageBean("200","ok",null);
        }
        return new MessageBean("404","修改失败",null );
    }
    @RequestMapping("/custom/update_note")
    @ResponseBody
    public MessageBean editorNote(Custom custom){
        if(service.updateInfo(custom)==1){
            return new MessageBean("200","ok",null);
        }
        return new MessageBean("404","修改失败",null );
    }
    @RequestMapping("/product/update_note")
    @ResponseBody
    public MessageBean editorNote(Product product){
        if(service.updateInfo(product)==1){
            return new MessageBean("200","ok",null);
        }
        return new MessageBean("404","修改失败",null );
    }

}
