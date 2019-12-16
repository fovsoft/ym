package cn.com.fovsoft.ym.dao;/*
 * Author:tpc
 * Date:2019-11-25 16:08:34
 * 功能描述: 生产收入数据库服务类
 * version:
 */

import cn.com.fovsoft.ym.bean.YmProduceIncome;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface  YmProduceIncomeDao {



    /*
     * Author:tpc
     * Date: 2019/11/26 10:56
     * Param: [ymProduceIncomeList]
     * Return: int
     * 功能描述: 一次写入多条生产收入信息
     */
    @Insert({
            "<script>",
            "insert into ym_produce_income(jtbh,produce_xtdl,produce_xtxl1,produce_xtxl2,produce_nf,produce_yf1,produce_yf2,produce_yf3,produce_yf4,produce_yf5,produce_yf6,produce_yf7,produce_yf8,produce_yf9,produce_yf10,produce_yf11,produce_yf12) values ",
            "<foreach collection='ymProduceIncomeList' item='item' index='index' separator=','>",
            "(#{item.jtbh},#{item.produce_xtdl},#{item.produce_xtxl1},#{item.produce_xtxl2},#{item.produce_nf},#{item.produce_yf1},#{item.produce_yf2},#{item.produce_yf3},#{item.produce_yf4},#{item.produce_yf5},#{item.produce_yf6},#{item.produce_yf7},#{item.produce_yf8},#{item.produce_yf9},#{item.produce_yf10},#{item.produce_yf11},#{item.produce_yf12}) ",
            "</foreach>",
            "</script>"
    })
    int addYmProduceIncomeMore(@Param(value = "ymProduceIncomeList") List<YmProduceIncome> ymProduceIncomeList);


    /*
     * Author:tpc
     * Date: 2019/11/27 15:12
     * Param: [jbth]
     * Return: int
     * 功能描述: 通过家庭编号删除收入信息
     */
    @Delete("delete from ym_produce_income where jtbh=#{jtbh} ")
    int deleteYmProduceIncomeByJtbh(String jtbh);
}
