package com.cskaoyan.controller.device;

import com.cskaoyan.bean.device.DeviceCheck;
import com.cskaoyan.bean.device.DeviceType;
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
        return "/WEB-INF/jsp/deviceCheck_add.jsp";
    }

    /**
     * 新增操作
     * @return
     */
    @RequestMapping("/insert")
    @ResponseBody
    public HashMap addDeviceCheck(DeviceCheck deviceCheck){
        HashMap<String, Object> hashMap = new HashMap();
        int i=deviceCheckService.insertDeviceCheck(deviceCheck);
        if(i==1){
            hashMap.put("status",200);
        }else{
            hashMap.put("msg","失败了，弟弟~");
        }
        return hashMap;
    }

    /**
     * 编辑判断操作
     */
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
        return "/WEB-INF/jsp/deviceCheck_edit.jsp";
    }

    @RequestMapping("/update")
    @ResponseBody
    public HashMap editDeviceCheck(DeviceCheck deviceCheck){
        HashMap<String, Object> hashMap = new HashMap<>();
        int i=deviceCheckService.updateDeviceCheck(deviceCheck);
        if(i==1){
            hashMap.put("status",200);
        }
        else{
            hashMap.put("msg","失败了，弟弟");
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
    public HashMap deleteDeviceCheck(String ids){
        HashMap<String, Object> hashMap = new HashMap<>();
        //注意这样写会错误，因为是string类型，相当于“1,2,3，”d string类型
        //所以需要根据，分割一下，变为string数组,分割后数组内没有","
        String[] deviceCheck = ids.split(",");
        int i=deviceCheckService.deleteDeviceCheck(deviceCheck);
        if(i>=1){
            hashMap.put("status",200);
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
