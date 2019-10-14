package cn.com.fovsoft.common.sercurity.handler;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author: tpc
 * @date: 2019-10-14 11:56
 * @description: 新增登陆成功验证，并返回前端成功json
 **/
public class CustomUserLoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {
        //super.onAuthenticationSuccess(request, response, authentication);

        response.setContentType("application/json:charset=utf-8");
        response.getWriter().write("123");
    }
}
