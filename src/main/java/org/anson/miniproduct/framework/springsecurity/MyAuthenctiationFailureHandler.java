package org.anson.miniproduct.framework.springsecurity;


import org.anson.miniproduct.framework.jackson.Jackson;
import org.anson.miniproduct.framework.res.ResHelper;
import org.anson.miniproduct.framework.res.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@Component
public class MyAuthenctiationFailureHandler extends SimpleUrlAuthenticationFailureHandler {
    @Autowired
    private Jackson jackson;

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        Response res = ResHelper.ok("登录失败", new Date());
        response.setContentType("application/json;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.write(jackson.toJson(res));
        out.flush();
        out.close();
    }
}
