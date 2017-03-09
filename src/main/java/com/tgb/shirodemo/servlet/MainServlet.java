package com.tgb.shirodemo.servlet;

import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class MainServlet extends HttpServlet {

    private static final long serialVersionUID = 11L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //从context中的依赖关系取得spring管理的bean
        ServletContext servletContext = this.getServletContext();
        WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(servletContext);
        Test test = (Test) context.getBean("test");
        try {
            test.add();
        } catch (UnauthorizedException e) {
            System.out.println("no add");
        }

        try {
            test.del();
        } catch (UnauthorizedException e) {
            System.out.println("no del");
        }

        try {
            test.update();
        } catch (UnauthorizedException e) {
            System.out.println("no update");
        }

        try {
            test.query();
        } catch (UnauthorizedException e) {
            System.out.println("no query");
        }
    }
}
