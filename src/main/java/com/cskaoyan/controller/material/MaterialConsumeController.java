package com.cskaoyan.controller.material;

import com.cskaoyan.bean.material.MaterialConsume;
import com.cskaoyan.bean.material.MaterialReceive;
import com.cskaoyan.service.material.MaterialConsumeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/materialConsume")
public class MaterialConsumeController {

    @Autowired
    MaterialConsumeService materialConsumeService;

    public void addSysPermissionList(HttpSession session){
        List sysPermissionList = new ArrayList<String>();
        sysPermissionList.add("materialConsume:add");
        sysPermissionList.add("materialConsume:edit");
        sysPermissionList.add("materialConsume:delete");
        session.setAttribute("sysPermissionList", sysPermissionList);
    }
    /*查询页面*/
    @RequestMapping("/find")
    public String find(HttpSession session){
        addSysPermissionList(session);
        return "/WEB-INF/jsp/materialConsume_list.jsp";
    }
    /*查*/
    @RequestMapping("/list")
    @ResponseBody
    public Map<String, Object> listPageMaterialConsumes(int page, int rows){
        HashMap<String, Object> map = new HashMap<>();
//        int materialReceiveCount = materialConsumeService.countMaterialConsumeCount();
//        System.out.println("materialReceiveCount = " + materialReceiveCount);
        List<MaterialConsume> materialConsumeList = materialConsumeService.listPageMaterialConsumes(page, rows);
//        System.out.println("materialReceiveList = " + materialReceiveList);
//        logger.info(materialList);
        PageInfo<MaterialConsume> materialReceivePageInfo = new PageInfo<>(materialConsumeList);
        long total = materialReceivePageInfo.getTotal();
        map.put("total", total);
        map.put("rows", materialConsumeList);
        return map;
    }
    /*模糊查询*/
    @RequestMapping(value = {"/search_materialConsume_by_consumeId"})
    @ResponseBody
    public Map<String, Object> listPageSearchMaterialConsumesByConsumeId(int page, int rows, String searchValue){
        HashMap<String, Object> map = new HashMap<>();
        List<MaterialConsume> materialConsumeList = materialConsumeService.listPageSearchMaterialConsumesByConsumeId(page, rows, searchValue);
        PageInfo<MaterialConsume> materialReceivePageInfo = new PageInfo<>(materialConsumeList);
        long total = materialReceivePageInfo.getTotal();
        map.put("total", total);
        map.put("rows", materialConsumeList);
        return map;
    }
    @RequestMapping("/search_materialConsume_by_workId")
    @ResponseBody
    public Map<String, Object> listPageSearchMaterialConsumesByWorkId(int page, int rows, String searchValue){
        HashMap<String, Object> map = new HashMap<>();
        List<MaterialConsume> materialConsumeList = materialConsumeService.listPageSearchMaterialConsumesByWorkId(page, rows, searchValue);
        PageInfo<MaterialConsume> materialReceivePageInfo = new PageInfo<>(materialConsumeList);
        long total = materialReceivePageInfo.getTotal();
        map.put("total", total);
        map.put("rows", materialConsumeList);
        return map;
    }
    @RequestMapping("/search_materialConsume_by_materialId")
    @ResponseBody
    public Map<String, Object> listPageSearchMaterialConsumesByMaterialId(int page, int rows, String searchValue){
        HashMap<String, Object> map = new HashMap<>();
        List<MaterialConsume> materialConsumeList = materialConsumeService.listPageSearchMaterialConsumesByMaterialId(page, rows, searchValue);
        PageInfo<MaterialConsume> materialReceivePageInfo = new PageInfo<>(materialConsumeList);
        long total = materialReceivePageInfo.getTotal();
        map.put("total", total);
        map.put("rows", materialConsumeList);
        return map;
    }



}
