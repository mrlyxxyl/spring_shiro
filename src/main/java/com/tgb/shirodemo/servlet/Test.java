package com.tgb.shirodemo.servlet;

import org.apache.shiro.authz.annotation.RequiresPermissions;


public class Test {

    @RequiresPermissions("user:del")
    public void del() {
        System.out.println("user:del");
    }

    @RequiresPermissions("user:add")
    public void add() {
        System.out.println("user:add");
    }

    @RequiresPermissions("user:update")
    public void update() {
        System.out.println("user:update");
    }

    @RequiresPermissions("user:query")
    public void query() {
        System.out.println("user:query");
    }

}
