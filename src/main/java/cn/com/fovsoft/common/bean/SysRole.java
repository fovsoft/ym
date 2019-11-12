package cn.com.fovsoft.common.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * @author: tpc
 * @date: 2019-10-11 14:45
 * @description: 对应数据库用户角色表
 **/
public class SysRole implements Serializable {

    private String roleId 	  ;
    private String roleName 	;
    private String description;
    private String zt 	      ;
    private String cjsj 	      ;
    private String gxsj         ;

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getZt() {
        return zt;
    }

    public void setZt(String zt) {
        this.zt = zt;
    }

    public String getCjsj() {
        return cjsj;
    }

    public void setCjsj(String cjsj) {
        this.cjsj = cjsj;
    }

    public String getGxsj() {
        return gxsj;
    }

    public void setGxsj(String gxsj) {
        this.gxsj = gxsj;
    }
}
