package com.cskaoyan.controller.technology;

import com.cskaoyan.bean.technology.TechnologyPlan;
import com.cskaoyan.service.technology.TechnologyPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/technologyPlan")
public class TechnologyPlanController {
    @Autowired
    TechnologyPlanService technologyPlanService;

    @RequestMapping("/find")
    public String find(){
        return "/WEB-INF/jsp/technologyPlan_list.jsp";
    }

    @RequestMapping("/list")
    @ResponseBody
    public List<TechnologyPlan> list(){
        List<TechnologyPlan> technologyPlans = technologyPlanService.queryAllTechPlans();
        return technologyPlans;
    }

}
