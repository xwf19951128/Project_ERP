package com.cskaoyan.controller.device;

import com.cskaoyan.bean.device.DeviceType;
import com.cskaoyan.service.device.DeviceTypeService;
import com.cskaoyan.util.JsonFindResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author: XiaoLei
 * @Date Created in 10:34 2019/8/9
 */
@Controller
@RequestMapping("/deviceType")
public class DeviceTypeController {

    @Autowired
    DeviceTypeService deviceTypeService;

    @RequestMapping("/list")
    @ResponseBody
    public JsonFindResult<DeviceType> getList(){
        JsonFindResult<DeviceType> deviceTypeJsonFindResult = new JsonFindResult<>();
        List<DeviceType> deviceTypes = deviceTypeService.queryAllDeviceType();
        deviceTypeJsonFindResult.setRows(deviceTypes);
        deviceTypeJsonFindResult.setTotal(deviceTypes.size());
        return deviceTypeJsonFindResult;
    }
}
