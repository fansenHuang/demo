package com.system.controller;

import com.system.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * <p>登录相关操作接口定义类</p>
 *
 * @author liwei
 **/
@Controller
@Api(description = "新闻相关操作接口定义类")
public class LoginController{

    /**
     * 登录页面跳转
     * @return  url
     */
    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @ApiOperation(value = "登录")
    @RequestMapping("/loginUser")
    public String loginUser(Map<String, Object> map,String username,String password,HttpSession session,Model model) {
        //授权认证
    	System.out.println("LoginController.loginUser()"+username+password);
        UsernamePasswordToken usernamePasswordToken=new UsernamePasswordToken(username,password);
        Subject subject = SecurityUtils.getSubject();
        try {
            //完成登录
            subject.login(usernamePasswordToken);
            //获得用户对象
            User user=(User) subject.getPrincipal();
            //存入session
            session.setAttribute("user", user);
            map.put("user", user);
            return "index";
        } catch(AuthenticationException e) {
        	//用户名或密码错误
        	model.addAttribute("msg", "用户名或密码错误");
            //返回登录页面
            return "login";
        }
        
    }

    @ApiOperation(value = "退出")
    @RequestMapping("/logOut")
    public String logOut(HttpSession session) {
    	session.removeAttribute("user");
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "login";
    }
}
