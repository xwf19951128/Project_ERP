package com.cskaoyan.controller.device;

import com.cskaoyan.bean.device.Device;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import sun.misc.Request;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @Author: XiaoLei
 * @Date Created in 20:59 2019/8/8
 */

@Controller
@RequestMapping("/device")
public class DeviceController {

    HashMap<String,String> result =new HashMap<>();

    public HashMap<String, String> getResult() {
        return result;
    }
    public void setResult(HashMap<String, String> result) {
        this.result = result;
    }

    //对应 侧边栏的设备台账 device/deviceList
    @RequestMapping("/deviceList")
    public String deviceList(HttpServletRequest request) throws Exception{
        ArrayList<String> devices = new ArrayList<>();
        devices.add("device:add");
        devices.add("device:edit");
        devices.add("device:delete");
        request.getSession().setAttribute("sysPermissionList",devices);
        return "/WEB-INF/jsp/deviceList.jsp";
    }

    //对应 侧边栏的设备种类
    @RequestMapping("/deviceType")
    public String deviceType(HttpServletRequest request) throws Exception{
        ArrayList<String> devices = new ArrayList<>();
        devices.add("deviceType:add");
        devices.add("deviceType:edit");
        devices.add("deviceType:delete");
        request.getSession().setAttribute("sysPermissionList",devices);
        return "/WEB-INF/jsp/deviceType.jsp";
    }

    //对应侧边栏的设备检查
    @RequestMapping("/deviceCheck")
    public String deviceCheck(HttpServletRequest request) throws Exception{
        ArrayList<String> devices = new ArrayList<>();
        devices.add("deviceCheck:add");
        devices.add("deviceCheck:edit");
        devices.add("deviceCheck:delete");
        request.getSession().setAttribute("sysPermissionList",devices);
        return "/WEB-INF/jsp/deviceCheck.jsp";
    }

    //对应侧边栏的设备故障
    @RequestMapping("/deviceFault")
    public String deviceFault(HttpServletRequest request) throws Exception{
        ArrayList<String> devices = new ArrayList<>();
        devices.add("deviceFault:add");
        devices.add("deviceFault:edit");
        devices.add("deviceFault:delete");
        request.getSession().setAttribute("sysPermissionList",devices);
        return "/WEB-INF/jsp/deviceFault.jsp";
    }

    //对应侧边栏的设备维修
    @RequestMapping("/deviceMaintain")
    public String deviceMaintain(HttpServletRequest request) throws Exception{
        ArrayList<String> devices = new ArrayList<>();
        devices.add("deviceMaintain:add");
        devices.add("deviceMaintain:edit");
        devices.add("deviceMaintain:delete");
        request.getSession().setAttribute("sysPermissionList",devices);
        return "/WEB-INF/jsp/deviceMaintain.jsp";
    }
}
