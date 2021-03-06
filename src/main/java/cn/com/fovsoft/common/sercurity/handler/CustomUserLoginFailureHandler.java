package cn.com.fovsoft.common.sercurity.handler;

import cn.com.fovsoft.common.constant.VarConstant;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: tpc
 * @date: 2019-10-14 11:50
 * @description:
 **/
@Component
public class CustomUserLoginFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    @Autowired
    private ObjectMapper objectMapper;
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        System.out.println("登陆失败的错误信息："+exception.getMessage());
        Map<String,Object> map=new HashMap<>();
        //比对数据库进行验证，如果数据库中没有该用户，返回错误信息
        if(exception.getMessage().equals("not have this user")){
            response.setContentType("application/json;charset=utf-8");
            map.put("status",0);
            map.put("result","nouser");
            response.getWriter().write(objectMapper.writeValueAsString(map));
            response.getWriter().flush();
            response.getWriter().close();
//            out.write("{\"status\":0,\"result\":\"nouser\"}");
//            out.flush();
//            out.close();
            //获取密码错误异常，通过json返回密码错误状态数据
        }else if(exception.getMessage().equals("password error")){
            response.setContentType("application/json;charset=utf-8");
            map.put("status",0);
            map.put("result","errorpwd");
            response.getWriter().write(objectMapper.writeValueAsString(map));
            response.getWriter().flush();
            response.getWriter().close();
            //获取验证码错误异常，通过json返回验证码错误状态数据
        }else if(exception.getMessage().equals("verifycode error")){
            String sessionCode = (String)request.getSession().getAttribute(VarConstant.SESSION_VERIFY_CODE);
            response.setContentType("application/json;charset=utf-8");
            map.put("status",0);
            map.put("result","codeerror");
            response.getWriter().write(objectMapper.writeValueAsString(map));
            response.getWriter().flush();
            response.getWriter().close();
            sessionCode = (String)request.getSession().getAttribute(VarConstant.SESSION_VERIFY_CODE);
        }else if(exception.getMessage().equals("user stop use")){
            response.setContentType("application/json;charset=utf-8");
            map.put("status",0);
            map.put("result","stopUse");
            response.getWriter().write(objectMapper.writeValueAsString(map));
            response.getWriter().flush();
            response.getWriter().close();
        }



    }


}
