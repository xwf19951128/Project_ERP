package com.cskaoyan.controller.qualifyMonitor;

import com.cskaoyan.bean.qualifyMonitor.JavaBean;
import com.cskaoyan.bean.qualifyMonitor.ProcessCountCheck;
import com.cskaoyan.service.qualifyMonitor.ProcessCountCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
public class ProcessCountCheckController {

    @Autowired
    ProcessCountCheckService processCountCheckService;

    @RequestMapping("/p_count_check/find")
    public String toProcessCountCheckList(HttpServletRequest request) {
        // 创建一个集合
        ArrayList<Object> sysPermissionList = new ArrayList<>();
        // 把这个add信息存进这个集合
        sysPermissionList.add("pCountCheck:add");
        // 把unqualify:delete添加到集合中
        sysPermissionList.add("pCountCheck:delete");
        // 编辑按钮
        sysPermissionList.add("pCountCheck:edit");
        // 把集合存进这个session域
        request.getSession().setAttribute("sysPermissionList", sysPermissionList);
        // 再次跳转到list.jsp
        return "/WEB-INF/jsp/p_count_check_list.jsp";
    }

    @RequestMapping("/p_count_check/list")
    @ResponseBody
    public JavaBean<ProcessCountCheck> queryProcessCountCheck() {
        JavaBean<ProcessCountCheck> processCountCheckJavaBean = new JavaBean<>();
        List<ProcessCountCheck> processCountChecks = processCountCheckService.queryProcessCountCheck();
        processCountCheckJavaBean.setRows(processCountChecks);
        processCountCheckJavaBean.setTotal(processCountChecks.size());
        return processCountCheckJavaBean;
    }

    // 权限验证
    @RequestMapping("/pCountCheck/add_judge")
    @ResponseBody
    public HashMap pCountCheckAddJudge() {
        return new HashMap();
    }

    // 跳转到add.jsp
    @RequestMapping("/p_count_check/add")
    public String toPCountCheckAdd() {
        return "/WEB-INF/jsp/p_count_check_add.jsp";
    }

    // 真正插入
    @RequestMapping("/p_count_check/insert")
    @ResponseBody
    public HashMap insertProcessCountCheck(ProcessCountCheck processCountCheck) {
        // map用于存储校验信息
        HashMap<Object, Object> hashMap = new HashMap<>();
        // 插入
        int i = processCountCheckService.insertProcessCountCheck(processCountCheck);
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
    @RequestMapping("/pCountCheck/delete_judge")
    @ResponseBody
    public HashMap pCountCheckDeleteJudge() {
        HashMap<Object, Object> map = new HashMap<>();
        return map;
    }

    // 真正删除
    @RequestMapping("/p_count_check/delete_batch")
    @ResponseBody
    public HashMap deletepCountCheck(String[] ids) {
        // map用来存储反馈信息
        HashMap<Object, Object> hashMap = new HashMap<>();
        // 删除
        int i = processCountCheckService.deleteProcessCountCheckById(ids);
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
    @RequestMapping("/pCountCheck/edit_judge")
    @ResponseBody
    public HashMap pCountCheckEditJudge() {
        HashMap<Object, Object> map = new HashMap<>();
        return map;
    }

    // 跳转到edit.jsp
    @RequestMapping("/p_count_check/edit")
    public String toPCountCheckEdit() {
        return "/WEB-INF/jsp/p_count_check_edit.jsp";
    }

    // 真正编辑
    @RequestMapping("/p_count_check/update_all")
    @ResponseBody
    public HashMap editProcessCountCheck(ProcessCountCheck processCountCheck) {
        // map用于存储校验信息
        HashMap<Object, Object> hashMap = new HashMap<>();
        // 编辑
        int i = processCountCheckService.editProcessCountCheck(processCountCheck);
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
    @RequestMapping("/p_count_check/search_pCountCheck_by_pCountCheckId")
    @ResponseBody
    public JavaBean<ProcessCountCheck> searchPCountCheckById(String searchValue) {
        JavaBean<ProcessCountCheck> processCountCheckJavaBean = new JavaBean<>();
        List<ProcessCountCheck> processCountChecks = processCountCheckService.searchPCountCheckById("%" + searchValue + "%");
        processCountCheckJavaBean.setRows(processCountChecks);
        processCountCheckJavaBean.setTotal(processCountChecks.size());
        return processCountCheckJavaBean;
    }
}
