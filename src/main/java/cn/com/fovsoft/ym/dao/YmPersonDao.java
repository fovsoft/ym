package cn.com.fovsoft.ym.dao;

import cn.com.fovsoft.ym.bean.YmPerson;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author: by tpc
 * @date: 2019/10/18 9:21
 * @description:
 **/

@Mapper
public interface YmPersonDao {


    @Insert(" insert into ym_person(jtbh,xm,xb,sfzmhm,qfjg,sfzyxqs,sfzyxqz,yhzgx,mz,csrq,zzmm,whcd,zxsqk,sxhcxyy,jkqk,ldjn,sfhjpth,sfxyjr,sfcjylbx1,sfcjsybx,sfxsdb,sfcjylbx2,sfxsywbxbt,lxdh) values "+
            " (#{jtbh},#{xm},#{xb},#{sfzmhm},#{qfjg},#{sfzyxqs},#{sfzyxqz},#{yhzgx},#{mz},#{csrq},#{zzmm},#{whcd},#{zxsqk},#{sxhcxyy},#{jkqk},#{ldjn},#{sfhjpth},#{sfxyjr},#{sfcjylbx1},#{sfcjsybx},#{sfxsdb},#{sfcjylbx2},#{sfxsywbxbt},#{lxdh})")
    int addYmPerson(YmPerson ymPerson);


    @Select("select * from ym_person where xm=#{xm}")
    @Results(id = "ymPersonResultMap", value={
            @Result(property="rybh"       , column="rybh"      ),
            @Result(property="jtbh"       , column="jtbh"      ),
            @Result(property="xm"         , column="xm"        ),
            @Result(property="xb"        , column="xb"       ),
            @Result(property="sfzmhm"     , column="sfzmhm"    ),
            @Result(property="qfjg"       , column="qfjg"      ),
            @Result(property="sfzyxqs"    , column="sfzyxqs"   ),
            @Result(property="sfzyxqz"    , column="sfzyxqz"   ),
            @Result(property="yhzgx"      , column="yhzgx"     ),
            @Result(property="mz"         , column="mz"        ),
            @Result(property="csrq"       , column="csrq"      ),
            @Result(property="zzmm"       , column="zzmm"      ),
            @Result(property="whcd"       , column="whcd"      ),
            @Result(property="zxsqk"      , column="zxsqk"     ),
            @Result(property="sxhcxyy"    , column="sxhcxyy"   ),
            @Result(property="jkqk"       , column="jkqk"      ),
            @Result(property="ldjn"       , column="ldjn"      ),
            @Result(property="sfhjpth"    , column="sfhjpth"   ),
            @Result(property="sfxyjr"     , column="sfxyjr"    ),
            @Result(property="sfcjylbx1"  , column="sfcjylbx1" ),
            @Result(property="sfcjsybx"   , column="sfcjsybx"  ),
            @Result(property="sfxsdb"     , column="sfxsdb"    ),
            @Result(property="sfcjylbx2"  , column="sfcjylbx2" ),
            @Result(property="sfxsywbxbt" , column="sfxsywbxbt"),
            @Result(property="lxdh"       , column="lxdh"      )
    })
    YmPerson findYmPersonByXm(String xm);


    /*
     * @author: tpc
     * @date: 2019/10/20 16:41
     * @description: 通过人员编号查找贫困人员信息
     */
    @Select("select * from ym_person where rybh=#{rybh}")
    @ResultMap(value = {"ymPersonResultMap"})
    YmPerson findYmPersonByRybh(String rybh);

    /*
     * @author: tpc
     * @date: 2019/10/20 16:43
     * @description:  获取所有贫困人员信息
     */
    @Select("select * from ym_person order by rybh asc")
    @ResultMap(value = {"ymPersonResultMap"})
    List<YmPerson> findAllYmPerson();


    /*
     * Author:tpc
     * Date: 2019/11/27 16:41
     * Param: [jtbh]
     * Return: java.util.List<cn.com.fovsoft.ym.bean.YmPerson>
     * 功能描述: 通过家庭编号获取信息
     */
    @Select("select * from ym_person where jtbh=#{jtbh} ")
    @ResultMap(value = {"ymPersonResultMap"})
    List<YmPerson> getYmPersonByJtbh(String jtbh);



    /*
     * Author:tpc
     * Date: 2019/11/25 10:03
     * Param: [xm, sfzmhm, lxdh, csrq]
     * Return: java.util.List<cn.com.fovsoft.ym.bean.YmPerson>
     * 功能描述: 模糊条件查询
     */
    @SelectProvider(type = YmPersonDaoProvider.class, method = "findYmPersonByMoreCondition")
    @ResultMap(value = {"ymPersonResultMap"})
    List<YmPerson> findYmPersonByMoreCondition(String xm,String sfzmhm,String lxdh,String csrq);
    class YmPersonDaoProvider{
        public String findYmPersonByMoreCondition(String xm,String sfzmhm,String lxdh,String csrq){
            String sql = "select * from ym_person where 1=1 ";
            if(!xm.equals("%")){
                sql = sql + " and xm like #{xm} ";
            }
            if(!sfzmhm.equals("%")){
                sql = sql + " and sfzmhm like #{sfzmhm} ";
            }
            if(!lxdh.equals("%")){
                sql = sql + " and lxdh like #{lxdh} ";
            }
            if(!csrq.equals("%")){
                sql = sql + " and csrq like #{csrq} ";
            }
            return  sql;
        }
    }


    /*
     * Author:tpc
     * Date: 2019/11/27 15:26
     * Param: [jtbh]
     * Return: int
     * 功能描述: 通过家庭编号删除所有家庭人员信息
     */
    @Delete("delete from ym_person where jtbh=#{jtbh} ")
    int deleteYmPersonByJtbh(String jtbh);


    /*
     * Author:tpc
     * Date: 2019/11/27 15:28
     * Param: [rybh]
     * Return: int
     * 功能描述: 通过人员编号删除单一人员信息
     */
    @Delete("delete from ym_person where rybh=#{rybh} ")
    int deleteYmPersonByRybh(String rybh);

}
