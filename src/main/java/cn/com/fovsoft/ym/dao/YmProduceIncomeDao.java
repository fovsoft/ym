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
            "insert into ym_produce_income(jtbh,xtdl,xtxl1,xtxl2,nf,yf13,yf46,yf79,yf10,yf11,yf12) values ",
            "<foreach collection='ymProduceIncomeList' item='item' index='index' separator=','>",
            "(#{item.jtbh},#{item.xtdl},#{item.xtxl1},#{item.xtxl2},#{item.nf},#{item.yf13},#{item.yf46},#{item.yf79},#{item.yf10},#{item.yf11},#{item.yf12}) ",
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
