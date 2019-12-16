package cn.com.fovsoft.ym.dao;
/*
 * @Author:tpc
 * @Date: 2019/11/26 16:09
 * 功能描述: 财产收入数据库操作类
 * @version:
 */

import cn.com.fovsoft.ym.bean.YmPropertyIncome;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.core.parameters.P;

import java.util.List;

@Mapper
public interface YmPropertyIncomeDao {


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
}
