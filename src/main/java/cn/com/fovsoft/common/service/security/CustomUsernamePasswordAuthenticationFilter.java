package cn.com.fovsoft.common.service.security;

import cn.com.fovsoft.common.util.VerifyStringEmpty;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class CustomUsernamePasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private ThreadLocal<Map<String,String>> threadLocal = new ThreadLocal<>();
    @Override
    protected String obtainPassword(HttpServletRequest request) {
        String password = this.getBodyParams(request).get(super.SPRING_SECURITY_FORM_PASSWORD_KEY);
        if(!VerifyStringEmpty.isEmpty(password)){
            return password;
        }
        return super.obtainPassword(request);
    }

    @Override
    protected String obtainUsername(HttpServletRequest request) {
        String username = this.getBodyParams(request).get(super.SPRING_SECURITY_FORM_USERNAME_KEY);
        if(!VerifyStringEmpty.isEmpty(username)){
            return username;
        }
        return super.obtainUsername(request);
    }

    private Map<String,String>getBodyParams(HttpServletRequest request)  {
        System.out.println(threadLocal.get());
        Map<String,String> bodyParams =  threadLocal.get();

        System.out.println(threadLocal.get());
        if(bodyParams == null){
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                InputStream is = request.getInputStream();
                bodyParams = objectMapper.readValue(is, Map.class);
            } catch (IOException e) {
                e.printStackTrace();
            }
            if(bodyParams==null) bodyParams = new HashMap<>();
            threadLocal.set(bodyParams);

        }
        return bodyParams;
    }
}
