package com.system.shiro;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;

import com.core.util.MD5Hash;

public class CredentialsMatcher extends SimpleCredentialsMatcher {

	// 校验
	@Override
	public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {

		UsernamePasswordToken logintoken = (UsernamePasswordToken) token;
		String userName = logintoken.getUsername();
		char[] password = logintoken.getPassword();

		// 生成加密后的密码
		String md5Password = MD5Hash.getMd5HashPasswod(String.valueOf(password), userName);

		// 将加密后的密码存入token中
		logintoken.setPassword(md5Password.toCharArray());

		return super.doCredentialsMatch(logintoken, info);
	}
}