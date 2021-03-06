package com.cskaoyan.controller.material;

import com.cskaoyan.bean.material.Material;
import com.cskaoyan.bean.material.MaterialReceive;
import com.cskaoyan.service.material.MaterialReceiveService;
import com.cskaoyan.service.material.MaterialService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/materialReceive")
public class MaterialReceiveController {

    private Logger logger = Logger.getLogger(this.getClass());

    @Autowired
    MaterialReceiveService materialReceiveService;

    @Autowired
    MaterialService materialService;


    public void addSysPermissionList(HttpSession session){
        List sysPermissionList = new ArrayList<String>();
        sysPermissionList.add("materialReceive:add");
        sysPermissionList.add("materialReceive:edit");
        sysPermissionList.add("materialReceive:delete");
        session.setAttribute("sysPermissionList", sysPermissionList);
    }



    /*增*/
    @RequestMapping("/add_judge")
    @ResponseBody
    public Map<String, Object> addJudge(){
        HashMap<String, Object> map = new HashMap<>();
        return map;
    }
    @RequestMapping("/add")
    public String add(){
        return "/WEB-INF/jsp/materialReceive_add.jsp";
    }
    @RequestMapping("/insert")
    @ResponseBody
    public Map<String, Object> insert(@Valid MaterialReceive materialReceive, Material material, BindingResult bindingResult) {
        HashMap<String, Object> map = new HashMap<>();
        if (bindingResult.hasErrors()){
            FieldError fieldError = bindingResult.getFieldError();
            if (fieldError != null) {
                String defaultMessage = fieldError.getDefaultMessage();
                map.put("msg", defaultMessage);
                return map;
            }
        }
        int insertResult = materialReceiveService.insertMaterialReceive(materialReceive, material);
        if(insertResult == 1) {
            map.put("status", 200);
            map.put("msg", "OK");
            map.put("data", null);
        }else {
            map.put("msg", "服务器开小差了，新增物料收入失败");
        }
        return map;
    }


    /*查*/
    @RequestMapping("/find")
    public String find(HttpSession session){
        addSysPermissionList(session);
        return "/WEB-INF/jsp/materialReceive_list.jsp";
    }
    @RequestMapping("/list")
    @ResponseBody
    public Map<String, Object> listPageMaterialReceives(int page, int rows){
        HashMap<String, Object> map = new HashMap<>();
        int materialReceiveCount = materialReceiveService.countMaterialReceiveCount();
//        System.out.println("materialReceiveCount = " + materialReceiveCount);
        List<MaterialReceive> materialReceiveList = materialReceiveService.listPageMaterialReceives(page, rows);
//        System.out.println("materialReceiveList = " + materialReceiveList);
//        logger.info(materialList);
        map.put("total", materialReceiveCount);
        map.put("rows", materialReceiveList);
        return map;
    }
    /*模糊查询*/
    @RequestMapping("/search_materialReceive_by_receiveId")
    @ResponseBody
    public Map<String, Object> listPageSearchMaterialReceivesById(int page, int rows, String searchValue){
        HashMap<String, Object> map = new HashMap<>();
        int materialReceiveCount = materialReceiveService.countSearchMaterialReceiveCountByReceiveId(searchValue);
        List<MaterialReceive> materialReceiveList = materialReceiveService.listPageSearchMaterialReceivesByReceiveId(page, rows, searchValue);
        map.put("total", materialReceiveCount);
        map.put("rows", materialReceiveList);
        return map;
    }
    @RequestMapping("/search_materialReceive_by_materialId")
    @ResponseBody
    public Map<String, Object> listPageSearchMaterialsByMaterialId(int page, int rows, String searchValue){
        HashMap<String, Object> map = new HashMap<>();
        int materialReceiveCount = materialReceiveService.countSearchMaterialReceiveCountByMaterialId(searchValue);
        List<MaterialReceive> materialReceiveList = materialReceiveService.listPageSearchMaterialReceivesByMaterialId(page, rows, searchValue);
        map.put("total", materialReceiveCount);
        map.put("rows", materialReceiveList);
        return map;
    }



    /*改*/
    @RequestMapping("/edit_judge")
    @ResponseBody
    public Map<String, Object> editJudge(){
        HashMap<String, Object> map = new HashMap<>();
        return map;
    }
    @RequestMapping("/edit")
    public String edit(){
        return "/WEB-INF/jsp/materialReceive_edit.jsp";
    }
    @RequestMapping("/update_note")
    @ResponseBody
    public Map<String, Object> updateNote(MaterialReceive materialReceive){
        int updateResult = materialReceiveService.updateNoteById(materialReceive);
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
    @RequestMapping("/update_all")
    @ResponseBody
    public Map<String, Object> updateAll(MaterialReceive materialReceive, Material material){
        int updateResult = materialReceiveService.updateAllById(materialReceive, material);
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



    /*删*/
    @RequestMapping("/delete_judge")
    @ResponseBody
    public Map<String, Object> deleteJudge(){
        HashMap<String, Object> map = new HashMap<>();
        return map;
    }
    @RequestMapping("/delete_batch")
    @ResponseBody
    public Map<String, Object> deleteBatch(String[] ids){
        int deleteResult = materialReceiveService.deleteMaterialReceivesByIds(ids);
        HashMap<String, Object> map = new HashMap<>();
        if(deleteResult == 1) {
            map.put("status", 200);
            map.put("msg", "OK");
            map.put("data", null);
        }else {
            map.put("msg", "服务器开小差了，删除物料收入失败");
        }
        return map;
    }



}
