package cn.com.fovsoft.ym.dao;
/*
 * @Author:tpc
 * @Date: 2019/11/26 16:09
 * 功能描述: 财产收入数据库操作类
 * @version:
 */

import cn.com.fovsoft.ym.bean.YmPropertyIncome;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.core.parameters.P;

import java.util.List;

@Mapper
public interface YmPropertyIncomeDao {


    @Insert({
            "<script>",
            "insert into ym_property_income(jtbh,pro_xtlb,pro_nf,pro_yf13,pro_yf46,pro_yf79,pro_yf10,pro_yf11,pro_yf12) values ",
            "<foreach collection='ymPropertyIncomeList' item='item' index='index' separator=','>",
            "(#{item.jtbh},#{item.pro_xtlb},#{item.pro_nf},#{item.pro_yf13},#{item.pro_yf46},#{item.pro_yf79},#{item.pro_yf10},#{item.pro_yf11},#{item.pro_yf12}) ",
            "</foreach>",
            "</script>"
    })
    int addYmPropertyIncomeMore(@Param(value = "ymPropertyIncomeList") List<YmPropertyIncome> ymPropertyIncomeList);
}
