package com.cskaoyan.controller.device;

import com.cskaoyan.bean.device.DeviceType;
import com.cskaoyan.service.device.DeviceTypeService;
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
 * @Date Created in 10:34 2019/8/9
 */
@Controller
@RequestMapping("/deviceType")
public class DeviceTypeController {

    @Autowired
    DeviceTypeService deviceTypeService;

    //查询列表的所有device
    @RequestMapping("/list")
    @ResponseBody
    public JsonFindResult<DeviceType> getList(){
        JsonFindResult<DeviceType> deviceTypeJsonFindResult = new JsonFindResult<>();
        List<DeviceType> deviceTypes = deviceTypeService.queryAllDeviceType();
//        PageInfo<DeviceType> deviceTypePageInfo = new PageInfo<>(deviceTypes);
        deviceTypeJsonFindResult.setRows(deviceTypes);
        deviceTypeJsonFindResult.setTotal(deviceTypes.size());
       // deviceTypeJsonFindResult.setTotal((int) deviceTypePageInfo.getTotal());
        return deviceTypeJsonFindResult;
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
     * 插入设备种类的方法
     * 新增相同的数据需要进行判断，先去服务器里找，如果找到了
     * @param deviceType
     * @return
     */
    @RequestMapping("/insert")
    @ResponseBody
    public HashMap addDeviceType(DeviceType deviceType){
        HashMap<String, Object> hashMap = new HashMap<>();
        //在service层进行去重判断
        int i=deviceTypeService.insertDeviceType(deviceType);
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
        String[] deviceTypes = ids.split(",");
        int i=deviceTypeService.deleteDeviceType(deviceTypes);
        if(i>=1){
            hashMap.put("status",200);
        }
        return hashMap;
    }

    /**
     * 进行编辑判断，需要返回一个null
     * @return
     */
   @RequestMapping("/edit_judge")
   @ResponseBody
   public Map editShowPage(){
        return null;
   }

    /**
     * 进行编辑操作,从deviceType.jsp的windows页面跳过来的,然后在跳到编辑页面
     */
    @RequestMapping("/edit")
    public String editShow(){
        return "/WEB-INF/jsp/deviceType_edit.jsp";
    }

    /**
     * 进行一个update的操作，
     */
    @RequestMapping("/update")
    @ResponseBody
    public HashMap updateDeviceType(DeviceType deviceType){
        HashMap<String, Object> hashMap = new HashMap<>();
        int i=deviceTypeService.updateDeviceType(deviceType);
        if(i==1){
            hashMap.put("status",200);
        }
        else{
            hashMap.put("msg","失败了吗，弟弟");
        }
        return hashMap;
    }

    /**
     * 根据id进行模糊查询
     * @param searchValue
     * @return
     */
    @RequestMapping("/search_deviceType_by_deviceTypeId")
    @ResponseBody
    public JsonFindResult searchDeviceTypeByDeviceTypeId(String searchValue){
        JsonFindResult result = new JsonFindResult();
        List<DeviceType> deviceTypes= deviceTypeService.queryDeviceTypeByDeviceTypeId(searchValue);
        result.setRows(deviceTypes);
        result.setTotal(deviceTypes.size());
        return result;
    }

    @RequestMapping("/search_deviceType_by_deviceTypeName")
    @ResponseBody
    public JsonFindResult searchDeviceTypeByDeviceTypeName(String searchValue){
        JsonFindResult result = new JsonFindResult();
        List<DeviceType> deviceTypes=deviceTypeService.searchDeviceTypeByDeviceTypeName(searchValue);
        result.setRows(deviceTypes);
        result.setTotal(deviceTypes.size());
        return result;
    }

    /**
     *  在增加device里面有个显示所有种类的下拉框，因此，在此处查询所有的下拉单
     *   注意，get_data的返回值也是json数据
     *   只查找deviceType的id和name
     */
    @RequestMapping("/get_data")
    @ResponseBody
    public List<DeviceType> findAll(){
        List<DeviceType> deviceTypes = deviceTypeService.queryAllDeviceType();
        return deviceTypes;
    }
}
