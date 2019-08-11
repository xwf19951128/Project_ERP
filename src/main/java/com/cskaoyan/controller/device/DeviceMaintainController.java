package com.cskaoyan.controller.device;

import com.cskaoyan.bean.device.DeviceFault;
import com.cskaoyan.bean.device.DeviceMaintain;
import com.cskaoyan.service.device.DeviceMaintainService;
import com.cskaoyan.util.JsonFindResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: XiaoLei
 * @Date Created in 16:02 2019/8/9
 */
@Controller
@RequestMapping("/deviceMaintain")
public class DeviceMaintainController {

    @Autowired
    DeviceMaintainService deviceMaintainService;

    @RequestMapping("/list")
    @ResponseBody
    public JsonFindResult getList(){
        JsonFindResult result = new JsonFindResult<>();
        List<DeviceMaintain> deviceMaintains=deviceMaintainService.queryAllDeviceMaintain();
        result.setTotal(deviceMaintains.size());
        result.setRows(deviceMaintains);
        return result;
    }

    /**
     * ajxs的一部分，需要返回一个空的集合，在回到addType页面
     * @return
     */
    @RequestMapping("/add_judge")
    @ResponseBody
    public Map addShow(){
        return null;
    }

    /**
     * 跳转到添加页面,注意不需要加responseBody，跳转页面而已
     * @return
     */
    @RequestMapping("/add")
    public String addDevicePage(){
        return "/WEB-INF/jsp/deviceMaintain_add.jsp";
    }

    /**
     * 插入设备种类的方法
     * 新增相同的数据需要进行判断，先去服务器里找，如果找到了
     * @param
     * @return
     */
    @RequestMapping("/insert")
    @ResponseBody
    public HashMap addDeviceMaintain(DeviceMaintain deviceMaintain){
        HashMap<String, Object> hashMap = new HashMap<>();
        //在service层进行去重判断
        int i=deviceMaintainService.insertDeviceMaintain(deviceMaintain);
        if(i==1){
            hashMap.put("status",200);
        }else if(i==2){
            hashMap.put("msg","失败了，弟弟,里面有重复元素~");
        }else {
            hashMap.put("msg","失败了");
        }
        return hashMap;
    }



    @RequestMapping("/edit_judge")
    @ResponseBody
    public Map editShow(){
        return null;
    }

    /**
     * 跳转到编辑页面
     * @return
     */
    @RequestMapping("/edit")
    public String editShowPage(){
        return "/WEB-INF/jsp/deviceMaintain_edit.jsp";
    }

    @RequestMapping("/update")
    @ResponseBody
    public HashMap updateDeviceMaintain(DeviceMaintain deviceMaintain){
        HashMap<String, Object> hashMap = new HashMap<>();
        int i=deviceMaintainService.updateDeviceMaintain(deviceMaintain);
        if(i==1){
            hashMap.put("status",200);
        }
        else{
            hashMap.put("msg","失败了吗，弟弟");
        }
        return hashMap;
    }


    /**
     * 进行判断是否删除的请求
     * @return
     */
    @RequestMapping("/delete_judge")
    @ResponseBody
    public Map deleteShow(){
        return null;
    }

    /**
     * 删除分支，返回的是一个键值对，这个并不需要跳到其他页面
     * @return
     */
    @RequestMapping("/delete_batch")
    @ResponseBody
    public HashMap deleteDeviceMaintain(String ids){
        HashMap<String, Object> hashMap = new HashMap<>();
        //注意这样写会错误，因为是string类型，相当于“1,2,3，”d string类型
        //所以需要根据，分割一下，变为string数组,分割后数组内没有","
        String[] deviceMaintains = ids.split(",");
        int i=deviceMaintainService.deleteDeviceMaintain(deviceMaintains);
        if(i>=1){
            hashMap.put("status",200);
        }
        return hashMap;
    }

    /**
     * 模糊查询1：search_deviceMaintain_by_deviceMaintainId
     */
    @RequestMapping("/search_deviceMaintain_by_deviceMaintainId")
    @ResponseBody
    public JsonFindResult searchDeviceMaintainByDeviceMaintainId(String searchValue){
        JsonFindResult result = new JsonFindResult();
        List<DeviceMaintain> deviceMaintains= deviceMaintainService.searchDeviceMaintainByDeviceMaintainId(searchValue);
        result.setTotal(deviceMaintains.size());
        result.setRows(deviceMaintains);
        return result;
    }

    @RequestMapping("/search_deviceMaintain_by_deviceFaultId")
    @ResponseBody
    public JsonFindResult searchDeviceMaintainByDeviceFaultId(String searchValue){
        JsonFindResult result = new JsonFindResult();
        List<DeviceMaintain> deviceMaintains=deviceMaintainService.searchDeviceMaintainByDeviceFaultId(searchValue);
        result.setTotal(deviceMaintains.size());
        result.setRows(deviceMaintains);
        return result;
    }

}
