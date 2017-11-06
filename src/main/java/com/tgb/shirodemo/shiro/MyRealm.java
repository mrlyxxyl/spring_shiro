package com.tgb.shirodemo.shiro;

import com.tgb.shirodemo.entity.Permission;
import com.tgb.shirodemo.entity.User;
import com.tgb.shirodemo.manager.PermissionManager;
import com.tgb.shirodemo.manager.UserManager;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.Iterator;
import java.util.List;

public class MyRealm extends AuthorizingRealm {

    //注入的类，真正的去访问数据库
    private UserManager userManager;

    private PermissionManager permissionManager;

    //查询用户的权限信息
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        User user = (User) principals.fromRealm(getName()).iterator().next();
        List<Permission> list = permissionManager.getPermission(user);
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        Iterator<Permission> it = list.iterator();
        while (it.hasNext()) {
            info.addStringPermission(it.next().getPermissionName());
        }
        return info;
    }

    //查询用户的身份信息
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = token.getPrincipal().toString();
        String password = new String((char[]) token.getCredentials());
        User user = userManager.getUserByName(username, password);
        if (user == null) {
            throw new UnknownAccountException();
        } else {
            return new SimpleAuthenticationInfo(user, user.getPassword(), getName());
        }
    }

    public UserManager getUserManager() {
        return userManager;
    }

    public void setUserManager(UserManager userManager) {
        this.userManager = userManager;
    }

    public PermissionManager getPermissionManager() {
        return permissionManager;
    }

    public void setPermissionManager(PermissionManager permissionManager) {
        this.permissionManager = permissionManager;
    }
}
