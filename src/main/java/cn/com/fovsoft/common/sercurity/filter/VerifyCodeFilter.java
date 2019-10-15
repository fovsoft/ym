package cn.com.fovsoft.common.sercurity.filter;

import cn.com.fovsoft.common.constant.VarConstant;
import cn.com.fovsoft.common.sercurity.exception.VerifyCodeAuthenticationException;
import cn.com.fovsoft.common.sercurity.handler.CustomUserLoginFailureHandler;
import cn.com.fovsoft.common.sercurity.handler.CustomUserLoginSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author tpc
 * @date 2019-10-14 21:14
 * description: 添加图像验证码过滤器
 */

@Component
public class VerifyCodeFilter extends OncePerRequestFilter {

    @Autowired
    private CustomUserLoginFailureHandler customUserLoginFailureHandler;
    //继承父类的方法，进行重写
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        System.out.println(request.getRequestURI()+"   "+ request.getMethod());
        //判断主页请求
        if(request.getRequestURI().equals("/login")&&request.getMethod().equalsIgnoreCase("post")){

            try{
                //进行验证码判断
                validate(request);
            }catch (VerifyCodeAuthenticationException e){
                customUserLoginFailureHandler.onAuthenticationFailure(request,response,e);
            }
        }
        // 3. 校验通过，就放行
        filterChain.doFilter(request, response);
    }

    private void validate(HttpServletRequest request){
        //获取输入验证码
        String code = request.getParameter("ccode");
        //获取时间戳
        String tm = request.getParameter("tm");
        //获取session中的验证码
        String sessionVerifyCode = (String)request.getSession().getAttribute(VarConstant.SESSION_VERIFY_CODE);
        //判断是否相等
        if(!code.equalsIgnoreCase(sessionVerifyCode)){
            throw new VerifyCodeAuthenticationException("verifycode error");
        }
        request.getSession().removeAttribute(VarConstant.SESSION_VERIFY_CODE);
    }
}
