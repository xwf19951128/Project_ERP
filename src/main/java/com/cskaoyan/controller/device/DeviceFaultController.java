package com.cskaoyan.controller.device;

import com.cskaoyan.bean.device.DeviceFault;
import com.cskaoyan.service.device.DeviceFaultService;
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
 * @Date Created in 15:22 2019/8/9
 */
@Controller
@RequestMapping("/deviceFault")
public class DeviceFaultController {

    @Autowired
    DeviceFaultService deviceFaultService;

    /**
     * 返回一个列表清单
     * @return
     */
    @RequestMapping("/list")
    @ResponseBody
    public JsonFindResult getList(){
        JsonFindResult<DeviceFault> result = new JsonFindResult<>();
        List<DeviceFault> deviceFaults= deviceFaultService.queryAllDeviceFault();
        result.setRows(deviceFaults);
        result.setTotal(deviceFaults.size());
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
     * 跳转到添加页面
     * @return
     */
    @RequestMapping("/add")
    public String addDeviceFaultPage(){
        return "/WEB-INF/jsp/deviceFault_add.jsp";
    }

    /**
     * 进行插入数据
     * @param deviceFault
     * @return
     */
    @RequestMapping("/insert")
    @ResponseBody
    public HashMap addDeviceFault(DeviceFault deviceFault){
        HashMap<String, Object> hashMap = new HashMap<>();
        //在service层进行去重判断
        int i=deviceFaultService.insertDeviceFault(deviceFault);
        if(i==1){
            hashMap.put("status",200);
        }else if(i==2){
            hashMap.put("msg","失败了，弟弟,里面有重复元素~");
        }else {
            hashMap.put("msg","失败了");
        }
        return hashMap;
    }

    /**
     * 模糊查询：根据id
     * @param searchValue
     * @return
     */
    @RequestMapping("/search_deviceFault_by_deviceFaultId")
    @ResponseBody
    public JsonFindResult searchDeviceFaultByDeviceFaultId(String searchValue){
        JsonFindResult result = new JsonFindResult();
        List<DeviceFault> deviceFaults= deviceFaultService.searchDeviceFaultByDeviceFaultId(searchValue);
        result.setTotal(deviceFaults.size());
        result.setRows(deviceFaults);
        return result;
    }

    /**
     * 模糊查询：根据name
     * @param searchValue
     * @return
     */
    @RequestMapping("/search_deviceFault_by_deviceName")
    @ResponseBody
    public JsonFindResult searchDeviceFaultByDeviceFaultName(String searchValue){
        JsonFindResult result = new JsonFindResult();
        List<DeviceFault> deviceFaults=deviceFaultService.searchDeviceFaultByDeviceFaultName(searchValue);
        result.setTotal(deviceFaults.size());
        result.setRows(deviceFaults);
        return result;
    }

    /**
     * 一个url映射，对应其他表的查询回显数据，返回一个list
     * @return
     */
    @RequestMapping("/get_data")
    @ResponseBody
    public List<DeviceFault> findAll(){
        List<DeviceFault> deviceFaults = deviceFaultService.queryAllDeviceFault();
        return deviceFaults;
    }
}
