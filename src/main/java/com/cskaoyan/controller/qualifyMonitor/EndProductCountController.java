package com.cskaoyan.controller.qualifyMonitor;

import com.cskaoyan.bean.qualifyMonitor.EndProductCount;
import com.cskaoyan.bean.qualifyMonitor.JavaBean;
import com.cskaoyan.service.qualifyMonitor.EndProductCountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/f_count_check")
public class EndProductCountController {

    @Autowired
    EndProductCountService endProductCountService;

    @RequestMapping("/find")
    public String toCountCheckList() {
        return "/WEB-INF/jsp/f_count_check_list.jsp";
    }

    @RequestMapping("/list")
    @ResponseBody
    JavaBean<EndProductCount> queryEndProductCount() {
        JavaBean<EndProductCount> endProductCountJavaBean = new JavaBean<>();
        List<EndProductCount> endProductCounts = endProductCountService.queryEndProductCount();
        endProductCountJavaBean.setRows(endProductCounts);
        endProductCountJavaBean.setTotal(endProductCounts.size());
        return endProductCountJavaBean;
    }

}
