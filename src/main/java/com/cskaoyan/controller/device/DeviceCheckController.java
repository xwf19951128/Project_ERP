package com.cskaoyan.controller.device;

import com.cskaoyan.bean.device.DeviceCheck;
import com.cskaoyan.service.device.DeviceCheckService;
import com.cskaoyan.util.JsonFindResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

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
}
