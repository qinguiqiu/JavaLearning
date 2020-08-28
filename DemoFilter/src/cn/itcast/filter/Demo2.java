package cn.itcast.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/*")
public class Demo2 implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("filter demo2.....");

        chain.doFilter(req, resp);

        System.out.println("filter demo2.....回");

    }

    public void init(FilterConfig config) throws ServletException {

    }

}
