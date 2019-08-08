package com.cskaoyan.controller;

import com.cskaoyan.bean.Material;
import com.cskaoyan.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MaterialController {

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
    public List<Material> listMaterials(int page, int rows){
//        List<Material> materialList = materialService.listMaterials();
        List<Material> materialList = materialService.listPageMaterials(page, rows);
        return materialList;
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
