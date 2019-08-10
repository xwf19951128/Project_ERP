package com.cskaoyan.controller.qualifyMonitor;

import com.cskaoyan.bean.qualifyMonitor.JavaBean;
import com.cskaoyan.bean.qualifyMonitor.ProcessMeasureCheck;
import com.cskaoyan.service.qualifyMonitor.ProcessMeasureCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

// 注册到Spring容器
@Controller
// 映射到url请求
@RequestMapping("p_measure_check")
public class ProcessMeasureCheckController {

    // 从容器中取出Service
    @Autowired
    ProcessMeasureCheckService processMeasureCheckService;

    // 跳转到工序计量质检列表页面
    @RequestMapping("/find")
    public String toCountCheckList() {
        return "/WEB-INF/jsp/p_measure_check_list.jsp";
    }

    // 把查询到的数据封装到Javabean
    @RequestMapping("/list")
    @ResponseBody
    public JavaBean<ProcessMeasureCheck> queryMeasureCheck() {
        // 生成一个JavaBean 来存 List和total
        JavaBean<ProcessMeasureCheck> measureCheckJavaBean = new JavaBean<>();
        // 获取MeasureCheck集合
        List<ProcessMeasureCheck> processMeasureChecks = processMeasureCheckService.queryMeasureCheck();
        // 存List
        measureCheckJavaBean.setRows(processMeasureChecks);
        // 存total
        measureCheckJavaBean.setTotal(processMeasureChecks.size());
        // 返回封装结果
        return measureCheckJavaBean;
    }


}
