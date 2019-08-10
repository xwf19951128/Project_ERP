package com.cskaoyan.controller.device;

import com.cskaoyan.bean.device.DeviceMaintain;
import com.cskaoyan.service.device.DeviceMaintainService;
import com.cskaoyan.util.JsonFindResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

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
