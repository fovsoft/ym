package cn.com.fovsoft.ym.dao;

import cn.com.fovsoft.ym.bean.YmOutPovertyIncome;
import org.apache.ibatis.annotations.*;

import java.util.List;

/*
 * @Author:tpc
 * @Date: 2019/11/26 16:11
 * 功能描述:不计入家庭脱贫收入数据库操作类
 * @version:
 */
@Mapper
public interface YmOutPovertyIncomeDao {


    @Select("select * from ym_out_poverty_income where jtbh=#{jtbh} and pov_nf=#{year} ")
    @Results(id="ymOutPovertyIncomeResult",value = {
            @Result(property="pov_bh"            , column="pov_bh"         ),
            @Result(property="jtbh"              , column="jtbh"           ),
            @Result(property="pov_xtlb"             , column="pov_xtlb"          ),
            @Result(property="pov_nf"           , column="pov_nf"        ),
            @Result(property="pov_yf1"              , column="pov_yf1"           ),
            @Result(property="pov_yf2"              , column="pov_yf2"           ),
            @Result(property="pov_yf3"            , column="pov_yf3"         ),
            @Result(property="pov_yf4"              , column="pov_yf4"           ),
            @Result(property="pov_yf5"            , column="pov_yf5"         ),
            @Result(property="pov_yf6"            , column="pov_yf6"         ),
            @Result(property="pov_yf7"            , column="pov_yf7"         ),
            @Result(property="pov_yf8"            , column="pov_yf8"         ),
            @Result(property="pov_yf9"            , column="pov_yf9"         ),
            @Result(property="pov_yf10"            , column="pov_yf10"         ),
            @Result(property="pov_yf11"            , column="pov_yf11"         ),
            @Result(property="pov_yf2"            , column="pov_yf12"         ),
    })
    List<YmOutPovertyIncome> getOutPovertyIncomeByJtbhAndYear(String jtbh,String year);


    @Select("select count(*) from ym_out_poverty_income where jtbh=#{jtbh} and pov_nf=#{year}")
    int getCountByJtbhAndYear(String jtbh,String year);


    /*
     * Author:tpc
     * Date: 2019/11/26 16:17
     * Param: [ymOutPovertyIncomeList]
     * Return: int
     * 功能描述: 批量写入家庭不计入家庭脱贫收入实现方法
     */
    @Insert({
            "<script>",
            "insert into ym_out_poverty_income(jtbh,pov_xtlb,pov_nf,pov_yf1,pov_yf2,pov_yf3,pov_yf4,pov_yf5,pov_yf6,pov_yf7,pov_yf8,pov_yf9,pov_yf10,pov_yf11,pov_yf12) values ",
            "<foreach collection='ymOutPovertyIncomeList' item='item' index='index' separator=','>",
            "(#{item.jtbh},#{item.pov_xtlb},#{item.pov_nf},#{item.pov_yf1},#{item.pov_yf2},#{item.pov_yf3},#{item.pov_yf4},#{item.pov_yf5},#{item.pov_yf6},#{item.pov_yf7},#{item.pov_yf8},#{item.pov_yf9},#{item.pov_yf10},#{item.pov_yf11},#{item.pov_yf12}) ",
            "</foreach>",
            "</script>"
    })
    int addYmOutPovertyIncomeMore(@Param(value="ymOutPovertyIncomeList") List<YmOutPovertyIncome> ymOutPovertyIncomeList);



    /*
     * Author:tpc
     * Date: 2019/11/27 15:11
     * Param: [jbth]
     * Return: int
     * 功能描述: 根据家庭编号删除收入信息
     */
    @Delete("delete from ym_out_poverty_income where jtbh=#{jtbh} ")
    int deleteYmOutPovertyIncomeByJtbh(String jtbh);

    @Delete("delete from ym_out_poverty_income where jtbh=#{jtbh} and pov_nf=#{year} ")
    int deleteYmOutPovertyIncomeByJtbhAndYear(String jtbh,String year);
}
