package cn.com.fovsoft.common.sercurity.config;

import cn.com.fovsoft.common.sercurity.authorization.CustomAuthenticationProvider;
import cn.com.fovsoft.common.sercurity.filter.VerifyCodeFilter;
import cn.com.fovsoft.common.sercurity.handler.CustomUserLoginFailureHandler;
import cn.com.fovsoft.common.sercurity.handler.CustomUserLoginSuccessHandler;
import cn.com.fovsoft.common.sercurity.verify.UnAuthorizedEntryPoint;
import cn.com.fovsoft.common.sercurity.verify.CustomUserDetailsService;

import cn.com.fovsoft.common.service.security.CustomUsernamePasswordAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Autowired
    private CustomUserLoginSuccessHandler customUserLoginSuccessHandler;

    @Autowired
    private CustomUserLoginFailureHandler customUserLoginFailureHandler;

    @Autowired
    private UnAuthorizedEntryPoint unAuthorizedEntryPoint;

    @Autowired
    private CustomAuthenticationProvider customAuthenticationProvider;


    //验证码过滤器
    @Autowired
    private VerifyCodeFilter verifyCodeFilter;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //super.configure(http);
        http
                .authorizeRequests()
                .antMatchers("/global/**","/static/**","/templates/**").permitAll()
                .antMatchers("/login","/login_page","/code").permitAll()
                //主页放行
                .antMatchers("/index").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .successHandler(customUserLoginSuccessHandler)
                .failureHandler(customUserLoginFailureHandler)
                .loginProcessingUrl("/login")
                .and()
                .csrf().disable();

        http.exceptionHandling().authenticationEntryPoint(unAuthorizedEntryPoint);
        //http.addFilterAt(CustUsernamePasswordAuthenticationFilterBean(), UsernamePasswordAuthenticationFilter.class);
        http.addFilterBefore(verifyCodeFilter,UsernamePasswordAuthenticationFilter.class).formLogin();

        http
                .logout().permitAll();
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //super.configure(auth);
        //auth.userDetailsService();
        auth.authenticationProvider(customAuthenticationProvider);
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        //指定密码加密所使用的加密器为passwordEncoder()
        //需要将密码加密后写入数据库
        auth.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder());
        auth.eraseCredentials(false);
    }


//    @Bean
//    public CustomUsernamePasswordAuthenticationFilter CustUsernamePasswordAuthenticationFilterBean() throws Exception {
//        CustomUsernamePasswordAuthenticationFilter customUsernamePasswordAuthenticationFilter = new CustomUsernamePasswordAuthenticationFilter();
//        customUsernamePasswordAuthenticationFilter.setAuthenticationManager(super.authenticationManager());
//        customUsernamePasswordAuthenticationFilter.setAuthenticationSuccessHandler(customAuthenticationSuccessHandler);
//        customUsernamePasswordAuthenticationFilter.setAuthenticationFailureHandler(customAuthenticationFailureHandler);
//        return customUsernamePasswordAuthenticationFilter;
//    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


    @Bean
    public SessionRegistry getSessionRegistry(){
        SessionRegistry sessionRegistry = new SessionRegistryImpl();
        return  sessionRegistry;
    }

    public static void main(String[] args) {
        System.out.println(new BCryptPasswordEncoder().encode("123456"));
    }



}
