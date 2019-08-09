package com.cskaoyan.controller.technology;

import com.cskaoyan.bean.technology.Process;
import com.cskaoyan.bean.technology.TechnologyPlan;
import com.cskaoyan.service.technology.TechnologyPlanService;
import org.omg.CORBA.PUBLIC_MEMBER;
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
@RequestMapping("/technologyPlan")
public class TechnologyPlanController {
    @Autowired
    TechnologyPlanService technologyPlanService;

    @RequestMapping("/find")
    public String find(HttpServletRequest request){
        //还需要添加一个用于权限管理的集合
        ArrayList<String> sysPermissionList = new ArrayList<>();
        sysPermissionList.add("technologyPlan:add");
        sysPermissionList.add("technologyPlan:edit");
        sysPermissionList.add("technologyPlan:delete");
        request.getSession().setAttribute("sysPermissionList",sysPermissionList);

        return "/WEB-INF/jsp/technologyPlan_list.jsp";
    }

    @RequestMapping("/list")
    @ResponseBody
    public List<TechnologyPlan> list(){
        List<TechnologyPlan> technologyPlans = technologyPlanService.queryAllTechPlans();
        return technologyPlans;
    }

    //新增工序管理时，需要获取它的数据get_data
    @RequestMapping("/get_data")
    @ResponseBody
    public List<TechnologyPlan> get_data(){
        List<TechnologyPlan> technologyPlans = technologyPlanService.queryAllTechPlans();
        return technologyPlans;
    }

    //点击add按钮时需要发送过来ajax请求验证
    @RequestMapping("/add_judge")
    @ResponseBody
    public Map add_judge(){
        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
        return objectObjectHashMap;
    }

    //window组件会发送一个请求，跳转到technologyPlan的add.jsp页面
    @RequestMapping("/add")
    public String add(){
        return "/WEB-INF/jsp/technologyPlan_add.jsp";
    }

    //输入要增加的工艺计划后，会把信息发送到insert方法中
    //注意，表单传过来的并不是Json格式的数据，这一点算是个坑
    //但是返回值必须是jason！！！！！
    @RequestMapping("/insert")
    @ResponseBody
    public Map insert(TechnologyPlan technologyPlan){
        HashMap<String, Object> result = new HashMap<>();
        int i = technologyPlanService.insertTechnologyPlan(technologyPlan);
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

    //验证删除权限
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
        int i = technologyPlanService.deleteTechnologyPlan(ids);
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
        return "/WEB-INF/jsp/technologyPlan_edit.jsp";
    }

    //修改页面提交表单，会把数据提交到这个update_All方法
    @RequestMapping("/update_all")
    @ResponseBody
    public Map update(TechnologyPlan technologyPlan){
        HashMap<String, Object> stringObjectHashMap = new HashMap<>();
        int i = technologyPlanService.updateTechnologyPlan(technologyPlan);
        if (i==1){
            stringObjectHashMap.put("status",200);
            stringObjectHashMap.put("msg","OK");
        }else {
            stringObjectHashMap.put("status",288);
            stringObjectHashMap.put("msg","更新失败，请重试");
        }
        return stringObjectHashMap;
    }
}
