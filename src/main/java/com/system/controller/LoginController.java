package com.system.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.system.entity.User;

import java.util.Map;

import javax.servlet.http.HttpSession;

/**
 * 登陆有关
 * @author wendong
 *
 * 2019年2月22日
 */
@Controller
public class LoginController {
	
    @RequestMapping("/login")
    public String login() {
        return "login";
    }

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
        	
            return "login";
        }
        
    }
    
    @RequestMapping("/logOut")
    public String logOut(HttpSession session) {
    	
    	session.removeAttribute("user");
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "login";
        
    }
}
