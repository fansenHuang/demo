package com.system.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.system.entity.User;
import com.system.service.UserService;

import java.util.Set;

public class AuthRealm extends AuthorizingRealm {

	@Autowired
	private UserService userService;

	// 认证.登录
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		
		// 将token进行格式转化
		UsernamePasswordToken loginToken = (UsernamePasswordToken) token;
		String userName = loginToken.getUsername();

		// 根据用户名查询用户的真实信息
		User user = userService.findUserByUserName(userName);
		/**
		 * principal 真实的用户对象 credentials 真实的密码
		 */

		AuthenticationInfo info = new SimpleAuthenticationInfo(user, user.getPassword(), this.getName());

		return info; // 通过info对象返回给安全管理器
	}

	// 授权
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
		
		User user = (User) SecurityUtils.getSubject().getPrincipal();
		// 准备用户的真实的模块信息
		Set<String> moduleList = userService.findModuleListById(user.getID().toString());

		// 权限认证的对象
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

		// 将用户的权限信息 提交给Shiro安全管理器
		info.addStringPermissions(moduleList);
		return info;

	}
}