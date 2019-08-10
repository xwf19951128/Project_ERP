package com.cskaoyan.controller.qualifyMonitor;

import com.cskaoyan.bean.qualifyMonitor.JavaBean;
import com.cskaoyan.bean.qualifyMonitor.UnqualifyApply;
import com.cskaoyan.service.qualifyMonitor.UnqualifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
public class UnqualifyController {

    // 从容器中获取service
    @Autowired
    UnqualifyService unqualifyService;

    // 跳转到不合格list页面
    @RequestMapping("/unqualify/find")
    public String toUnqualifyList(HttpServletRequest request) {
        // 创建一个集合
        ArrayList<Object> sysPermissionList = new ArrayList<>();
        // 把unqualify:add添加到集合中
        sysPermissionList.add("unqualify:add");
        // 把这个集合存到session域
        request.getSession().setAttribute("sysPermissionList", sysPermissionList);
        // 再次跳转到list页面
        return "/WEB-INF/jsp/unqualify_list.jsp";
    }

    // 查询不合格商品申请名单。
    @RequestMapping("/unqualify/list")
    @ResponseBody
    public JavaBean<UnqualifyApply> findUnqualify() {
        JavaBean<UnqualifyApply> unqualifyApplyJavaBean = new JavaBean<>();
        List<UnqualifyApply> unqualifyApplies = unqualifyService.queryUnqualifyApply();
        unqualifyApplyJavaBean.setRows(unqualifyApplies);
        unqualifyApplyJavaBean.setTotal(unqualifyApplies.size());
        return unqualifyApplyJavaBean;
    }

    // 跳转到添加不合格产品的jsp页面
    @RequestMapping("/unqualify/add")
    public String toAddList() {
        return "/WEB-INF/jsp/unqualify_add.jsp";
    }

    // 添加的权限验证，暂时先提交一个空的map
    @RequestMapping("/unqualify/add_judge")
    @ResponseBody
    public HashMap addJudge() {
        HashMap<Object, Object> map = new HashMap<>();
        return map;
    }

    // 开始真正的插入不合格产品的步骤
    @RequestMapping("/unqualify/insert")
    @ResponseBody
    public HashMap insertUnqualify(UnqualifyApply unqualifyApply){
        // 创建一个map来保存验证信息
        HashMap<String, Object> hashMap = new HashMap<>();
        // 插入不合格产品
        int i = unqualifyService.insertUnqualify(unqualifyApply);
        // 存储验证信息
        if (i > 0) {
            hashMap.put("msg", "OK");
            hashMap.put("status", 200);
        } else {
            hashMap.put("msg", "ERROR");
            hashMap.put("status", 500);
        }
        return hashMap;
    }


}
