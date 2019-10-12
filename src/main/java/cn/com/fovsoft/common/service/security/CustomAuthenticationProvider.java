package cn.com.fovsoft.common.service.security;

import cn.com.fovsoft.common.service.CustomUserDetailsService;
import cn.com.fovsoft.common.support.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author: tpc
 * @date: 2019-10-11 20:51
 * @description:
 **/
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private CustomUserDetailsService customUserDetailsService;
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        //获取表单中用户名
        String userName = authentication.getName();
        //获取表单中密码
        String password = (String)authentication.getPrincipal();
        //这里构建用户是否存在，密码是否正确
        CustomUserDetails customUserDetails = (CustomUserDetails)customUserDetailsService.loadUserByUsername(userName);

        //如果不存在，抛出异常
        if(customUserDetails == null){
            throw new BadCredentialsException("用户名不存在");
        }
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return false;
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
