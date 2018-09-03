package com.example.Filteren;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyListeren implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("contextInitialized...web应用启动");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("contextInitialized...web应用销毁");
    }
}
