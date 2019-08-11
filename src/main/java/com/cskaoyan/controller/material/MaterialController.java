package com.cskaoyan.controller.material;

import com.cskaoyan.bean.material.Material;
import com.cskaoyan.service.material.MaterialService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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


    private void addSysPermissionList(HttpSession session){
        List sysPermissionList = new ArrayList<String>();
        sysPermissionList.add("material:add");
        sysPermissionList.add("material:edit");
        sysPermissionList.add("material:delete");
        session.setAttribute("sysPermissionList", sysPermissionList);
    }

    /*查*/
    @RequestMapping("/material/find")
    public String find(HttpSession session){
        addSysPermissionList(session);
        return "/WEB-INF/jsp/material_list.jsp";
    }
    @RequestMapping("/material/list")
    @ResponseBody
    public Map<String, Object> listPageMaterials(int page, int rows){
        HashMap<String, Object> map = new HashMap<>();
        int materialCount = materialService.countMaterialCount();
        List<Material> materialList = materialService.listPageMaterials(page, rows);
//        logger.info(materialList);
        map.put("total", materialCount);
        map.put("rows", materialList);
        return map;
    }
    /*从materialReceive查询material*/
    @RequestMapping("material/get/{materialId}")
    @ResponseBody
    public Material getMaterialById(@PathVariable("materialId") String materialId){
        Material material = materialService.getMaterialById(materialId);
        return material;
    }
    /*materialReceive查询List<Material>*/
    @RequestMapping("material/get_data")
    @ResponseBody
    public List<Material> getData(){
        return materialService.listMaterials();
    }

    /*改*/
    @RequestMapping("/material/edit_judge")
    @ResponseBody
    public Map<String, Object> editJudge(){
        HashMap<String, Object> map = new HashMap<>();
        return map;
    }
    @RequestMapping("/material/edit")
    public String edit(){
        return "/WEB-INF/jsp/material_edit.jsp";
    }
    @RequestMapping("/material/update_note")
    @ResponseBody
    public Map<String, Object> updateNote(Material material){
        int updateResult = materialService.updateNoteById(material);
        HashMap<String, Object> map = new HashMap<>();
        if(updateResult == 1) {
            map.put("status", 200);
            map.put("msg", "OK");
            map.put("data", null);
        }else {
            map.put("msg", "服务器开小差了，修改描述失败");
        }
        return map;
    }
    @RequestMapping("material/update_all")
    @ResponseBody
    public Map<String, Object> updateAll(Material material){
        int updateResult = materialService.updateAllById(material);
        HashMap<String, Object> map = new HashMap<>();
        if(updateResult == 1) {
            map.put("status", 200);
            map.put("msg", "OK");
            map.put("data", null);
        }else {
            map.put("msg", "服务器开小差了，修改物料信息失败");
        }
        return map;
    }



    /*增*/
    @RequestMapping("/material/add_judge")
    @ResponseBody
    public Map<String, Object> addJudge(){
        HashMap<String, Object> map = new HashMap<>();
        return map;
    }
    @RequestMapping("/material/add")
    public String add(){
        return "/WEB-INF/jsp/material_add.jsp";
    }
    @RequestMapping("/material/insert")
    @ResponseBody
    public Map<String, Object> insert(Material material){
        int insertResult = materialService.insertMaterial(material);
        HashMap<String, Object> map = new HashMap<>();
        if(insertResult == 1) {
            map.put("status", 200);
            map.put("msg", "OK");
            map.put("data", null);
        }else {
            map.put("msg", "服务器开小差了，修改描述失败");
        }
        return map;
    }



    /*删*/
    @RequestMapping("/material/delete_judge")
    @ResponseBody
    public Map<String, Object> deleteJudge(){
        HashMap<String, Object> map = new HashMap<>();
        return map;
    }
    @RequestMapping("/material/delete_batch")
    @ResponseBody
    public Map<String, Object> deleteBatch(String[] ids){
        int deleteResult = materialService.deleteMaterialsByIds(ids);
        logger.info(deleteResult);
        HashMap<String, Object> map = new HashMap<>();
        if(deleteResult == 1) {
            map.put("status", 200);
            map.put("msg", "OK");
            map.put("data", null);
        }else {
            map.put("msg", "服务器开小差了，删除物料失败");
        }
        return map;
    }

    /*模糊查询*/
    @RequestMapping("/material/search_material_by_materialId")
    @ResponseBody
    public Map<String, Object> listPageSearchMaterialsById(int page, int rows, String searchValue){
        HashMap<String, Object> map = new HashMap<>();
        int materialCount = materialService.countSearchMaterialCountById(searchValue);
        System.out.println("materialCount = " + materialCount);
        List<Material> materialList = materialService.listPageSearchMaterialsById(page, rows, searchValue);
        map.put("total", materialCount);
        map.put("rows", materialList);
        return map;
    }
    @RequestMapping("/material/search_material_by_materialType")
    @ResponseBody
    public Map<String, Object> listPageSearchMaterialsByType(int page, int rows, String searchValue){
        HashMap<String, Object> map = new HashMap<>();
        int materialCount = materialService.countSearchMaterialCountByType(searchValue);
        List<Material> materialList = materialService.listPageSearchMaterialsByType(page, rows, searchValue);
        map.put("total", materialCount);
        map.put("rows", materialList);
        return map;
    }



}
