package cn.com.fovsoft.common.dao;

import cn.com.fovsoft.common.bean.SysMenu;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author: tpc
 * @date: 2019-10-11 15:00
 * @description:
 **/

@Mapper
public interface SysMenuDao {


    @Select("select distinct m.* from frm_menu m " +
            "inner join frm_role_menu rm on m.menuId = rm.menuId " +
            "inner join frm_sysuser_role ru on ru.roleId = rm.roleId " +
            "inner join frm_sysuser fs on fs.userid = ru.userid " +
            "where fs.zt = 1 and fs.userId = #{userId} order by m.sequence")
    @Results(id="menuResultMap", value = {
            @Result(property = "menuId", column = "menuId"),
            @Result(property = "parentId", column = "parentId"),
            @Result(property = "menuName", column = "menuName"),
            @Result(property = "css", column = "css"),
            @Result(property = "url", column = "url"),
            @Result(property = "type", column = "type"),
            @Result(property = "permission", column = "permission"),
            @Result(property = "sequence", column = "sequence"),
            @Result(property = "zt", column = "zt"),
            @Result(property = "csjs", column = "csjs"),
            @Result(property = "gxsj", column = "gxsj"),

    })
    List<SysMenu> findMenuByUserId(int userId);



    /**
     * 功能描述:  根据用户名获取菜单
     * @author by tpc
     * @date 2019/10/16 9:12
     * @param userName
     * @return java.util.List<cn.com.fovsoft.common.bean.SysMenu>
     */
    @Select("select distinct m.* from frm_menu m " +
            "inner join frm_role_menu rm on m.menuId = rm.menuId " +
            "inner join frm_sysuser_role ru on ru.roleId = rm.roleId " +
            "inner join frm_sysuser fs on fs.userid = ru.userid " +
            "where fs.zt = 1 and fs.userName = #{userName} order by m.sequence")
    @ResultMap(value={"menuResultMap"})
    List<SysMenu> findMenuByUserName(String userName);


    /*
     * 功能描述: 查找所有的菜单权限信息
     * @author by tpc
     * @date 2019/11/7 13:12
     * @param []
     * @return java.util.List<cn.com.fovsoft.common.bean.SysMenu>
     */
    @Select("select * from frm_menu order by menuId asc")
    @ResultMap(value={"menuResultMap"})
    List<SysMenu> findAllMenu();


    /*
     * Author:tpc
     * Date: 2019/11/7 18:22
     * Param: [menuId]
     * Return: java.util.List<cn.com.fovsoft.common.bean.SysMenu>
     * 功能描述: 根据菜单id查找子菜单
     */
    @Select("select * from frm_menu where parentId=#{menuId}")
    @ResultMap(value={"menuResultMap"})
    List<SysMenu> findChildMenu(String menuId);



    /**
     * @author: tpc
     * @date: 2019/11/9 11:37
     * @description: 通过关联中间表，获取到角色对应的菜单权限信息
     */
    @Select("select fm.* from frm_menu fm,frm_role_menu frm where fm.menuId=frm.menuId and frm.roleId=#{roleId}")
    @ResultMap(value={"menuResultMap"})
    List<SysMenu> findMenuByRoleId(String roleId);

}
