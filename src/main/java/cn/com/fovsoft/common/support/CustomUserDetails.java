package cn.com.fovsoft.common.support;

import cn.com.fovsoft.common.bean.SysRole;
import cn.com.fovsoft.common.bean.SysUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

public class CustomUserDetails extends SysUser implements UserDetails {




    /**
     *功能描述:封装构造函数
     * @author tpc
     * @date 2019/10/11
     * @param sysUser
     * @return
     */

    public CustomUserDetails(SysUser sysUser){
        if (sysUser != null){
            this.setUserId(sysUser.getUserId());
            this.setUserName(sysUser.getUserName());
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

    /**
     *功能描述: 重写权限控制方法，把用户角色写入
     * @author tpc
     * @date 2019/10/11
     * @param
     * @return java.util.Collection<? extends org.springframework.security.core.GrantedAuthority>
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        Collection<GrantedAuthority> authorities = new ArrayList<>();
        Set<SysRole> sysRoleSet = this.getSysRoleSet();
        if(sysRoleSet != null){
            for (SysRole sysRole:sysRoleSet){
                SimpleGrantedAuthority authority = new SimpleGrantedAuthority(sysRole.getRoleName());
                authorities.add(authority);
            }
        }

        return authorities;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
