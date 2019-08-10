package com.cskaoyan.controller.device;

import com.cskaoyan.bean.device.DeviceCheck;
import com.cskaoyan.service.device.DeviceCheckService;
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
 * @Date Created in 11:14 2019/8/9
 */
@Controller
@RequestMapping("/deviceCheck")
public class DeviceCheckController {

    @Autowired
    DeviceCheckService deviceCheckService;

    @RequestMapping("/list")
    @ResponseBody
    public JsonFindResult<DeviceCheck> getList(){
        JsonFindResult<DeviceCheck> deviceCheckJsonFindResult = new JsonFindResult<>();
        List<DeviceCheck> deviceChecks= deviceCheckService.queryAllDeviceCheck();
        deviceCheckJsonFindResult.setTotal(deviceChecks.size());
        deviceCheckJsonFindResult.setRows(deviceChecks);
        return deviceCheckJsonFindResult;

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
        return "/WEB-INF/jsp/deviceType_add.jsp";
    }

    /**
     * 新增操作
     * @return
     */
    @RequestMapping("/insert")
    @ResponseBody
    public HashMap addDeviceCheck(){
        HashMap<String, Object> hashMap = new HashMap<>();
        int i=deviceCheckService.insertDeviceCheck();
        if(i==1){
            hashMap.put("status",200);
        }else{
            hashMap.put("msg","失败了，弟弟~");
        }
        return hashMap;
    }

    /**
     * 模糊查询1
     * @param searchValue
     * @return
     */
    @RequestMapping("/search_deviceCheck_by_deviceCheckId")
    @ResponseBody
    public JsonFindResult searchDeviceCheckByDeviceCheckId(String searchValue){
        JsonFindResult result = new JsonFindResult();
        List<DeviceCheck> deviceChecks= deviceCheckService.searchDeviceCheckByDeviceCheckId(searchValue);
        result.setRows(deviceChecks);
        result.setTotal(deviceChecks.size());
        return result;
    }
    @RequestMapping("/search_deviceCheck_by_deviceName")
    @ResponseBody
    public JsonFindResult searchDeviceCheckByDeviceName(String searchValue){
        JsonFindResult result = new JsonFindResult();
        List<DeviceCheck> deviceChecks=deviceCheckService.searchDeviceCheckByDeviceName(searchValue);
        result.setRows(deviceChecks);
        result.setTotal(deviceChecks.size());
        return result;
    }

}
