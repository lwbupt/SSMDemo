package com.ssmdemo.shiro;

import org.apache.log4j.Logger;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.ssmdemo.domain.User;
import com.ssmdemo.service.IUserService;

public class ShiroDbRealm extends AuthorizingRealm{
	
	private Logger logger = Logger.getLogger(ShiroDbRealm.class);
	@Autowired
	private IUserService userService;
	
	/**
	 * 授权
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
		// TODO Auto-generated method stub
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		return info;
	}

	/**
	 * 认证
	 * 登录时调用
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		// TODO Auto-generated method stub
		logger.info("--进入shiro 认证方法start--");
		//获取用户账号,密码
        String username = token.getPrincipal().toString();
        String password = new String((char[])token.getCredentials()); //得到密码
        User user = userService.findUserByName(username);
        
        //账号不存在
        if(user==null){
        	return null;
        }
        //将查询到的用户账号和密码存放到 authenticationInfo用于后面的权限判断。第三个参数传入realmName
    	//getName()方法，返回一个唯一的Realm名字，是继承的一个方法
/*不用写    	if(!user.getUsername().equals(username)){
    		throw new UnknownAccountException(); //用户名错误，抛出对应异常
    	}
    	if(!user.getPassword().equals(token.getCredentials())){
    		throw new IncorrectCredentialsException();//密码错误，抛出对应异常
    	}
*/    	//如果身份认证验证成功，返回一个AuthenticationInfo实现
        AuthenticationInfo info = new SimpleAuthenticationInfo(user.getUsername(),user.getPassword(),getName());
        logger.info("--进入shiro 认证方法end--");
        return info;
	}

}
