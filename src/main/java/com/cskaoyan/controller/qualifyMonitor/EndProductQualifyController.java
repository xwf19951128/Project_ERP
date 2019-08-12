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
        // 添加按钮
        sysPermissionList.add("fMeasureCheck:add");
        // 删除按钮
        sysPermissionList.add("fMeasureCheck:delete");
        // 编辑按钮
        sysPermissionList.add("fMeasureCheck:edit");
        // 存到session域
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

    // 删除的权限验证
    @RequestMapping("/fMeasureCheck/delete_judge")
    @ResponseBody
    public HashMap fMeasureCheckDeleteJudge() {
        HashMap<Object, Object> map = new HashMap<>();
        return map;
    }

    // 真正删除
    @RequestMapping("/measure/delete_batch")
    @ResponseBody
    public HashMap deleteMeasure(String[] ids) {
        // map用来存储反馈信息
        HashMap<Object, Object> hashMap = new HashMap<>();
        // 删除
        int i = endProductQualifyService.deleteEndProductQualifyById(ids);
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
    @RequestMapping("/fMeasureCheck/edit_judge")
    @ResponseBody
    public HashMap editJudge() {
        HashMap<Object, Object> map = new HashMap<>();
        return map;
    }

    // 跳转到编辑的jsp页面
    @RequestMapping("/measure/edit")
    public String toEditList() {
        return "/WEB-INF/jsp/measurement_edit.jsp";
    }

    // 编辑
    @RequestMapping("/measure/update_all")
    @ResponseBody
    public HashMap editMeasure(EndProductQualify endProductQualify){
        // 创建一个map来保存验证信息
        HashMap<String, Object> hashMap = new HashMap<>();
        // 编辑不合格产品
        int i = endProductQualifyService.editEndProductQualify(endProductQualify);
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
    @RequestMapping("/measure/search_fMeasureCheck_by_fMeasureCheckId")
    @ResponseBody
    public JavaBean<EndProductQualify> searchEndProductQualifyById(String searchValue) {
        JavaBean<EndProductQualify> endProductQualifyJavaBean = new JavaBean<>();
        List<EndProductQualify> endProductQualifies = endProductQualifyService.searchEndProductQualifyById("%" + searchValue + "%");
        endProductQualifyJavaBean.setRows(endProductQualifies);
        endProductQualifyJavaBean.setTotal(endProductQualifies.size());
        return endProductQualifyJavaBean;
    }

    // 根据订单编号进行模糊查询
    // 根据id进行模糊查询
    @RequestMapping("/measure/search_fMeasureCheck_by_orderId")
    @ResponseBody
    public JavaBean<EndProductQualify> searchEndProductQualifyByOrderId(String searchValue) {
        JavaBean<EndProductQualify> endProductQualifyJavaBean = new JavaBean<>();
        List<EndProductQualify> endProductQualifies = endProductQualifyService.searchEndProductQualifyByOrderId("%" + searchValue + "%");
        endProductQualifyJavaBean.setRows(endProductQualifies);
        endProductQualifyJavaBean.setTotal(endProductQualifies.size());
        return endProductQualifyJavaBean;
    }
}
