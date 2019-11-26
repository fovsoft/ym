package cn.com.fovsoft.ym.dao;/*
 * Author:tpc
 * Date:2019-11-26 15:04:22
 * 功能描述:
 * version:
 */

import cn.com.fovsoft.ym.bean.YmSalaryIncome;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface YmSalaryIncomeDao {

    /*
     * Author:tpc
     * Date: 2019/11/26 15:09
     * Param: [ymSalaryIncomeList]
     * Return: int
     * 功能描述: 写入多条工资收入记录
     */
    @Insert({
            "<script>",
            "insert into ym_salary_income(jtbh,xm,wggz,wgdz,wgljsj,wgqymc,sa_nf,sa_yf13,sa_yf46,sa_yf79,sa_yf10,sa_yf11,sa_yf12) values ",
            "<foreach collection='ymSalaryIncomeList' item='item' index='index' separator=','>",
            "(#{item.jtbh},#{item.xm},#{item.wggz},#{item.wgdz},#{item.wgljsj},#{item.wgqymc},#{item.sa_nf},#{item.sa_yf13},#{item.sa_yf46},#{item.sa_yf79},#{item.sa_yf10},#{item.sa_yf11},#{item.sa_yf12}) ",
            "</foreach>",
            "</script>"
    })
    int addYmSalaryIncomeMore(@Param(value="ymSalaryIncomeList") List<YmSalaryIncome> ymSalaryIncomeList);
}
