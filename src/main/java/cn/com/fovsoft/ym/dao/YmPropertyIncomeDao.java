package cn.com.fovsoft.ym.dao;
/*
 * @Author:tpc
 * @Date: 2019/11/26 16:09
 * 功能描述: 财产收入数据库操作类
 * @version:
 */

import cn.com.fovsoft.ym.bean.YmPropertyIncome;
import org.apache.ibatis.annotations.*;
import org.springframework.security.core.parameters.P;

import java.util.List;

@Mapper
public interface YmPropertyIncomeDao {



    @Select("select * from ym_property_income where jtbh=#{jtbh} and property_nf=#{year} ")
    @Results(id="ymPropertyIncomeResult",value = {
            @Result(property="property_bh"            , column="property_bh"         ),
            @Result(property="jtbh"              , column="jtbh"           ),
            @Result(property="property_xtlb"             , column="property_xtlb"          ),
            @Result(property="property_nf"           , column="property_nf"        ),
            @Result(property="property_yf1"              , column="property_yf1"           ),
            @Result(property="property_yf2"              , column="property_yf2"           ),
            @Result(property="property_yf3"            , column="property_yf3"         ),
            @Result(property="property_yf4"              , column="property_yf4"           ),
            @Result(property="property_yf5"            , column="property_yf5"         ),
            @Result(property="property_yf6"            , column="property_yf6"         ),
            @Result(property="property_yf7"            , column="property_yf7"         ),
            @Result(property="property_yf8"            , column="property_yf8"         ),
            @Result(property="property_yf9"            , column="property_yf9"         ),
            @Result(property="property_yf10"            , column="property_yf10"         ),
            @Result(property="property_yf11"            , column="property_yf11"         ),
            @Result(property="property_yf2"            , column="property_yf12"         ),
    })
    List<YmPropertyIncome> getPropertyIncomeByJtbhAndYear(String jtbh,String year);


    @Select("select count(*) from ym_property_income where jtbh=#{jtbh} and property_nf=#{year}")
    int getCountByJtbhAndYear(String jtbh,String year);


    @Insert({
            "<script>",
            "insert into ym_property_income(jtbh,property_xtlb,property_nf,property_yf1,property_yf2,property_yf3,property_yf4,property_yf5,property_yf6,property_yf7,property_yf8,property_yf9,property_yf10,property_yf11,property_yf12) values ",
            "<foreach collection='ymPropertyIncomeList' item='item' index='index' separator=','>",
            "(#{item.jtbh},#{item.property_xtlb},#{item.property_nf},#{item.property_yf1},#{item.property_yf2},#{item.property_yf3},#{item.property_yf4},#{item.property_yf5},#{item.property_yf6},#{item.property_yf7},#{item.property_yf8},#{item.property_yf9},#{item.property_yf10},#{item.property_yf11},#{item.property_yf12}) ",
            "</foreach>",
            "</script>"
    })
    int addYmPropertyIncomeMore(@Param(value = "ymPropertyIncomeList") List<YmPropertyIncome> ymPropertyIncomeList);


    /*
     * Author:tpc
     * Date: 2019/11/27 15:14
     * Param: [jbth]
     * Return: int
     * 功能描述: 根据家庭编号删除收入信息
     */
    @Delete("delete from ym_property_income where jtbh=#{jtbh} ")
    int deleteYmPropertyIncomeByJtbh(String jtbh);

    @Delete("delete from ym_property_income where jtbh=#{jtbh} and property_nf=#{year} ")
    int deleteYmPropertyIncomeByJtbhAndYear(String jtbh,String year);
}
