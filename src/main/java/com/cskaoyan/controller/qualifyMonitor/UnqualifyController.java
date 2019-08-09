package com.cskaoyan.controller.qualifyMonitor;

import com.cskaoyan.bean.qualifyMonitor.JavaBean;
import com.cskaoyan.bean.qualifyMonitor.UnqualifyApply;
import com.cskaoyan.service.qualifyMonitor.UnqualifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/unqualify")
public class UnqualifyController {

    // 从容器中获取service
    @Autowired
    UnqualifyService unqualifyService;

    // 跳转到不合格list页面
    @RequestMapping("/find")
    public String toUnqualifyList() {
        return "/WEB-INF/jsp/unqualify_list.jsp";
    }

    // 查询不合格商品申请名单。
    @RequestMapping("/list")
    @ResponseBody
    public JavaBean<UnqualifyApply> findUnqualify() {
        JavaBean<UnqualifyApply> unqualifyApplyJavaBean = new JavaBean<>();
        List<UnqualifyApply> unqualifyApplies = unqualifyService.queryUnqualifyApply();
        unqualifyApplyJavaBean.setRows(unqualifyApplies);
        unqualifyApplyJavaBean.setTotal(unqualifyApplies.size());
        return unqualifyApplyJavaBean;
    }

}
