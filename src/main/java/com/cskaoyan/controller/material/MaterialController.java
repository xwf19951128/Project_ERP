package com.cskaoyan.controller.material;

import com.cskaoyan.bean.material.Material;
import com.cskaoyan.bean.material.MaterialPage;
import com.cskaoyan.service.material.MaterialService;
import org.apache.log4j.Logger;
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
public class MaterialController {

    private Logger logger = Logger.getLogger(this.getClass());

    @Autowired
    MaterialService materialService;


    public void addSysPermissionList(HttpSession session){
        List sysPermissionList = new ArrayList<String>();
        sysPermissionList.add("material:add");
        sysPermissionList.add("material:edit");
        sysPermissionList.add("material:delete");
        session.setAttribute("sysPermissionList", sysPermissionList);
    }

    @RequestMapping("/material/find")
    public String find(HttpSession session){
        addSysPermissionList(session);
        return "/WEB-INF/jsp/material_list.jsp";
    }

    @RequestMapping("/material/list")
    @ResponseBody
/*    public MaterialPage listMaterials(int page, int rows){
        MaterialPage<Material> materialPage = new MaterialPage<>();
        int materialCount = materialService.countMaterialCount();
        List<Material> materialList = materialService.listPageMaterials(page, rows);
        logger.info(materialList);
        materialPage.setTotal(materialCount);
        materialPage.setRows(materialList);
        return materialPage;
    }  */
    public Map<String, Object> listMaterials(int page, int rows){
        HashMap<String, Object> map = new HashMap<>();
        int materialCount = materialService.countMaterialCount();
        List<Material> materialList = materialService.listPageMaterials(page, rows);
//        logger.info(materialList);
        map.put("total", materialCount);
        map.put("rows", materialList);
        return map;
    }

    @RequestMapping("/material/add_judge")
    public String addMaterial(){
        return "/WEB-INF/jsp/material_add.jsp";
    }
    @RequestMapping("/material/insert")
    public String insertMaterial(){
//        int insertResult = materialService.
        return "redirect:WEB-INF/jsp/material_list.jsp";
    }
}
