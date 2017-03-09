package com.tgb.shirodemo.servlet;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("userName");
        String psw = req.getParameter("password");

        UsernamePasswordToken token = new UsernamePasswordToken(userName, psw);
        token.setRememberMe(true);

        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
            req.getRequestDispatcher("page/main.jsp").forward(req, resp);
        } catch (UnknownAccountException e) {
            System.out.println("用户不存在");
            req.getRequestDispatcher("page/login.jsp").forward(req, resp);
        } catch (IncorrectCredentialsException e) {
            System.out.println("用户密码不正确");
            req.getRequestDispatcher("page/login.jsp").forward(req, resp);
        }
    }
}
