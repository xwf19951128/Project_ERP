package com.cskaoyan.controller.qualifyMonitor;

import com.cskaoyan.bean.qualifyMonitor.*;
import com.cskaoyan.service.qualifyMonitor.ProcessMeasureCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// 注册到Spring容器
@Controller
public class ProcessMeasureCheckController {

    // 从容器中取出Service
    @Autowired
    ProcessMeasureCheckService processMeasureCheckService;

    // 跳转到工序计量质检列表页面
    @RequestMapping("/p_measure_check/find")
    public String toCountCheckList(HttpServletRequest request) {
        // 创建一个集合
        ArrayList<Object> sysPermissionList = new ArrayList<>();
        // 把这个add信息存进这个集合
        sysPermissionList.add("pMeasureCheck:add");
        // 删除按钮
        sysPermissionList.add("pMeasureCheck:delete");
        // 编辑按钮
        sysPermissionList.add("pMeasureCheck:edit");
        // 把集合存进这个session域
        request.getSession().setAttribute("sysPermissionList", sysPermissionList);
        // 再次跳转到list.jsp
        return "/WEB-INF/jsp/p_measure_check_list.jsp";
    }

    // 把查询到的数据封装到Javabean
    @RequestMapping("/p_measure_check/list")
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

    // 权限验证
    @RequestMapping("/pMeasureCheck/add_judge")
    @ResponseBody
    public HashMap pMeasureCheckAddJudge() {
        return new HashMap();
    }

    // 跳转到add.jsp
    @RequestMapping("/p_measure_check/add")
    public String toPMeasureCheckAdd() {
        return "/WEB-INF/jsp/p_measure_check_add.jsp";
    }

    // 真正插入
    @RequestMapping("/p_measure_check/insert")
    @ResponseBody
    public HashMap insertProcessMeasureCheck(ProcessMeasureCheck processMeasureCheck) {
        // map用于存储校验信息
        HashMap<Object, Object> hashMap = new HashMap<>();
        // 插入
        int i = processMeasureCheckService.insertProcessMeasureCheck(processMeasureCheck);
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
    @RequestMapping("/pMeasureCheck/delete_judge")
    @ResponseBody
    public HashMap pMeasureCheckDeleteJudge() {
        HashMap<Object, Object> map = new HashMap<>();
        return map;
    }

    // 真正删除
    @RequestMapping("/p_measure_check/delete_batch")
    @ResponseBody
    public HashMap deleteMeasure(String[] ids) {
        // map用来存储反馈信息
        HashMap<Object, Object> hashMap = new HashMap<>();
        // 删除
        int i = processMeasureCheckService.deleteProcessMeasureCheckById(ids);
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
    @RequestMapping("/pMeasureCheck/edit_judge")
    @ResponseBody
    public HashMap editJudge() {
        HashMap<Object, Object> map = new HashMap<>();
        return map;
    }

    // 跳转到编辑的jsp页面
    @RequestMapping("/p_measure_check/edit")
    public String toEditList() {
        return "/WEB-INF/jsp/p_measure_check_edit.jsp";
    }

    // 编辑
    @RequestMapping("/p_measure_check/update_all")
    @ResponseBody
    public HashMap editProcessMeasure(ProcessMeasureCheck processMeasureCheck){
        // 创建一个map来保存验证信息
        HashMap<String, Object> hashMap = new HashMap<>();
        // 编辑不合格产品
        int i = processMeasureCheckService.editProcessMeasureCheck(processMeasureCheck);
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
    @RequestMapping("/p_measure_check/search_pMeasureCheck_by_pMeasureCheckId")
    @ResponseBody
    public JavaBean<ProcessMeasureCheck> searchPMeasureCheckById(String searchValue) {
        JavaBean<ProcessMeasureCheck> processMeasureCheckJavaBean = new JavaBean<>();
        List<ProcessMeasureCheck> processMeasureChecks = processMeasureCheckService.searchPMeasureCheckById("%" + searchValue + "%");
        processMeasureCheckJavaBean.setRows(processMeasureChecks);
        processMeasureCheckJavaBean.setTotal(processMeasureChecks.size());
        return processMeasureCheckJavaBean;
    }
}
