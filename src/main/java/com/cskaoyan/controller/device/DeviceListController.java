package com.cskaoyan.controller.device;

import com.cskaoyan.bean.device.Device;
import com.cskaoyan.service.device.DeviceListService;
import com.cskaoyan.util.JsonFindResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

/**
 * @Author: XiaoLei
 * @Date Created in 20:35 2019/8/8
 */
@Controller
@RequestMapping("/deviceList")
public class DeviceListController {

    @Autowired
    DeviceListService deviceListService;

    @Autowired
    DeviceController controller;

    HashMap<String,String> result =new HashMap<>();
    public HashMap<String, String> getResult() {
        return result;
    }
    public void setResult(HashMap<String, String> result) {
        this.result = result;
    }

    @RequestMapping("/list")
    @ResponseBody
    public JsonFindResult getList(){
        JsonFindResult<Device> deviceJsonFindResult = new JsonFindResult<>();
        List<Device> devices= deviceListService.queryAllDevices();
        deviceJsonFindResult.setTotal(devices.size());
        deviceJsonFindResult.setRows(devices);
        return deviceJsonFindResult;
    }


}
