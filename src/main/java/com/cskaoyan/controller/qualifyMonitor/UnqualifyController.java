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
        // 把unqualify:delete添加到集合中
        sysPermissionList.add("unqualify:delete");
        // 把unqualify:edit添加到集合中
        sysPermissionList.add("unqualify:edit");
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

    // 删除的权限验证
    @RequestMapping("/unqualify/delete_judge")
    @ResponseBody
    public HashMap unqualifyDeleteJudge() {
        HashMap<Object, Object> map = new HashMap<>();
        return map;
    }

    // 真正删除
    @RequestMapping("/unqualify/delete_batch")
    @ResponseBody
    public HashMap deleteUnqualify(String[] ids) {
        // map用来存储反馈信息
        HashMap<Object, Object> hashMap = new HashMap<>();
        // 删除
        int i = unqualifyService.deleteUnqualifyById(ids);
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
    @RequestMapping("/unqualify/edit_judge")
    @ResponseBody
    public HashMap unqualifyEditJudge() {
        HashMap<Object, Object> map = new HashMap<>();
        return map;
    }

    // 跳转到编辑的jsp页面
    @RequestMapping("/unqualify/edit")
    public String toEditList() {
        return "/WEB-INF/jsp/unqualify_edit.jsp";
    }

    // 编辑
    @RequestMapping("/unqualify/update_all")
    @ResponseBody
    public HashMap editUnqualify(UnqualifyApply unqualifyApply){
        // 创建一个map来保存验证信息
        HashMap<String, Object> hashMap = new HashMap<>();
        // 编辑不合格产品
        int i = unqualifyService.editUnqualify(unqualifyApply);
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

    // 根据不合格产品id来模糊查询
    @RequestMapping("/unqualify/search_unqualify_by_unqualifyId")
    @ResponseBody
    public JavaBean<UnqualifyApply> searchUnqualifyById(String searchValue) {
        // 新建一个JavaBean，用来存储rows和total
        JavaBean<UnqualifyApply> unqualifyApplyJavaBean = new JavaBean<>();
        // 通过id进行模糊查询，因为要模糊查询所以要百分号
        List<UnqualifyApply> unqualifyApplies = unqualifyService.searchUnqualifyById("%" + searchValue +"%");
        // 把查询结果封装到JavaBean
        unqualifyApplyJavaBean.setRows(unqualifyApplies);
        unqualifyApplyJavaBean.setTotal(unqualifyApplies.size());
        // 返回这个JavaBean
        return unqualifyApplyJavaBean;
    }

    // 根据名称进行模糊查询
    @RequestMapping("/unqualify/search_unqualify_by_productName")
    @ResponseBody
    public JavaBean<UnqualifyApply> searchUnqualifyByName(String searchValue) {
        // 新建一个JavaBean，用来存储rows和total
        JavaBean<UnqualifyApply> unqualifyApplyJavaBean = new JavaBean<>();
        // 通过名称进行模糊查询，因为要模糊查询所以要百分号
        List<UnqualifyApply> unqualifyApplies = unqualifyService.searchUnqualifyByName("%" + searchValue +"%");
        // 把查询结果封装到JavaBean
        unqualifyApplyJavaBean.setRows(unqualifyApplies);
        unqualifyApplyJavaBean.setTotal(unqualifyApplies.size());
        // 返回这个JavaBean
        return unqualifyApplyJavaBean;
    }
}
