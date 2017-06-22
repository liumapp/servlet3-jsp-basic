package com.liumapp.servlet3jspbasic.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * Created by liumapp on 6/22/17.
 * E-mail:liumapp.com@gmail.com
 * home-page:http://www.liumapp.com
 */
@WebFilter(filterName = "AsyncFilter" , value = {"/servlet/AsyncServlet"} , dispatcherTypes = {DispatcherType.ASYNC , DispatcherType.REQUEST} , asyncSupported = true)
public class AsyncFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("AsyncFilter started");
        filterChain.doFilter(servletRequest , servletResponse);
        System.out.println("AsyncFilter ended");
    }

    public void destroy() {

    }
}
