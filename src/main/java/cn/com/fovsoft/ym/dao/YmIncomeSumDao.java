package cn.com.fovsoft.ym.dao;/*
 * @Author:tpc
 * @Date: 2019/12/17 17:20
 * 功能描述:
 * @version:
 */

import cn.com.fovsoft.ym.bean.YmIncomeSum;
import org.apache.ibatis.annotations.*;

@Mapper
public interface YmIncomeSumDao {


    @Select("select * from ym_income_sum where jtbh=#{jtbh} ")
    @Results(id="ymIncomeSumResult",value = {
            @Result(property="id"            , column="id"         ),
            @Result(property="jtbh"              , column="jtbh"           ),
            @Result(property="rks"             , column="rks"          ),
            @Result(property="sum_nf"             , column="sum_nf"          ),
            @Result(property="sum_produce"             , column="sum_produce"          ),
            @Result(property="sum_produce1"           , column="sum_produce1"        ),
            @Result(property="sum_salary"           , column="sum_salary"        ),
            @Result(property="sum_property"              , column="sum_property"           ),
            @Result(property="sum_transfer"            , column="sum_transfer"         ),
            @Result(property="sum_poverty"              , column="sum_poverty"           )
    })
    YmIncomeSum getYmIncomeSumByJtbh(String jtbh);


    @Insert("insert into ym_income_sum(jtbh,rks,sum_nf,sum_produce,sum_produce1,sum_salary,sum_property,sum_transfer,sum_poverty) values (#{jtbh},#{rks},#{sum_nf},#{sum_produce},#{sum_produce1},#{sum_salary},#{sum_property},#{sum_transfer},#{sum_poverty})")
    int addYmIncomeSum(YmIncomeSum ymIncomeSum);

    @Delete("delete from ym_income_sum where jtbh=#{jtbh}")
    int deleteYmIncomeSumByJtbh(String jtbh);
}
