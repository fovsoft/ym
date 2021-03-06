package cn.com.fovsoft.common.dao;

import cn.com.fovsoft.common.bean.SysRole;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author: by tpc
 * @date: 2019/10/15 17:24
 * @description: 用户角色信息
 **/

@Mapper
public interface SysRoleDao {



    @Select("select distinct fr.* from frm_role fr " +
            "inner join frm_sysuser_role fsr  on fr.roleId = frs.roleId " +
            "where fsr.userId = #{userId}")
    @Results(id="sysRoleResultMap",value = {
            @Result(property = "roleId",column = "roleId"),
            @Result(property = "roleName",column = "roleName"),
            @Result(property = "description",column = "description"),
            @Result(property = "zt",column = "zt"),
            @Result(property = "cjsj",column = "cjsj"),
            @Result(property = "gxsj",column = "gxsj")
    })
    List<SysRole> findRoleByUserId(int userId);




    /**
     * @author: tpc
     * @date: 2019/11/6 21:58
     * @description: 根据角色id修改角色
     */
    @Update("update frm_role set roleName=#{roleName},description=#{description},zt=#{zt},gxsj=#{gxsj} where roleId=#{roleId} ")
    int updateSysRole(SysRole sysRole);

    /**
     * @author: tpc
     * @date: 2019/11/6 21:54
     * @description: 新增用户角色
     */
    @Insert("insert into frm_role(roleName,description,zt,cjsj,gxsj) values(#{roleName},#{description},#{zt},#{cjsj},#{gxsj})")
    int addSysRole(SysRole sysRole);


    /**
     * @author: tpc
     * @date: 2019/11/6 21:51
     * @description:根据角色id删除角色
     */
    @Delete("delete from frm_role where roleId=#{roleId} ")
    int deleteSysRole(String roleId);


    /**
     * @author: tpc
     * @date: 2019/11/6 22:07
     * @description: 获取所有角色信息
     */
    @Select("select * from frm_role order by roleId asc")
    @ResultMap(value = {"sysRoleResultMap"})
    List<SysRole> findAllSysRole();


    /**
     * @author: tpc
     * @date: 2019/11/6 22:07
     * @description: 获取所有相似角色信息
     */
    @Select("select * from frm_role where roleName like #{roleName}")
    @ResultMap(value = {"sysRoleResultMap"})
    List<SysRole> findSysRoleLikeRoleName(String roleName);


    /*
     * Author:tpc
     * Date: 2019/11/8 13:10
     * Param: [roleName]
     * Return: java.util.List<cn.com.fovsoft.common.bean.SysRole>
     * 功能描述: 通过角色名准确查找角色
     */
    @Select("select * from frm_role where roleName = #{roleName}")
    @ResultMap(value = {"sysRoleResultMap"})
    SysRole findSysRoleByRoleName(String roleName);


    /**
     * @author: tpc
     * @date: 2019/11/9 10:24
     * @description: 根据角色id查找角色
     */
    @Select("select * from frm_role where roleName = #{roleId}")
    @ResultMap(value = {"sysRoleResultMap"})
    SysRole findSysRoleByRoleId(String roleId);


    /*
     * Author:tpc
     * Date: 2019/11/13 13:58
     * Param: [userId]
     * Return: java.util.List<cn.com.fovsoft.common.bean.SysRole>
     * 功能描述: 通过用户id查找用户角色信息
     */
    @Select("select * from frm_role fr inner join frm_sysuser_role fsr on fr.roleId=fsr.roleId " +
            " where fsr.userId=#{userId} ")
    @ResultMap(value = {"sysRoleResultMap"})
    List<SysRole> findSysRoleBySysUserId(String userId);

}
