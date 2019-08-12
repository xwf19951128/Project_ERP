package com.cskaoyan.controller.schedule;


import com.cskaoyan.bean.schedule.*;

import com.cskaoyan.service.schedule.ScheduleService;
import jdk.internal.dynalink.linker.LinkerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class TaskController {
    @Autowired
    ScheduleService scheduleService;

    @RequestMapping("/manufacture/get_data")
    @ResponseBody
    public List<Manufacture> getManufactures(){
        List<Manufacture> manufactures = scheduleService.queryManufacture();
        return manufactures;
    }

    @RequestMapping("/manufacture/get/{id}")
    @ResponseBody
    public Manufacture getOneManufacture(@PathVariable("id") String id){
        return scheduleService.queryManufactureById(id);
    }

    @RequestMapping("/work/get_data")
    @ResponseBody
    public List<Work> getWorks(){
        return scheduleService.queryWorkList();
    }

    @RequestMapping("/work/get/{id}")
    @ResponseBody
    public Work getOneWork(@PathVariable("id") String id){
        return scheduleService.queryWorkById(id);
    }
    /*====================增加======================================*/
    @RequestMapping("/task/add_judge")
    @ResponseBody
    public String add_judge(){
        return null;
    }

    @RequestMapping("/task/add")
    public String add(){
        return "/WEB-INF/jsp/task_add.jsp";
    }

    //插入数据库
    @RequestMapping("/task/insert")
    @ResponseBody
    public MessageBean insert(Task task){
        int i = scheduleService.insertTask(task);
        if (i==1)
        { return new MessageBean("200","ok",null);
      }
        return new MessageBean("404","false",null);
    }
/*===========================编辑=============================================*/
    @RequestMapping("/task/edit_judge")
    @ResponseBody
    public String edit_judge(){
        return null;
    }

    @RequestMapping("/task/edit")
    public String edit(){
        return "/WEB-INF/jsp/task_edit.jsp";
    }

    @RequestMapping("/task/update_all")
    @ResponseBody
    public MessageBean update(Task task){
        int i = scheduleService.updateInfo(task);
        if (i==1){
            return new MessageBean("200","ok",null);
        }
        return new MessageBean("500","false",null);
    }

 /*======================删除=============================*/
    @RequestMapping("/task/delete_judge")
    @ResponseBody
    public String delete_judge(){
        return null;
    }

    @RequestMapping("/task/delete_batch")
    @ResponseBody
    public MessageBean delete(String[] ids){
        int result = scheduleService.deleteTaskByIds(ids);
        if (result==ids.length){
            return new MessageBean("200","ok",null);
        }
        return new MessageBean("404","false",null);
    }

    /*模糊查询：根据生产派工编号查询派工管理*/
    @RequestMapping("/task/search_task_by_taskId")
    @ResponseBody
    public SchedulList<Task> searchTaskByTaskId(String searchValue, int page,int rows){
        return scheduleService.searchTaskByTaskId(searchValue,page,rows);
    }
    /*模糊查询：根据作业编号查询派工管理*/
    @RequestMapping("/task/search_task_by_taskWorkId")
    @ResponseBody
    public  SchedulList<Task> searchTaskByWorkId(String searchValue, int page,int rows){
        return scheduleService.searchTaskByWorkId(searchValue,page,rows);
    }
    /*模糊查询：根据生产批号查询派工管理*/
    @RequestMapping("/task/search_task_by_taskManufactureSn")
    @ResponseBody
    public SchedulList<Task> searchTaskByManufactureSn(String searchValue, int page, int rows){
        return scheduleService.searchTaskByManufactureSn(searchValue,page,rows);
    }

}
