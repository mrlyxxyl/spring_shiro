<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>main</title>
</head>
<body>
<form action="money" method="post">
    <%--后台登录失败的话，就是游客--%>
    <shiro:guest>我是游客</shiro:guest>
    <%--后台登录成功的话，就是用户--%>
    <shiro:user>我是用户</shiro:user>

    <shiro:hasPermission name="user:add">
        <input type="submit" value="user:add">
    </shiro:hasPermission>
    <shiro:hasPermission name="user:del">
        <input type="submit" value="user:del">
    </shiro:hasPermission>
    <shiro:hasPermission name="user:update">
        <input type="submit" value="user:update">
    </shiro:hasPermission>
    <shiro:hasPermission name="user:query">
        <input type="submit" value="user:query">
    </shiro:hasPermission>
</form>
</body>
</html>