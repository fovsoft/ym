package cn.com.fovsoft.common.support;

import cn.com.fovsoft.common.bean.SysMenuPermission;
import cn.com.fovsoft.common.bean.SysRole;
import cn.com.fovsoft.common.bean.SysUser;
import cn.com.fovsoft.common.dao.SysMenuPermissionDao;
import cn.com.fovsoft.common.service.SysMenuPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

public class CustomUserDetails extends SysUser implements UserDetails {





    @Autowired
    private SysMenuPermissionService sysMenuPermissionService;



    /**
     *功能描述:封装构造函数
     * @author tpc
     * @date 2019/10/11
     * @param sysUser
     * @return
     */

    public CustomUserDetails(SysUser sysUser){
        if (sysUser != null){
            this.setUserid(sysUser.getUserid());
            this.setUsername(sysUser.getUsername());
            this.setPassword(sysUser.getPassword());
            this.setDepartment(sysUser.getDepartment());
            this.setSex(sysUser.getSex());
            this.setBirthday(sysUser.getBirthday());
            this.setSfzmhm(sysUser.getSfzmhm());
            this.setEmail(sysUser.getEmail());
            this.setIpks(sysUser.getIpks());
            this.setIpjs(sysUser.getIpjs());
            this.setZhyxq(sysUser.getZhyxq());
            this.setMmyxq(sysUser.getMmyxq());
            this.setYhlx(sysUser.getYhlx());
            this.setLxdh(sysUser.getLxdh());
            this.setZjdlip(sysUser.getZjdlip());
            this.setZt(sysUser.getZt());
            this.setCjsj(sysUser.getCjsj());
            this.setGxsj(sysUser.getGxsj());
            this.setSysRoleSet(sysUser.getSysRoleSet());
        }
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    /**
     *功能描述: 重写权限控制方法，把用户角色写入
     * @author tpc
     * @date 2019/10/11
     * @param
     * @return java.util.Collection<? extends org.springframework.security.core.GrantedAuthority>
     */
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//
//        Collection<GrantedAuthority> authorities = new ArrayList<>();
//        Set<SysRole> sysRoleSet = this.getSysRoleSet();
//        if(this.getUsername() !=null){
//            //根据用户id拿到权限信息
//            Set<SysMenuPermission> sysMenuPermissionSet = sysMenuPermissionService.findMenuPermissionByUserId(this.getUserid());
//            //把权限信息写入到权限认证集中
//            for(SysMenuPermission sysMenuPermission:sysMenuPermissionSet){
//                //加入格式为url-permission
//                SimpleGrantedAuthority authority = new SimpleGrantedAuthority(String.format("%s-%s",sysMenuPermission.getUrl(),sysMenuPermission.getPermission()));
//                authorities.add(authority);
//            }
//        }
//
//        return authorities;
//    }




    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        if(getZt().equals("2")){
            return false;
        }
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
