package org.anson.miniproduct.framework.filter;

import org.anson.miniproduct.framework.req.RequestHelper;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;
import java.util.Date;

@Component
@Order(1)
public class HttpFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 在ThreadLocal中添加请求时间
        RequestHelper.setReqTimeToThreadLocal(new Date());
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void destroy() {
        RequestHelper.removeReqTimeFromThreadLocal();
    }
}
