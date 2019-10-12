package cn.com.fovsoft.common.service;

import cn.com.fovsoft.common.bean.SysUser;
import cn.com.fovsoft.common.support.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;


@Component
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private SysUserService sysUserService;

    private SysUser sysUser;


    /**
     *功能描述：通过获取数据的用户信息来判断
     * @author tpc
     * @date 2019/10/11
     * @param userName
     * @return org.springframework.security.core.userdetails.UserDetails
     */
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        CustomUserDetails customUserDetails = new CustomUserDetails(sysUser);
        return customUserDetails;
    }

    public void setSysUser(SysUser sysUser){
        if(sysUser == null){
            throw new UsernameNotFoundException("UserName " + sysUser.getUserName() + " not found");
        }
        this.sysUser = sysUser;
    }

    public SysUser getSysUser(){
        return sysUser;
    }
}
