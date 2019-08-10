package com.cskaoyan.controller.qualifyMonitor;

import com.cskaoyan.bean.qualifyMonitor.EndProductQualify;
import com.cskaoyan.bean.qualifyMonitor.JavaBean;
import com.cskaoyan.bean.qualifyMonitor.UnqualifyApply;
import com.cskaoyan.service.qualifyMonitor.EndProductQualifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
public class EndProductQualifyController {

    @Autowired
    EndProductQualifyService endProductQualifyService;

    // 跳转到成品计量质检列表页面
    @RequestMapping("/measure/find")
    public String toMeasureList(HttpServletRequest request) {
        ArrayList<Object> sysPermissionList = new ArrayList<>();
        sysPermissionList.add("fMeasureCheck:add");
        request.getSession().setAttribute("sysPermissionList", sysPermissionList);
        return "/WEB-INF/jsp/measurement_list.jsp";
    }

    // 把查询到的数据以json格式返回给前端
    @RequestMapping("/measure/list")
    @ResponseBody
    public JavaBean<EndProductQualify> queryEndProductQualify() {
        JavaBean<EndProductQualify> endProductQualifyJavaBean = new JavaBean<>();
        List<EndProductQualify> endProductQualifies = endProductQualifyService.EndProductQualify();
        endProductQualifyJavaBean.setRows(endProductQualifies);
        endProductQualifyJavaBean.setTotal(endProductQualifies.size());
        return endProductQualifyJavaBean;
    }

    // 添加的权限验证，暂时先提交一个空的map
    @RequestMapping("/fMeasureCheck/add_judge")
    @ResponseBody
    public HashMap addJudge() {
        return new HashMap<>();
    }

    // 跳转到add页面
    @RequestMapping("/measure/add")
    public String toMeasurementAdd() {
        return "/WEB-INF/jsp/measurement_add.jsp";
    }

    // 真正的插入步骤
    @RequestMapping("/measure/insert")
    @ResponseBody
    public HashMap insertEndProductQualify(EndProductQualify endProductQualify){
        // 创建一个map用来存放提示信息
        HashMap<String, Object> hashMap = new HashMap<>();
        // 调用新增方法
        int i = endProductQualifyService.insertEndProductQualify(endProductQualify);
        if (i > 0) {
            hashMap.put("msg", "OK");
            hashMap.put("status", 200);
        } else {
            hashMap.put("msg", "ERROR");
            hashMap.put("status", 500);
        }
        // 返回map
        return hashMap;
    }
}
