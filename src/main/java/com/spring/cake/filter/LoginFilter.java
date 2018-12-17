package com.spring.cake.filter;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 登录过滤器，验证用户是否登录
 */
@Component
@Order(1002)
public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String sessionName = "user";
        String url = "user/login";
        String filter = ""; //这里写过滤的访问地址，用,间隔
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        //不过滤的uri
        String[] filters = filter.split(",");
        //请求的uri
        String uri = request.getRequestURI();
        //获取项目根路径
        String path = request.getContextPath() + "/";
        //是否过滤
        boolean doFilter = false;
        for (String s : filters) {
            if (!s.equals("")) {
                if (uri.contains(s)) {
                    //如果uri中包含过滤的uri则不进行过滤;
                    doFilter = true;
                    break;
                }
            }
        }
        //执行过滤
        if (doFilter) {
            //从session获取登录体实体
            if (request.getSession().getAttribute(sessionName) == null) {
                boolean isAjaxRequest = isAjaxRequest(request);
                if (isAjaxRequest) {
                    response.sendRedirect("/user/timeout");
                } else response.sendRedirect(path + url);
            } else filterChain.doFilter(request, response);
        } else filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }

    /**
     * 判断是否为Ajax请求
     *
     * @return 是true, 否false
     */
    private static boolean isAjaxRequest(HttpServletRequest request) {
        String header = request.getHeader("X-Requested-With");
        return "XMLHttpRequest".equals(header);
    }

}
