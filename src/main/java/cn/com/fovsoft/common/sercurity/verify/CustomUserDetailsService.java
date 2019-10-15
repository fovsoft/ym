package cn.com.fovsoft.common.sercurity.verify;

import cn.com.fovsoft.common.bean.SysMenuPermission;
import cn.com.fovsoft.common.bean.SysUser;
import cn.com.fovsoft.common.service.SysMenuPermissionService;
import cn.com.fovsoft.common.service.SysUserService;
import cn.com.fovsoft.common.support.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;


@Component
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    SysMenuPermissionService sysMenuPermissionService;


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
        }
        Collection<GrantedAuthority> authorities = new ArrayList<>();
            //根据用户id拿到权限信息
        Set<SysMenuPermission> sysMenuPermissionSet = sysMenuPermissionService.findMenuPermissionByUserId(sysUser.getUserid());
        //把权限信息写入到权限认证集中
        for(SysMenuPermission sysMenuPermission:sysMenuPermissionSet){
            //加入格式为url-permission
            SimpleGrantedAuthority authority = new SimpleGrantedAuthority(String.format("%s-%s",sysMenuPermission.getUrl(),sysMenuPermission.getPermission()));
            authorities.add(authority);
        }

        System.out.println("数据库取出的用户名为："+sysUser.getUsername());
        CustomUserDetails customUserDetails = new CustomUserDetails(sysUser);
        User user = new User(sysUser.getUsername(),sysUser.getPassword(),true,true,true,true,authorities);
        return user;
    }


}
