package com.tgb.shirodemo.manager;

import com.tgb.shirodemo.entity.User;
import com.tgb.shirodemo.shiroutils.DataSourceUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserManager {
    private User user;

    //根据用户名查询用户信息
    public User getUserByName(String username) {
        Connection conn = DataSourceUtils.getConnection();
        ResultSet rs = null;
        User user = null;
        PreparedStatement statement = null;
        try {
            statement = conn.prepareStatement("SELECT userName, userPsw, roleId FROM `user` WHERE userName = ?");
            statement.setString(1, username);
            rs = statement.executeQuery();
            if (rs.next()) {
                user = new User();
                user.setUserName(rs.getString("userName"));
                user.setPassword(rs.getString("userPsw"));
                user.setRoleId(rs.getString("roleId"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
