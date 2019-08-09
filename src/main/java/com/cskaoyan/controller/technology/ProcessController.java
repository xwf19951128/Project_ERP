package com.cskaoyan.controller.technology;

import com.cskaoyan.bean.technology.Process;
import com.cskaoyan.bean.technology.QueryResult;
import com.cskaoyan.service.technology.ProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/process")
public class ProcessController {

    @Autowired
    ProcessService processService;

    @RequestMapping("/find")
    public String find(){
        //需要设置sysPermissionList
        return "/WEB-INF/jsp/process_list.jsp";
    }

    @RequestMapping("/list")
    @ResponseBody
    public QueryResult<Process> listProcess(){
        List<Process> processes1 = processService.queryAllProcesses();
        QueryResult<Process> processQueryResult = new QueryResult<>();
        processQueryResult.setRows(processes1);
        processQueryResult.setTotal(processes1.size());
        return processQueryResult;
    }
}
