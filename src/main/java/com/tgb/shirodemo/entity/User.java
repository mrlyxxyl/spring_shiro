package com.tgb.shirodemo.entity;

import java.io.Serializable;

public class User implements Serializable {

    private static final long serialVersionUID = -1373760761780840081L;
    private String userName;

    private String password;

    private String roleId;

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
