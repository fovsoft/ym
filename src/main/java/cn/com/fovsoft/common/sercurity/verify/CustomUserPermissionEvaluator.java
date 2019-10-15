package cn.com.fovsoft.common.sercurity.verify;

import cn.com.fovsoft.common.bean.SysUser;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;

import java.io.Serializable;

/**
 * @author: by tpc
 * @date: 2019/10/15 16:51
 * @description: 对权限进行处理
 **/
public class CustomUserPermissionEvaluator implements PermissionEvaluator {

    /**
     * 描述 ：实现接口函数，完成权限认证
     * @param authentication     represents the user in question. Should not be null.
     * @param targetDomainObject the domain object for which permissions should be
     *                           checked. May be null in which case implementations should return false, as the null
     *                           condition can be checked explicitly in the expression.
     * @param permission         a representation of the permission object as supplied by the
     *                           expression system. Not null.
     * @return true if the permission is granted, false otherwise
     */
    @Override
    public boolean hasPermission(Authentication authentication, Object targetDomainObject, Object permission) {
        //获取认证通过的用户信息
        SysUser sysUser = (SysUser) authentication.getPrincipal();
        return false;
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
