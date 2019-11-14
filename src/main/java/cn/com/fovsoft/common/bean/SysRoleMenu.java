package cn.com.fovsoft.common.bean;/*
 * Author:tpc
 * Date:2019-11-08 13:39
 * 功能描述:角色与菜单权限实体类
 * version:
 */

import java.io.Serializable;

public class SysRoleMenu  implements Serializable {

    private String roleId;
    private String menuId;

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }
}
