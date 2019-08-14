package com.cskaoyan.controller.material;

import com.cskaoyan.bean.material.MaterialConsume;
import com.cskaoyan.service.material.MaterialConsumeService;
import com.github.pagehelper.PageInfo;
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

    /*增*/
    @RequestMapping("/add_judge")
    @ResponseBody
    public Map<String, Object> addJudge(){
        HashMap<String, Object> map = new HashMap<>();
        return map;
    }
    @RequestMapping("/add")
    public String add(){
        return "/WEB-INF/jsp/materialConsume_add.jsp";
    }
    @RequestMapping("/insert")
    @ResponseBody
    public Map<String, Object> insert(@Valid MaterialConsume materialConsume, BindingResult bindingResult) { // 实体内也保存了MaterialId字段
        HashMap<String, Object> map = new HashMap<>();
        if (bindingResult.hasErrors()){
            FieldError fieldError = bindingResult.getFieldError();
            if (fieldError != null) {
                String defaultMessage = fieldError.getDefaultMessage();
                map.put("msg", defaultMessage);
                return map;
            }
        }
        int insertResult = materialConsumeService.insertMaterialConsume(materialConsume);
        if(insertResult == 1) {
            map.put("status", 200);
            map.put("msg", "OK");
            map.put("data", null);
        }else {
            map.put("msg", "服务器开小差了，新增物料消耗失败");
        }
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
        return "/WEB-INF/jsp/materialConsume_edit.jsp";
    }
    @RequestMapping("/update_note")
    @ResponseBody
    public Map<String, Object> updateNote(MaterialConsume materialConsume){
        int updateResult = materialConsumeService.updateNoteById(materialConsume);
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
    public Map<String, Object> updateAll(MaterialConsume materialConsume){
        int updateResult = materialConsumeService.updateAllById(materialConsume);
        HashMap<String, Object> map = new HashMap<>();
        if(updateResult == 1) {
            map.put("status", 200);
            map.put("msg", "OK");
            map.put("data", null);
        }else {
            map.put("msg", "服务器开小差了，修改物料消耗信息失败");
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
        int deleteResult = materialConsumeService.deleteMaterialConsumesByIds(ids);
        HashMap<String, Object> map = new HashMap<>();
        if(deleteResult == 1) {
            map.put("status", 200);
            map.put("msg", "OK");
            map.put("data", null);
        }else {
            map.put("msg", "服务器开小差了，删除物料消耗失败");
        }
        return map;
    }



}
