package cn.com.fovsoft.common.dao;/*
 * Author:tpc
 * Date:2019-11-11 15:50
 * 功能描述: 行政区划数据库对接接口
 * version:
 */

import cn.com.fovsoft.common.bean.AdministrativeDivision;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AdministrativeDivisionDao {



    /*
     * Author:tpc
     * Date: 2019/11/11 15:54
     * Param: []
     * Return: java.util.List<cn.com.fovsoft.common.bean.AdministrativeDivision>
     * 功能描述: 查找所有的行政区划信息
     */
    @Select("select * from frm_administrative_division order by id asc")
    @Results(id="AdResultMap", value = {
            @Result(property = "id", column = "id"),
            @Result(property = "xzqhdm", column = "xzqhdm"),
            @Result(property = "xzqhmz", column = "xzqhmz"),
            @Result(property = "xxxzqhmz", column = "xxxzqhmz"),
            @Result(property = "sjxzqhdm", column = "sjxzqhdm"),
            @Result(property = "fzjg", column = "fzjg"),
            @Result(property = "xzqhlb", column = "xzqhlb"),
            @Result(property = "yzbm", column = "yzbm"),
            @Result(property = "csjs", column = "csjs"),
            @Result(property = "gxsj", column = "gxsj")

    })
    List<AdministrativeDivision> findAllAdministrativeDivision();



    /*
     * Author:tpc
     * Date: 2019/11/11 15:57
     * Param: [sjxzqhdm]
     * Return: java.util.List<cn.com.fovsoft.common.bean.AdministrativeDivision>
     * 功能描述: 通过行政区划代码查找下面的所有子行政区划
     */
    @Select("select * from frm_administrative_division where sjxzqhdm=#{sjxzqhdm}")
    @ResultMap(value = {"AdResultMap"})
    List<AdministrativeDivision> findChildAdministrativeDivision(String sjxzqhdm);



    /*
     * Author:tpc
     * Date: 2019/11/11 16:47
     * Param: [id]
     * Return: java.util.List<cn.com.fovsoft.common.bean.AdministrativeDivision>
     * 功能描述: 根据id查找当前树的子节点
     */
    @Select("select * from frm_administrative_division where sjxzqhdm = " +
            " ( select xzqhdm from frm_administrative_division where id=#{id} ) ")
    @ResultMap(value = {"AdResultMap"})
    List<AdministrativeDivision> findChildAdministrativeDivisionById(String id);


}
