package com.cskaoyan.controller.technology;

import com.cskaoyan.bean.technology.Process;
import com.cskaoyan.bean.technology.QueryResult;
import com.cskaoyan.bean.technology.TechnologyPlan;
import com.cskaoyan.bean.technology.TechnologyRequirement;
import com.cskaoyan.service.technology.TechnologyRequirementService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/technologyRequirement")
public class TechnologyRequirementController {
    @Autowired
    TechnologyRequirementService technologyRequirementService;

    @RequestMapping("/find")
    public String find(HttpServletRequest request){
        //还需要添加一个用于权限管理的集合
        ArrayList<String> sysPermissionList = new ArrayList<>();
        sysPermissionList.add("technologyRequirement:add");
        sysPermissionList.add("technologyRequirement:edit");
        sysPermissionList.add("technologyRequirement:delete");
        request.getSession().setAttribute("sysPermissionList",sysPermissionList);
        return "/WEB-INF/jsp/technologyRequirement_list.jsp";
    }

    @RequestMapping("/list")
    @ResponseBody
    public QueryResult<TechnologyRequirement> list(){
        PageHelper.startPage(1,10);
        QueryResult<TechnologyRequirement> queryResult = new QueryResult<>();
        List<TechnologyRequirement> technologyRequirements = technologyRequirementService.queryAllTechnologyRequirements();
        long total = new PageInfo<>(technologyRequirements).getTotal();
        queryResult.setRows(technologyRequirements);
        queryResult.setTotal((int)total);
        return queryResult;
    }

    //点击add按钮时需要发送过来ajax请求验证
    @RequestMapping("/add_judge")
    @ResponseBody
    public Map add_judge(){
        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
        return objectObjectHashMap;
    }

    //window组件会发送一个请求，跳转到technologyRequirement的add.jsp页面
    @RequestMapping("/add")
    public String add(){
        return "/WEB-INF/jsp/technologyRequirement_add.jsp";
    }

    //输入要增加的工序信息后，会把信息发送到insert方法中
    //注意，表单传过来的并不是Json格式的数据，这一点算是个坑
    //但是返回值必须是jason！！！！！
    @RequestMapping("/insert")
    @ResponseBody
    public Map insert(TechnologyRequirement technologyRequirement){
        HashMap<String, Object> result = new HashMap<>();
        int i = technologyRequirementService.insertTechnologyRequirement(technologyRequirement);
        if (i==1){
            result.put("status",200);
            result.put("msg","ok");
            return result;
        }else {
            result.put("status",288);
            result.put("msg","添加失败，请确定参数是否正确");
            return result;
        }
    }
    //删除权限的验证
    @RequestMapping("/delete_judge")
    @ResponseBody
    public Map judge(){
        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
        return objectObjectHashMap;
    }

    //删除
    @RequestMapping("/delete_batch")
    @ResponseBody
    public Map delete(int[] ids){
        HashMap<String, Object> stringObjectHashMap = new HashMap<>();
        int i = technologyRequirementService.deleteTechnologyRequirement(ids);
        if (i==ids.length){
            stringObjectHashMap.put("status",200);
            stringObjectHashMap.put("msg","OK");
        }else {
            stringObjectHashMap.put("status",288);
            stringObjectHashMap.put("msg","删除失败，请重试");
        }
        return stringObjectHashMap;
    }

    //编辑需要权限验证
    @RequestMapping("/edit_judge")
    @ResponseBody
    public Map edit_judge(){
        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
        return objectObjectHashMap;
    }

    //权限验证通过后，window组件会调用edit方法,跳转到编辑页面
    @RequestMapping("/edit")
    public String edit(){
        return "/WEB-INF/jsp/technologyRequirement_edit.jsp";
    }

    //修改页面提交表单，会把数据提交到这个update_All方法
    @RequestMapping("/update_all")
    @ResponseBody
    public Map update(TechnologyRequirement requirement){
        HashMap<String, Object> stringObjectHashMap = new HashMap<>();
        int i = technologyRequirementService.updateTechnologyRequirement(requirement);
        if (i==1){
            stringObjectHashMap.put("status",200);
            stringObjectHashMap.put("msg","OK");
        }else {
            stringObjectHashMap.put("status",288);
            stringObjectHashMap.put("msg","更新失败，请重试");
        }
        return stringObjectHashMap;
    }

    //
    @RequestMapping("/update_requirement")
    @ResponseBody
    public Map updateNote(String technologyRequirementId,String requirement){
        Map<String, Object> map = new HashMap<>();
        int i = technologyRequirementService.updateNote(technologyRequirementId,requirement);
        if (i==1){
            map.put("status",200);
            map.put("msg","ok");
        }else {
            map.put("status",288);
            map.put("msg","失败");
        }
        return map;
    }

    //查询1：根据工艺要求编号
    @RequestMapping("/search_technologyRequirement_by_technologyRequirementId")
    @ResponseBody
    public List<TechnologyRequirement> queryRequireByRequireId(String searchValue){
        String search = "%"+searchValue+"%";
        List<TechnologyRequirement> technologyRequirements = technologyRequirementService.queryRequireByRequireId(search);
        return technologyRequirements;
    }
    //查询2：根据工艺名称
    @RequestMapping("/search_technologyRequirement_by_technologyName")
    @ResponseBody
    public List<TechnologyRequirement> queryRequireByTechName(String searchValue){
        String search = "%"+searchValue+"%";
        List<TechnologyRequirement> technologyRequirements = technologyRequirementService.queryRequireByTechName(search);
        return technologyRequirements;
    }
}
