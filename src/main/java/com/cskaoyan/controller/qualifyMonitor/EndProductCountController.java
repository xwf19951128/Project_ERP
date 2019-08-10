package com.cskaoyan.controller.qualifyMonitor;

import com.cskaoyan.bean.qualifyMonitor.EndProductCount;
import com.cskaoyan.bean.qualifyMonitor.JavaBean;
import com.cskaoyan.service.qualifyMonitor.EndProductCountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class EndProductCountController {

    @Autowired
    EndProductCountService endProductCountService;

    // 跳转到成品计数列表展示页面
    @RequestMapping("/f_count_check/find")
    public String toCountCheckList(HttpServletRequest request) {
        // 创建一个集合
        ArrayList<String> sysPermissionList = new ArrayList<>();
        // 把这个add信息存进这个集合
        sysPermissionList.add("fCountCheck:add");
        // 把集合存进这个session域
        request.getSession().setAttribute("sysPermissionList", "sysPermissionList");
        // 再次跳转到list.jsp
        return "/WEB-INF/jsp/f_count_check_list.jsp";
    }

    // 查询全部
    @RequestMapping("/f_count_check/list")
    @ResponseBody
    JavaBean<EndProductCount> queryEndProductCount() {
        JavaBean<EndProductCount> endProductCountJavaBean = new JavaBean<>();
        List<EndProductCount> endProductCounts = endProductCountService.queryEndProductCount();
        endProductCountJavaBean.setRows(endProductCounts);
        endProductCountJavaBean.setTotal(endProductCounts.size());
        return endProductCountJavaBean;
    }

}
