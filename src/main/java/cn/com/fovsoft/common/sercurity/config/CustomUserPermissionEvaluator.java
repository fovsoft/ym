package cn.com.fovsoft.common.sercurity.config;

import cn.com.fovsoft.common.bean.SysUser;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Collection;

/**
 * @author: by tpc
 * @date: 2019/10/15 16:51
 * @description: 对权限进行处理
 **/

@Configuration
public class CustomUserPermissionEvaluator implements PermissionEvaluator {

    /**
     * 描述 ：实现接口函数，完成权限认证
     * @param authentication     represents the user in question. Should not be null.
     * @param targetUrl the domain object for which permissions should be
     *                           checked. May be null in which case implementations should return false, as the null
     *                           condition can be checked explicitly in the expression.
     * @param permission         a representation of the permission object as supplied by the
     *                           expression system. Not null.
     * @return true if the permission is granted, false otherwise
     */
    @Override
    public boolean hasPermission(Authentication authentication, Object targetUrl, Object permission) {

        boolean accessable  = false;
        //获取认证通过的用户信息
        User user = (User) authentication.getPrincipal();
        // 获得loadUserByUsername()中注入的角色
        Collection<GrantedAuthority> authorities = user.getAuthorities();
        //遍历所有权限信息
        for(GrantedAuthority authority : authorities) {
            //获得菜单和权限拼接信息
            String menuPermissionStr = authority.getAuthority();
            //strArray总共有9个元素，分别对应 菜单id-菜单父id-菜单名字-菜单css-菜单url-菜单类型-权限-排序-状态
            String[] strArray = menuPermissionStr.split(",");
            //判断是否有权限
            boolean havePrivs = false;
            String[] permissionArray = strArray[6].split(",");
            for(String s : permissionArray){
                if (s.equals(permission.toString())){
                    havePrivs = true;
                }
            }
            //进行url和权限判断
            if(targetUrl.equals(strArray[3])&&havePrivs){
                accessable  = true;
                    break;
            }


        }
        return accessable;
    }

    /**
     * Alternative method for evaluating a permission where only the identifier of the
     * target object is available, rather than the target instance itself.
     *
     * @param authentication represents the user in question. Should not be null.
     * @param targetId       the identifier for the object instance (usually a Long)
     * @param targetType     a String representing the target's type (usually a Java
     *                       classname). Not null.
     * @param permission     a representation of the permission object as supplied by the
     *                       expression system. Not null.
     * @return true if the permission is granted, false otherwise
     */
    @Override
    public boolean hasPermission(Authentication authentication, Serializable targetId, String targetType, Object permission) {
        return false;
    }
}
