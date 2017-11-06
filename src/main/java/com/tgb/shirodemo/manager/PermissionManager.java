package com.tgb.shirodemo.manager;

import com.tgb.shirodemo.entity.Permission;
import com.tgb.shirodemo.entity.User;
import com.tgb.shirodemo.shiroutils.DataSourceUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PermissionManager {

    public List<Permission> getPermission(User user) {
        Connection conn = DataSourceUtils.getConnection();
        ResultSet rs = null;
        PreparedStatement statement = null;
        Permission permission;
        List<Permission> permissions = new ArrayList<Permission>();
        try {
            //根据用户对应的角色id,查询permission的id集合
            String sql = "SELECT p.permissionId, p.permissionName, p.permissionDesc FROM `user` u, permission p, rolepermission r WHERE p.permissionId = r.permissionId AND r.roleId = u.roleId AND u.roleId = ?";
            statement = conn.prepareStatement(sql);
            statement.setString(1, user.getRoleId());
            rs = statement.executeQuery();
            //取得权限信息
            while (rs.next()) {
                permission = new Permission();
                permission.setPermissionId(rs.getString("permissionId"));
                permission.setPermissionName(rs.getString("permissionName"));
                permission.setPermissionDesc(rs.getString("permissionDesc"));
                permissions.add(permission);
            }
        } catch (Exception e) {

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
        return permissions;
    }
}
