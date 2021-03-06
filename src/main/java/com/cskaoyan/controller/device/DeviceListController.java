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
import java.util.Map;

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

    /**
     *     查询所有的列表
     */
    @RequestMapping("/list")
    @ResponseBody
    public JsonFindResult getList(){
        JsonFindResult deviceJsonFindResult = new JsonFindResult();
        List<Device> devices= deviceListService.queryAllDevices();
        deviceJsonFindResult.setTotal(devices.size());
        deviceJsonFindResult.setRows(devices);
        return deviceJsonFindResult;
    }

    /**
     * 进行增加的判断，要求返回一个null集合
     */
    @RequestMapping("/add_judge")
    @ResponseBody
    public Map addShow(){
        return null;
    }

    /**
     * 如果需要增加，则跳转到增加页面
     * @return
     */
    @RequestMapping("/add")
    public String addDevicePage(){
        return "/WEB-INF/jsp/deviceList_add.jsp";
    }
    /**
     * 新增设备的方法
     */
    @RequestMapping("/insert")
    @ResponseBody
    public Map addDevice(Device device){
        //需要在service层进行判重操作
        HashMap<String, Object> HashMap = new HashMap<>();
        int i=deviceListService.insertDevice(device);
        if(i==1){
            HashMap.put("status",200);
        }else if(i==2){
            HashMap.put("msg","弟弟，有重复元素，不能添加~");
        }else{
            HashMap.put("msg","弟弟失败了~");
        }
        return HashMap;
    }

    /**
     * 进行编辑的操作
     */
    @RequestMapping("/edit_judge")
    @ResponseBody
    public Map editShow(){
        return null;
    }

    /**
     * 进行一个编辑操作，然后返回到编辑页面
     * @param
     * @return
     */
    @RequestMapping("/edit")
    public String editDevicePage(){
        return "/WEB-INF/jsp/deviceList_edit.jsp";
    }
    /**
     * 进行真正的编辑操作
     */
    @RequestMapping("/update")
    @ResponseBody
    public HashMap updateDevice(Device device){
        HashMap<String, Object> hashMap = new HashMap<>();
        int i=deviceListService.updateDevice(device);
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
    public HashMap deleteDeviceType(String ids){
        HashMap<String, Object> hashMap = new HashMap<>();
        //注意这样写会错误，因为是string类型，相当于“1,2,3，”d string类型
        //所以需要根据，分割一下，变为string数组,分割后数组内没有","
        String[] devices = ids.split(",");
        int i=deviceListService.deleteDevice(devices);
        if(i>=1){
            hashMap.put("status",200);
        }
        return hashMap;
    }


    /**
     * 模糊查询1：根据id
     */
    @RequestMapping("/search_device_by_deviceId")
    @ResponseBody
    public JsonFindResult searchDeviceByDeviceId(String searchValue){
        JsonFindResult result = new JsonFindResult();
        List<Device> devices=deviceListService.searchDeviceByDeviceId(searchValue);
        result.setRows(devices);
        result.setTotal(devices.size());
        return result;
    }
    /**
     * 模糊查询2：根据devicename
     */
    @RequestMapping("/search_device_by_deviceName")
    @ResponseBody
    public JsonFindResult searchDeviceByDeviceName(String searchValue){
        JsonFindResult result = new JsonFindResult();
        List<Device> devices=deviceListService.searchDeviceByDeviceName(searchValue);
        result.setRows(devices);
        result.setTotal(devices.size());
        return result;
    }
    /**
     * 模糊查询3：根据search_device_by_deviceTypeName
     */
    @RequestMapping("/search_device_by_deviceTypeName")
    @ResponseBody
    public JsonFindResult searchDeviceByDeviceTypeName(String searchValue){
        JsonFindResult result = new JsonFindResult();
        List<Device> devices=deviceListService.searchDeviceByDeviceTypeName(searchValue);
        result.setTotal(devices.size());
        result.setRows(devices);
        return result;
    }

    /**
     * 找到所有device的id和name
     * @return
     */
    @ResponseBody
    @RequestMapping("/get_data")
    public List<Device> findAll(){
        return deviceListService.queryAllDevices();
    }
}
