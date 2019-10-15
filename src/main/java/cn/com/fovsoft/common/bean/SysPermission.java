package cn.com.fovsoft.common.bean;

import java.io.Serializable;

/**
 * @author: by tpc
 * @date: 2019/10/15 16:25
 * @description: 对应按钮操作权限
 **/
public class SysPermission implements Serializable {

    private Integer permissionId;
    private String permissionName;
    private String permission;

    public Integer getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }
}
