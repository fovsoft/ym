package cn.com.fovsoft.common.dao;/*
 * Author:tpc
 * Date:2019-11-13 15:23
 * 功能描述: 用户角色对应表后台操作类
 * version:
 */

import cn.com.fovsoft.common.bean.SysUserRole;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysUserRoleDao {



    /*
     * Author:tpc
     * Date: 2019/11/13 15:26
     * Param: [sysUserRole]
     * Return: int
     * 功能描述: 新增用户对应角色
     */
    @Insert("insert into frm_sysuser_role(userId,roleId) values (#{userId},#{roleId}) ")
    int addSysUserRole(SysUserRole sysUserRole);


    /*
     * Author:tpc
     * Date: 2019/11/13 15:26
     * Param: [userId]
     * Return: int
     * 功能描述: 根据用户id删除角色对应信息
     */
    @Delete("delete from frm_sysuser_role where userId=#{userId} ")
    int deleteSysUserRoleByUserId(String userId);
}
