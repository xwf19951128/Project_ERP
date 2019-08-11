package com.cskaoyan.controller.user;

import com.cskaoyan.bean.user.Role;
import com.cskaoyan.bean.user.User;
import com.cskaoyan.bean.user.UserPage;
import com.cskaoyan.service.login.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("user/")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("find")
    public String find(HttpServletRequest request) {
        List<String> sysPermissionList = new ArrayList<>();
        sysPermissionList.add("user:add");
        sysPermissionList.add("user:edit");
        sysPermissionList.add("user:delete");
        request.getSession().setAttribute("sysPermissionList",sysPermissionList);
        return "/WEB-INF/jsp/user_list.jsp";
    }


    @RequestMapping("add_judge")
    @ResponseBody
    public  Map<String,String> addJudge() {
        return new HashMap<>();
    }

    @RequestMapping("delete_judge")
    @ResponseBody
    public  Map<String,String> deleteJudge() {
        return new HashMap<>();
    }

    @RequestMapping("edit_judge")
    @ResponseBody
    public  Map<String,String> editJudge() {
        return new HashMap<>();
    }

    @RequestMapping("edit")
    public String edit() {
        return "/WEB-INF/jsp/user_edit.jsp";
    }


    @RequestMapping("add")
    public String add() {
        return "/WEB-INF/jsp/user_add.jsp";
    }

    @RequestMapping("insert")
    @ResponseBody
    public Map<String, Object> insertDepartment(User user) {
        Map<String, Object> data = new HashMap<>();
        User isExist = userService.queryUserById(user);
        if (isExist == null) {
            int i = userService.insertUser(user);
            if (i > 0) {
                data.put("status", 200);
                data.put("msg", "OK");
            }
        } else {
            data.put("msg","该用户编号已经存在，请更换用户编号！");
        }
        return data;
    }

    @RequestMapping("list")
    @ResponseBody
    public UserPage getUserPage(int page, int rows) {
        UserPage userPage = new UserPage();
        PageHelper.startPage(page,rows);
        List<User> userList = userService.getUserList();
        PageInfo<User> pageInfo = new PageInfo<>(userList);
        long total = pageInfo.getTotal();
        userPage.setRows(userList);
        userPage.setTotal((int) total);
//        System.out.println(departmentList);
        return userPage;
    }

    @RequestMapping("delete_batch")
    @ResponseBody
    public Map<String, Object> deleteBatch(String[] ids) {
        Map<String, Object> data = new HashMap<>();
        int i = userService.deleteBatch(ids);
        if (i > 0) {
            data.put(("msg"),"OK");
            data.put("status",200);
            data.put("data",null);
        } else {
            data.put("msg","删除失败");
        }
        return data;
    }

    @RequestMapping("update_all")
    @ResponseBody
    public Map<String, Object> updateAll(User user) {
        Map<String, Object> data = new HashMap<>();
        int i = userService.updateAll(user);
        if (i > 0) {
            data.put("status",200);
            data.put("msg","OK");
            data.put("data",null);
        } else {
            data.put("meg","服务器开小差了，请稍后再试");
        }
        return data;

    }

    @RequestMapping("search_user_by_userId")
    @ResponseBody
    public UserPage searchUserByUserId(String searchValue,int rows, int page) {
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder term = stringBuilder.append("%").append(searchValue).append("%");  // 拼接查詢條件
        PageHelper.startPage(page,rows);
        List<User> list = userService.searchUserByUserId(term.toString());
        PageInfo<User> pageInfo = new PageInfo<>(list);
        long total = pageInfo.getTotal();
        UserPage userPage = new UserPage();
        userPage.setRows(list);
        userPage.setTotal(((int) total));
        return userPage;
    }

    @RequestMapping("search_user_by_userName")
    @ResponseBody
    public UserPage searchUserByUserName(String searchValue,int rows, int page) {
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder term = stringBuilder.append("%").append(searchValue).append("%");  // 拼接查詢條件
        PageHelper.startPage(page,rows);
        List<User> list = userService.searchUserByUserName(term.toString());
        PageInfo<User> pageInfo = new PageInfo<>(list);
        long total = pageInfo.getTotal();
        UserPage userPage = new UserPage();
        userPage.setRows(list);
        userPage.setTotal(((int) total));
        return userPage;
    }

    @RequestMapping("search_user_by_roleName")
    @ResponseBody
    public UserPage searchUserByRoleName(String searchValue,int rows, int page) {
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder term = stringBuilder.append("%").append(searchValue).append("%");  // 拼接查詢條件
        PageHelper.startPage(page,rows);
        List<User> list = userService.searchUserByRoleName(term.toString());
        PageInfo<User> pageInfo = new PageInfo<>(list);
        long total = pageInfo.getTotal();
        UserPage userPage = new UserPage();
        userPage.setRows(list);
        userPage.setTotal(((int) total));
        return userPage;
    }
}
