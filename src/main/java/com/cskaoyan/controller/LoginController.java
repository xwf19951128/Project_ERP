package com.cskaoyan.controller;

import com.cskaoyan.bean.SysUser;
import com.cskaoyan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
public class LoginController {

    @Autowired
    UserService userService;

    //每次重启服务器，自动打开浏览器时就会访问这个方法。让它跳转到登录页面
    @RequestMapping("/")
    public String index(){
        return "/WEB-INF/jsp/login.jsp";
    }

    //需要登录时，通过此方法跳转到登录页面
    @RequestMapping("/login")
    public String login(){
        return "/WEB-INF/jsp/login.jsp";
    }

    //此方法用来处理登陆按钮发送的ajax请求
    @RequestMapping("/ajaxLogin")  //这是login页面中ajax请求指定的url名字
    @ResponseBody //需要把返回值类型设为Jason
    //因为只在这里使用一次，所以不用新建JavaBean，直接用Map存储处理结果作为Jason返回值
    //因为ajax发过来的是Jason请求，所以需要用@RequestBody注解，用Jason格式接收请求参数

    public Map<String, String> ajaxLogin(@RequestBody SysUser user, HttpServletRequest request) throws IOException {
        HashMap<String, String> data = new HashMap<>();
        //根据用户名去数据表中查询，如果结果为null，说明用户名错误，给msg赋相应的值，返回map给前端
        SysUser sysUser1 = userService.queryUserByUsername(user.getUsername());
        if (sysUser1==null){
            data.put("msg","account_error");
            return data;
        }
        //如果程序运行到这里，说明用户名没有问题，之后
        //根据用户名和密码去数据表中查询，如果结果为null，说明密码错误，给msg赋相应的值，返回map给前端
        SysUser sysUser2 = userService.queryUserByUsernameAndPassword(user);
        if (sysUser2==null){
            data.put("msg","password_error");
            return data;
        //如果用户名和密码都正确，还要判断账号是否被锁定，如果locked为1就返回对应的错误信息
        }else if (sysUser2.getLocked() == '1'){
            data.put("msg","authentication_error");
            return data;
        }
        //最后还要判断用户输入的验证码是否和session中存储的相同
        String validateCode = (String) request.getSession().getAttribute("validateCode");
        if (user.getRandomcode()!=null & !user.getRandomcode().equals(validateCode)){
            data.put("msg","randomcode_error");
            return data;
        }
        //如果程序成功运行到这里，说明登录一切顺利，跳转到主页
        data.put("msg","success");
        //返回Json格式的Map对象
        return data;
    }

    //登录成功后，跳转到home页面
    @RequestMapping("/home")
    public String home(){
        return "/WEB-INF/jsp/home.jsp";
    }
}