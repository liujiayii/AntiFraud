package com.antifraud.shiro;


import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.antifraud.entity.Popedom;
import com.antifraud.entity.User;
import com.antifraud.service.PopedomService;
import com.antifraud.service.UserService;

@Service("userRealm")
public class UserRealm extends AuthorizingRealm {
    
    @Autowired
    private UserService userService;	//用户的Service
    
    @Autowired
    private PopedomService popedomService;	//权限的Service
    
    /**
     * 认证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException{
    	System.out.println("shiro 认证管理... ");
    	//转换token
    	UsernamePasswordToken usernamePawworedToken = (UsernamePasswordToken) token;
    	
    	System.out.println("usernamePawworedToken"+usernamePawworedToken);
    	
    	//根据用户名查询用户信息
    	User user = userService.findUserByname(usernamePawworedToken.getUsername());
    	
    	System.out.println(user);
    	if(user == null){
    		//用户名不存在
    		System.out.println("用户名不存在");
    		//参数一：期望登陆后，保存在Subject中信息
    		//参数二：密码，如果返回null，说明用户不存在，报用户不存在异常
    		//参数三：realm名称
    		throw new AuthenticationException("用户名不存在");
    	} else {
    		if(user.getStatus()==1){
    			//用户名存在,状态=1，可用
    			//当返回用户密码是，securityManager安全管理器，自动比较返回密码和用户输入密码是否一致
    			//如果密码一致，登陆成功，密码不一致，报密码错误异常
    			System.out.println(user.getUser_pwd());
    			return new SimpleAuthenticationInfo(user, user.getUser_pwd(),getName());
    		}else{
    			//用户名存在,状态=2，不可用
    			return null;
    		}
    	}
    }

    /**
     * 授权
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection princ) {
    	System.out.println("授权 。。。");
    	
    	SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
    	//根据当前登录用户查询对应角色和权限
    	Subject subject = SecurityUtils.getSubject();
    	User user = (User) subject.getPrincipal();
    	//调用业务层，查询角色
    	List<User> byUser = userService.findByUser(user);     
    	for (User u : byUser) {
    		System.out.println("查询角色↓");
    		
			authorizationInfo.addRole(u.getKey_word());
			/*authorizationInfo.addRole(role.getRole_name());*/
			System.out.println(u.getKey_word());
			System.out.println(u.getUser_name());
		}
    	//调用业务层，查询权限
    	List<Popedom> popedoms = popedomService.findPopedomByUserId(user.getId());
    	for (Popedom popedom : popedoms) {
    		System.out.println("查询权限↓");
			authorizationInfo.addStringPermission(popedom.getPopedom_url());
			System.out.println(popedom.getPopedom_url());
		}
    	
    	System.out.println("authorizationInfo"+authorizationInfo);
        return authorizationInfo;
    }
}