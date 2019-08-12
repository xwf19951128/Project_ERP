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
import java.util.HashMap;
import java.util.List;

@Controller
public class EndProductCountController {

    @Autowired
    EndProductCountService endProductCountService;

    // 跳转到成品计数列表展示页面
    @RequestMapping("/f_count_check/find")
    public String toCountCheckList(HttpServletRequest request) {
        // 创建一个集合
        ArrayList<Object> sysPermissionList = new ArrayList<>();
        // 把这个add信息存进这个集合
        sysPermissionList.add("fCountCheck:add");
        // 把unqualify:delete添加到集合中
        sysPermissionList.add("fCountCheck:delete");
        // 编辑按钮
        sysPermissionList.add("fCountCheck:edit");
        // 把集合存进这个session域
        request.getSession().setAttribute("sysPermissionList", sysPermissionList);
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

    // add的权限验证
    @RequestMapping("/fCountCheck/add_judge")
    @ResponseBody
    public HashMap addJudge() {
        return new HashMap();
    }

    // 跳转到add.jsp
    @RequestMapping("/f_count_check/add")
    public String toFCountCheckAdd() {
        return "/WEB-INF/jsp/f_count_check_add.jsp";
    }

    // 真正的insert插入
    @RequestMapping("/f_count_check/insert")
    @ResponseBody
    public HashMap insertFCountCheck(EndProductCount endProductCount) {
        // map来存储验证信息
        HashMap<Object, Object> hashMap = new HashMap<>();
        // 插入
        int i = endProductCountService.insertEndProductCount(endProductCount);
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


    // 删除的权限验证
    @RequestMapping("/fCountCheck/delete_judge")
    @ResponseBody
    public HashMap fCountCheckDeleteJudge() {
        HashMap<Object, Object> map = new HashMap<>();
        return map;
    }

    // 真正删除
    @RequestMapping("/f_count_check/delete_batch")
    @ResponseBody
    public HashMap deleteFCountCheck(String[] ids) {
        // map用来存储反馈信息
        HashMap<Object, Object> hashMap = new HashMap<>();
        // 删除
        int i = endProductCountService.deleteEndProductCountById(ids);
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

    // 编辑的权限验证
    @RequestMapping("/fCountCheck/edit_judge")
    @ResponseBody
    public HashMap fCountCheckEditJudge() {
        HashMap<Object, Object> map = new HashMap<>();
        return map;
    }

    // 跳转到edit.jsp
    @RequestMapping("/f_count_check/edit")
    public String toFCountCheckEdit() {
        return "/WEB-INF/jsp/f_count_check_edit.jsp";
    }

    // 真正的编辑
    @RequestMapping("/f_count_check/update_all")
    @ResponseBody
    public HashMap editFCountCheck(EndProductCount endProductCount) {
        // map来存储验证信息
        HashMap<Object, Object> hashMap = new HashMap<>();
        // 编辑
        int i = endProductCountService.editEndProductCount(endProductCount);
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

    // 根据id进行模糊查询
    @RequestMapping("/f_count_check/search_fCountCheck_by_fCountCheckId")
    @ResponseBody
    public JavaBean<EndProductCount> searchEndProductCountById(String searchValue) {
        JavaBean<EndProductCount> endProductCountJavaBean = new JavaBean<>();
        List<EndProductCount> endProductCounts = endProductCountService.searchEndProductCountById("%" + searchValue + "%");
        endProductCountJavaBean.setRows(endProductCounts);
        endProductCountJavaBean.setTotal(endProductCounts.size());
        return endProductCountJavaBean;
    }

    // 根据订单编号进行模糊查询
    @RequestMapping("/f_count_check/search_fCountCheck_by_orderId")
    @ResponseBody
    public JavaBean<EndProductCount> searchEndProductCountByOrderId(String searchValue) {
        JavaBean<EndProductCount> endProductCountJavaBean = new JavaBean<>();
        List<EndProductCount> endProductCounts = endProductCountService.searchEndProductCountByOrderId("%" + searchValue + "%");
        endProductCountJavaBean.setRows(endProductCounts);
        endProductCountJavaBean.setTotal(endProductCounts.size());
        return endProductCountJavaBean;
    }
}
