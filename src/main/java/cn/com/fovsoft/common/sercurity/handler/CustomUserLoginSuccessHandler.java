package cn.com.fovsoft.common.sercurity.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: tpc
 * @date: 2019-10-14 11:56
 * @description: 新增登陆成功验证，并返回前端成功json
 **/

@Component
public class CustomUserLoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {


    //json封装对象
    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {
        //super.onAuthenticationSuccess(request, response, authentication);

        //封装登录认证成功的json信息
        Map<String,Object> map=new HashMap<>();

        response.setContentType("application/json:charset=utf-8");
        map.put("status",1);
        map.put("result","success");
        response.getWriter().write(objectMapper.writeValueAsString(map));
        response.getWriter().flush();
        response.getWriter().close();
    }
}
