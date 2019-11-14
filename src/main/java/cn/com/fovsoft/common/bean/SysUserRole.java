package cn.com.fovsoft.common.bean;/*
 * Author:tpc
 * Date:2019-11-13 15:21
 * 功能描述:用户角色对应表实体类
 * version:
 */


import java.io.Serializable;

public class SysUserRole  implements Serializable {
    private String userId;
    private String roleId;


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }
}
