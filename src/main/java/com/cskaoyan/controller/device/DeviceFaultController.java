package com.cskaoyan.controller.device;

import com.cskaoyan.bean.device.DeviceFault;
import com.cskaoyan.service.device.DeviceFaultService;
import com.cskaoyan.util.JsonFindResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author: XiaoLei
 * @Date Created in 15:22 2019/8/9
 */
@Controller
@RequestMapping("/deviceFault")
public class DeviceFaultController {

    @Autowired
    DeviceFaultService deviceFaultService;

    @RequestMapping("/list")
    @ResponseBody
    public JsonFindResult getList(){
        JsonFindResult<DeviceFault> result = new JsonFindResult<>();
        List<DeviceFault> deviceFaults= deviceFaultService.queryAllDeviceFault();
        result.setRows(deviceFaults);
        result.setTotal(deviceFaults.size());
        return result;
    }
}
