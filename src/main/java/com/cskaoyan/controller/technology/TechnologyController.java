package com.cskaoyan.controller.technology;

import com.cskaoyan.bean.technology.Process;
import com.cskaoyan.bean.technology.QueryResult;
import com.cskaoyan.bean.technology.Technology;
import com.cskaoyan.service.technology.TechnologyService;
import com.github.pagehelper.Page;
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

@RequestMapping("/technology")
@Controller
public class TechnologyController {
    @Autowired
    TechnologyService technologyService;

    @RequestMapping("/find")
    public String find(HttpServletRequest request){
        //需要设置sysPermissionList
        //还需要添加一个用于权限管理的集合
        ArrayList<String> sysPermissionList = new ArrayList<>();
        sysPermissionList.add("technology:add");
        sysPermissionList.add("technology:edit");
        sysPermissionList.add("technology:delete");
        request.getSession().setAttribute("sysPermissionList",sysPermissionList);
        return "/WEB-INF/jsp/technology_list.jsp";
    }
   @RequestMapping("/list")
   @ResponseBody
    public QueryResult<Technology> list(){
       Page page = PageHelper.startPage(1, 10);
       List<Technology> technologies = technologyService.queryAllTechnologies();
       PageInfo<Technology> pageInfo = new PageInfo<>(technologies);
       long total = pageInfo.getTotal();
       QueryResult<Technology> technologyQueryResult = new QueryResult<>();
       technologyQueryResult.setRows(technologies);
       technologyQueryResult.setTotal((int) total);
       return technologyQueryResult;
   }

   // 这是工序管理页面所需要的get_data方法
    @RequestMapping("/get_data")
    @ResponseBody
    public List<Technology> get_data(){
        List<Technology> technologies = technologyService.queryAllTechnologies();
        return technologies;
    }

    //点击add按钮时需要发送过来ajax请求验证
    @RequestMapping("/add_judge")
    @ResponseBody
    public Map add_judge(){
        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
        return objectObjectHashMap;
    }

    //window组件会发送一个请求，跳转到technology的add.jsp页面
    @RequestMapping("/add")
    public String add(){
        return "/WEB-INF/jsp/technology_add.jsp";
    }

    //输入要增加的工序信息后，会把信息发送到insert方法中
    //注意，表单传过来的并不是Json格式的数据，这一点算是个坑
    //但是返回值必须是jason！！！！！
    @RequestMapping("/insert")
    @ResponseBody
    public Map insert(Technology technology){
        HashMap<String, Object> result = new HashMap<>();
        int i = technologyService.insertTechnology(technology);
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

    //删除之前需要先验证权限
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
        int i = technologyService.deleteTechnology(ids);
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
        return "/WEB-INF/jsp/technology_edit.jsp";
    }

    //修改页面提交表单，会把数据提交到这个update_All方法
    @RequestMapping("/update_all")
    @ResponseBody
    public Map update(Technology technology){
        HashMap<String, Object> stringObjectHashMap = new HashMap<>();
        int i = technologyService.updateTechnology(technology);
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
