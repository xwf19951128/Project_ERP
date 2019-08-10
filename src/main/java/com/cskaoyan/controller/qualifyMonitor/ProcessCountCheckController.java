package com.cskaoyan.controller.qualifyMonitor;

import com.cskaoyan.bean.qualifyMonitor.JavaBean;
import com.cskaoyan.bean.qualifyMonitor.ProcessCountCheck;
import com.cskaoyan.service.qualifyMonitor.ProcessCountCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("p_count_check")
public class ProcessCountCheckController {

    @Autowired
    ProcessCountCheckService processCountCheckService;

    @RequestMapping("/find")
    public String toProcessCountCheckList() {
        return "/WEB-INF/jsp/p_count_check_list.jsp";
    }

    @RequestMapping("/list")
    @ResponseBody
    public JavaBean<ProcessCountCheck> queryProcessCountCheck() {
        JavaBean<ProcessCountCheck> processCountCheckJavaBean = new JavaBean<>();
        List<ProcessCountCheck> processCountChecks = processCountCheckService.queryProcessCountCheck();
        processCountCheckJavaBean.setRows(processCountChecks);
        processCountCheckJavaBean.setTotal(processCountChecks.size());
        return processCountCheckJavaBean;
    }
}
