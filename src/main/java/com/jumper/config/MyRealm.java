package com.jumper.config;

import com.jumper.pojo.Role;
import com.jumper.pojo.UserLogin;
import com.jumper.service.RoleService;
import com.jumper.service.UserLoginService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;


public class MyRealm extends AuthorizingRealm {
    
    @Autowired
    UserLoginService userLoginService;

    @Autowired
    RoleService roleService;

    //用于授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        //获得SimpleAuthenticationInfo(Object principal, Object credentials, String realmName)中的principal
        String username = (String) principalCollection.getPrimaryPrincipal();
        //查询该用户的角色
        UserLogin user = userLoginService.selectUserLoginByName(username);
        Role role = roleService.selectRoleByID(user.getRole());
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.addRole(role.getRoleName());
        return simpleAuthorizationInfo;
    }

    //用于身份认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = (String) token.getPrincipal();
        UserLogin user = userLoginService.selectUserLoginByName(username);

        //查询不到用户则抛出异常
        if (user == null) {
            throw new UnknownAccountException();
        }

        //将查询出的用户存入info中返回，其中SimpleAuthenticationInfo(Object principal, Object credentials, String realmName)
        //,principal将继续传递,credentials存入数据库查询到的密码交给shiro之后与token中的密码进行比对
        //也可以自己在此方法中进行密码验证
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user.getUserName(),user.getPassword(),getName());
        return info;
    }
}
