package cn.com.fovsoft.ym.dao;/*
 * Author:tpc
 * Date:2019-11-26 15:04:22
 * 功能描述:
 * version:
 */

import cn.com.fovsoft.ym.bean.YmSalaryIncome;
import org.apache.ibatis.annotations.Delete;
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
            "insert into ym_salary_income(jtbh,xm,wggz,wgdz,wgljsj,wgqymc,salary_nf,salary_yf1,salary_yf2,salary_yf3,salary_yf4,salary_yf5,salary_yf6,salary_yf7,salary_yf8,salary_yf9,salary_yf10,salary_yf11,salary_yf12) values ",
            "<foreach collection='ymSalaryIncomeList' item='item' index='index' separator=','>",
            "(#{item.jtbh},#{item.xm},#{item.wggz},#{item.wgdz},#{item.wgljsj},#{item.wgqymc},#{item.salary_nf},#{item.salary_yf1},#{item.salary_yf2},#{item.salary_yf3},#{item.salary_yf4},#{item.salary_yf5},#{item.salary_yf6},#{item.salary_yf7},#{item.salary_yf8},#{item.salary_yf9},#{item.salary_yf10},#{item.salary_yf11},#{item.salary_yf12}) ",
            "</foreach>",
            "</script>"
    })
    int addYmSalaryIncomeMore(@Param(value="ymSalaryIncomeList") List<YmSalaryIncome> ymSalaryIncomeList);


    /*
     * Author:tpc
     * Date: 2019/11/27 15:15
     * Param: [jbth]
     * Return: int
     * 功能描述: 根据家庭编号删除收入信息
     */
    @Delete("delete from ym_salary_income where jtbh=#{jtbh} ")
    int deleteYmSalaryIncomeByJtbh(String jtbh);
}
