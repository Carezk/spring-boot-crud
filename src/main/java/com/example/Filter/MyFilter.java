package com.example.Filter;

import javax.servlet.*;
import java.io.IOException;

public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest Request, ServletResponse Response, FilterChain Chain) throws IOException, ServletException {
        System.out.println("MyFilter process...");
        Chain.doFilter(Request,Response);
    }

    @Override
    public void destroy() {

    }
}
