package cn.com.fovsoft.common.config;

import cn.com.fovsoft.common.bean.SysRole;
import cn.com.fovsoft.common.service.CustomUserDetailsService;
import cn.com.fovsoft.common.service.SysUserService;
import cn.com.fovsoft.common.service.security.CustomAuthenticationFailureHandler;
import cn.com.fovsoft.common.service.security.CustomAuthenticationSuccessHandler;
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
    private CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler;

    @Autowired
    private CustomAuthenticationFailureHandler customAuthenticationFailureHandler;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //super.configure(http);
        http
                .formLogin().loginPage("/login-page").loginProcessingUrl("/login").failureUrl("/login-error").permitAll()
                .and()
                .authorizeRequests()
                .antMatchers("/global/**","/static/**","/templates/**").permitAll()
                .antMatchers("/", "/login","/code","/loginCheck").permitAll()
                .antMatchers("/index").permitAll()
                .anyRequest().authenticated()
                .and()
                .csrf().disable();
        http.addFilterAt(CustUsernamePasswordAuthenticationFilterBean(), UsernamePasswordAuthenticationFilter.class);


        http
                .logout().permitAll();
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //super.configure(auth);
        //auth.userDetailsService();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        //指定密码加密所使用的加密器为passwordEncoder()
        //需要将密码加密后写入数据库
        auth.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder());
        auth.eraseCredentials(false);
    }


    public CustomUsernamePasswordAuthenticationFilter CustUsernamePasswordAuthenticationFilterBean() throws Exception {
        CustomUsernamePasswordAuthenticationFilter customUsernamePasswordAuthenticationFilter = new CustomUsernamePasswordAuthenticationFilter();
        customUsernamePasswordAuthenticationFilter.setAuthenticationManager(super.authenticationManager());
        customUsernamePasswordAuthenticationFilter.setAuthenticationSuccessHandler(customAuthenticationSuccessHandler);
        return customUsernamePasswordAuthenticationFilter;
    }

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
