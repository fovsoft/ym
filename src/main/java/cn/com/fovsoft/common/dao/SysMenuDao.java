package cn.com.fovsoft.common.dao;

import cn.com.fovsoft.common.bean.SysMenu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author: tpc
 * @date: 2019-10-11 15:00
 * @description:
 **/

@Mapper
public interface SysMenuDao {


    @Select("select distinct m.* from frm_menu m " +
            "inner join frm_role_menu rm on m.id = rm.menuId " +
            "inner join frm_sysuser_role ru on ru.roleId = rm.roleId " +
            "where zt = 1 and ru.userId = #{userId} order by m.sequence")
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
    List<SysMenu> listByUserId(int userId);
}
