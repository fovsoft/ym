package cn.com.fovsoft.ym.dao;

import cn.com.fovsoft.ym.bean.YmFamily;
import org.apache.ibatis.annotations.*;

/**
 * @author: by tpc
 * @date: 2019/10/18 9:20
 * @description:
 **/
@Mapper
public interface YmFamilyDao {


    @Select("select * from ym_family where jtbh=#{jtbh} ")
    @Results(id="ymFamilyResult",value = {
            @Result(property="jtId"          , column="jtId"        ),
            @Result(property="jtbh"          , column="jtbh"        ),
            @Result(property="xzqhdm"        , column="xzqhdm"      ),
            @Result(property="xxxzqhmz"      , column="xxxzqhmz"    ),
            @Result(property="lxdh"          , column="lxdh"        ),
            @Result(property="khyh"          , column="khyh"        ),
            @Result(property="yhkh"          , column="yhkh"        ),
            @Result(property="pkhsx"         , column="pkhsx"       ),
            @Result(property="sfdnytp"       , column="sfdnytp"     ),
            @Result(property="jhtpnd"        , column="jhtpnd"      ),
            @Result(property="fpnd"          , column="fpnd"        ),
            @Result(property="fpyy"          , column="fpyy"        ),
            @Result(property="sfjls"         , column="sfjls"       ),
            @Result(property="sfydfpbqh"     , column="sfydfpbqh"   ),
            @Result(property="bqfs"          , column="bqfs"        ),
            @Result(property="bqdz"          , column="bqdz"        )
    })
    YmFamily getYmFamilyByJtbh(String jtbh);


    /**
     * 功能描述: 往贫困人员家庭表中写入信息
     * @author by tpc
     * @date 2019/10/18 9:42
     * @param ymFamily
     * @return int
     */
    @Insert(" insert into ym_family(jtbh,xxxzqhmz,xzqhdm,lxdh,khyh,yhkh,pkhsx,sfdnytp,jhtpnd,fpnd,fpyy,sfjls,sfydfpbqh,bqfs,bqdz) values (#{jtbh},#{xxxzqhmz},#{xzqhdm},#{lxdh},#{khyh},#{yhkh},#{pkhsx},#{sfdnytp},#{jhtpnd},#{fpnd},#{fpyy},#{sfjls},#{sfydfpbqh},#{bqfs},#{bqdz})")
    int addYmFamily(YmFamily ymFamily);


    /*
     * Author:tpc
     * Date: 2019/11/27 15:32
     * Param: [jtbh]
     * Return: int
     * 功能描述: 通过家庭编号删除家庭信息
     */
    @Delete("delete from ym_family where jtbh=#{jtbh} ")
    int deleteYmFamilyByJtbh(String jtbh);



}
