package com.cskaoyan.controller.qualifyMonitor;

import com.cskaoyan.bean.qualifyMonitor.EndProductQualify;
import com.cskaoyan.bean.qualifyMonitor.JavaBean;
import com.cskaoyan.service.qualifyMonitor.EndProductQualifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/measure")
public class EndProductQualifyController {

    @Autowired
    EndProductQualifyService endProductQualifyService;

    @RequestMapping("/find")
    public String toMeasureList() {
        return "/WEB-INF/jsp/measurement_list.jsp";
    }

    @RequestMapping("/list")
    @ResponseBody
    public JavaBean<EndProductQualify> queryEndProductQualify() {
        JavaBean<EndProductQualify> endProductQualifyJavaBean = new JavaBean<>();
        List<EndProductQualify> endProductQualifies = endProductQualifyService.EndProductQualify();
        endProductQualifyJavaBean.setRows(endProductQualifies);
        endProductQualifyJavaBean.setTotal(endProductQualifies.size());
        return endProductQualifyJavaBean;
    }
}
