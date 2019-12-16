package cn.com.fovsoft.ym.dao;
/*
 * @Author:tpc
 * @Date: 2019/11/26 16:10
 * 功能描述:转移性收入数据库操作类
 * @version:
 */

import cn.com.fovsoft.ym.bean.YmTransferIncome;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface YmTransferIncomeDao {


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
}
