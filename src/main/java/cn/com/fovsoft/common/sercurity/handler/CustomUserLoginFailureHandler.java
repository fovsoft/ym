package cn.com.fovsoft.common.sercurity.handler;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author: tpc
 * @date: 2019-10-14 11:50
 * @description:
 **/
@Component
public class CustomUserLoginFailureHandler extends SimpleUrlAuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        if(exception.getMessage().equals("用户不存在"))
            response.setContentType("application/json;charset=utf-8");
        PrintWriter out = response.getWriter();

    }
}
