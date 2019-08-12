package com.cskaoyan.controller.user;

import com.cskaoyan.bean.user.Role;
import com.cskaoyan.service.login.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class RoleController {

    @Autowired
    UserService userService;

    @RequestMapping("role/get_data")
    @ResponseBody
    public List<Role> getRoleData() {
        return userService.getRoleData();
    }
}
