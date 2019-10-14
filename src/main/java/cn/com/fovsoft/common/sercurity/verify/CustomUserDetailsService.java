package cn.com.fovsoft.common.sercurity.verify;

import cn.com.fovsoft.common.bean.SysUser;
import cn.com.fovsoft.common.service.SysUserService;
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


    /**
     *功能描述：通过获取数据的用户信息来判断
     * @author tpc
     * @date 2019/10/11
     * @param userName
     * @return org.springframework.security.core.userdetails.UserDetails
     */
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        System.out.println("前端需要验证的用户名为："+userName);
        SysUser sysUser = sysUserService.findByUserName(userName);

        if(sysUser == null){
            throw new UsernameNotFoundException("not have this user");
        }else{

        }
        System.out.println("数据库取出的用户名为："+sysUser.getUsername());
        CustomUserDetails customUserDetails = new CustomUserDetails(sysUser);
        return customUserDetails;
    }


}
