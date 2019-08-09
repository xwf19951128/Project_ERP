package com.cskaoyan.controller.technology;

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
import java.util.List;

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
       Page page = PageHelper.startPage(1, 2);
       List<Technology> technologies = technologyService.queryAllTechnologies();
       PageInfo<Technology> pageInfo = new PageInfo<>(technologies);
       long total = pageInfo.getTotal();
       QueryResult<Technology> technologyQueryResult = new QueryResult<>();
       technologyQueryResult.setRows(technologies);
       technologyQueryResult.setTotal((int) total);
       return technologyQueryResult;
   }
}
