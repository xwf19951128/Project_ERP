package com.cskaoyan.controller.technology;

import com.cskaoyan.bean.technology.QueryResult;
import com.cskaoyan.bean.technology.Technology;
import com.cskaoyan.service.technology.TechnologyService;
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
    public String find(){
        //需要设置sysPermissionList
        return "/WEB-INF/jsp/technology_list.jsp";
    }
   @RequestMapping("/list")
   @ResponseBody
    public QueryResult<Technology> list(){
       List<Technology> technologies = technologyService.queryAllTechnologies();
       QueryResult<Technology> technologyQueryResult = new QueryResult<>();
       technologyQueryResult.setRows(technologies);
       technologyQueryResult.setTotal(technologies.size());
       return technologyQueryResult;
   }
}
