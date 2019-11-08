package cn.com.fovsoft.common.dao;/*
 * Author:tpc
 * Date:2019-11-08 13:38
 * 功能描述: 角色与菜单权限对应表数据类
 * version:
 */

import cn.com.fovsoft.common.bean.SysRole;
import cn.com.fovsoft.common.bean.SysRoleMenu;
import org.apache.ibatis.annotations.*;

@Mapper
public interface SysRoleMenuDao {


    /*
     * Author:tpc
     * Date: 2019/11/8 13:44
     * Param: [sysRoleMenu]
     * Return: int
     * 功能描述:  添加角色权限对应数据
     */
    @Insert("insert into frm_role_menu(roleId,menuId) values(#{roleId},#{menuId})")
    int addSysRoleMenu(SysRoleMenu sysRoleMenu);


    /*
     * Author:tpc
     * Date: 2019/11/8 13:47
     * Param: [sysRoleMenu]
     * Return: int
     * 功能描述: 删除角色权限对应数据
     */
    @Delete("delete from frm_role_menu where roleId=#{roleId} and menuId=#{menuId} ")
    int deleteSysRoleMenu(SysRoleMenu sysRoleMenu);


}
