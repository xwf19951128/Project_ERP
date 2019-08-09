package com.cskaoyan.controller.technology;

import com.cskaoyan.bean.technology.TechnologyRequirement;
import com.cskaoyan.service.technology.TechnologyRequirementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/technologyRequirement")
public class TechnologyRequirementController {
    @Autowired
    TechnologyRequirementService technologyRequirementService;

    @RequestMapping("/find")
    public String find(){
        return "/WEB-INF/jsp/technologyRequirement_list.jsp";
    }

    @RequestMapping("/list")
    @ResponseBody
    public List<TechnologyRequirement> list(){
        List<TechnologyRequirement> technologyRequirements = technologyRequirementService.queryAllTechnologyRequirements();
        return technologyRequirements;
    }
}
