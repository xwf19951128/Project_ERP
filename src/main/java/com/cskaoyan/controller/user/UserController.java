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


}
