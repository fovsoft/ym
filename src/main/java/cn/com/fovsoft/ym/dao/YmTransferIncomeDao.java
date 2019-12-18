package cn.com.fovsoft.ym.dao;
/*
 * @Author:tpc
 * @Date: 2019/11/26 16:10
 * 功能描述:转移性收入数据库操作类
 * @version:
 */

import cn.com.fovsoft.ym.bean.YmTransferIncome;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface YmTransferIncomeDao {



    @Select("select * from ym_transfer_income where jtbh=#{jtbh} and tra_nf=#{year} ")
    @Results(id="ymTransferIncomeResult",value = {
            @Result(property="tra_bh"            , column="tra_bh"         ),
            @Result(property="jtbh"              , column="jtbh"           ),
            @Result(property="tra_xtlb"             , column="tra_xtlb"          ),
            @Result(property="tra_nf"           , column="tra_nf"        ),
            @Result(property="tra_yf1"              , column="tra_yf1"           ),
            @Result(property="tra_yf2"              , column="tra_yf2"           ),
            @Result(property="tra_yf3"            , column="tra_yf3"         ),
            @Result(property="tra_yf4"              , column="tra_yf4"           ),
            @Result(property="tra_yf5"            , column="tra_yf5"         ),
            @Result(property="tra_yf6"            , column="tra_yf6"         ),
            @Result(property="tra_yf7"            , column="tra_yf7"         ),
            @Result(property="tra_yf8"            , column="tra_yf8"         ),
            @Result(property="tra_yf9"            , column="tra_yf9"         ),
            @Result(property="tra_yf10"            , column="tra_yf10"         ),
            @Result(property="tra_yf11"            , column="tra_yf11"         ),
            @Result(property="tra_yf2"            , column="tra_yf12"         ),
    })
    List<YmTransferIncome> getTransferIncomeByJtbhAndYear(String jtbh,String year);


    @Select("select count(*) from ym_transfer_income where jtbh=#{jtbh} and tra_nf=#{year}")
    int getCountByJtbhAndYear(String jtbh,String year);


    /*
     * Author:tpc
     * Date: 2019/11/26 16:59
     * Param: [ymTransferIncomeList]
     * Return: int
     * 功能描述: 多条转移性收入记录写入方法
     */
    @Insert({
            "<script>",
            "insert into ym_transfer_income(jtbh,tra_xtlb,tra_nf,tra_yf1,tra_yf2,tra_yf3,tra_yf4,tra_yf5,tra_yf6,tra_yf7,tra_yf8,tra_yf9,tra_yf10,tra_yf11,tra_yf12) values ",
            "<foreach collection='ymTransferIncomeList' item='item' index='index' separator=','>",
            "(#{item.jtbh},#{item.tra_xtlb},#{item.tra_nf},#{item.tra_yf1},#{item.tra_yf2},#{item.tra_yf3},#{item.tra_yf4},#{item.tra_yf5},#{item.tra_yf6},#{item.tra_yf7},#{item.tra_yf8},#{item.tra_yf9},#{item.tra_yf10},#{item.tra_yf11},#{item.tra_yf12}) ",
            "</foreach>",
            "</script>"
    })
    int addYmTransferIncomeMore(@Param(value="ymTransferIncomeList") List<YmTransferIncome> ymTransferIncomeList);



    /*
     * Author:tpc
     * Date: 2019/11/27 15:15
     * Param: [jbth]
     * Return: int
     * 功能描述: 根据家庭编号删除收入信息
     */
    @Delete("delete from ym_transfer_income where jtbh=#{jtbh} ")
    int deleteYmTransferIncomeByJtbh(String jtbh);

    @Delete("delete from ym_transfer_income where jtbh=#{jtbh} and tra_nf=#{year} ")
    int deleteYmTransferIncomeByJtbhAndYear(String jtbh,String year);
}
