package cn.com.fovsoft.common.service.security;

import cn.com.fovsoft.common.util.VerifyStringEmpty;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;



public class CustomUsernamePasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter {



   // private ThreadLocal<Map<String,String>> threadLocal = new ThreadLocal<>();


    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        if (request.getContentType().equals(MediaType.APPLICATION_JSON_UTF8_VALUE)
                || request.getContentType().equals(MediaType.APPLICATION_JSON_VALUE)) {
            ObjectMapper mapper = new ObjectMapper();
            UsernamePasswordAuthenticationToken authRequest = null;
            try (InputStream is = request.getInputStream()) {
            Map<String,String> authenticationBean = mapper.readValue(is, Map.class);
            System.out.println("认证用户名："+authenticationBean.get("username"));
            authRequest = new UsernamePasswordAuthenticationToken(
            authenticationBean.get("username"), authenticationBean.get("password"));
            } catch (IOException e) {
            e.printStackTrace();
            authRequest = new UsernamePasswordAuthenticationToken("", "");
            } finally {
            setDetails(request, authRequest);
            return this.getAuthenticationManager().authenticate(authRequest);
            }
        } else {
            return super.attemptAuthentication(request, response);
            }
    }

//    @Override
//    protected String obtainPassword(HttpServletRequest request) {
//        String password = this.getBodyParams(request).get(super.SPRING_SECURITY_FORM_PASSWORD_KEY);
//        if(!VerifyStringEmpty.isEmpty(password)){
//            return password;
//        }
//        return super.obtainPassword(request);
//    }
//
//    @Override
//    protected String obtainUsername(HttpServletRequest request) {
//        String username = this.getBodyParams(request).get(super.SPRING_SECURITY_FORM_USERNAME_KEY);
//        if(!VerifyStringEmpty.isEmpty(username)){
//            return username;
//        }
//        return super.obtainUsername(request);
//    }
//
//    private Map<String,String>getBodyParams(HttpServletRequest request)  {
//        System.out.println(threadLocal.get());
//        Map<String,String> bodyParams =  threadLocal.get();
//
//        System.out.println(threadLocal.get());
//        if(bodyParams==null) {
//            ObjectMapper objectMapper = new ObjectMapper();
//            try (InputStream is = request.getInputStream()) {
//                bodyParams = objectMapper.readValue(is, Map.class);
//            } catch (IOException e) {
//            }
//            if(bodyParams==null) bodyParams = new HashMap<>();
//            threadLocal.set(bodyParams);
//        }
//        return bodyParams;
//    }



}
