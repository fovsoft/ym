package cn.com.fovsoft.ym.dao;

import cn.com.fovsoft.ym.bean.YmFamilyStatus;
import org.apache.ibatis.annotations.*;

/**
 * @author: by tpc
 * @date: 2019/10/18 9:21
 * @description:
 **/
@Mapper
public interface YmFamilyStatusDao {

    /*
     * Author:tpc
     * Date: 2019/11/27 16:30
     * Param:
     * Return:
     * 功能描述: 通过家庭编号获取信息
     */

    @Select("select * from ym_family_status where jtbh=#{jtbh} ")
    @Results(id="ymFamilyStatusResult",value = {
            @Result(property="jtzkbh"            , column="jtzkbh"         ),
            @Result(property="jtbh"              , column="jtbh"           ),
            @Result(property="zpyy1"             , column="zpyy1"          ),
            @Result(property="zpyy2"             , column="zpyy2"          ),
            @Result(property="zpyy3"             , column="zpyy3"          ),
            @Result(property="ncjtrks"           , column="ncjtrks"        ),
            @Result(property="ndjtrks"           , column="ndjtrks"        ),
            @Result(property="gdmj"              , column="gdmj"           ),
            @Result(property="yxggmj"            , column="yxggmj"         ),
            @Result(property="ldmj"              , column="ldmj"           ),
            @Result(property="tghlmj"            , column="tghlmj"         ),
            @Result(property="lgmj"              , column="lgmj"           ),
            @Result(property="smmj"              , column="smmj"           ),
            @Result(property="mcdmj"             , column="mcdmj"          ),
            @Result(property="sfyltqydd"         , column="sfyltqydd"      ),
            @Result(property="sfycyzfdtrdd"      , column="sfycyzfdtrdd"   ),
            @Result(property="sftscyd"           , column="sftscyd"        ),
            @Result(property="sftshyd"           , column="sftshyd"        ),
            @Result(property="sftgbds"           , column="sftgbds"        ),
            @Result(property="yssfkn"            , column="yssfkn"         ),
            @Result(property="yssfaq"            , column="yssfaq"         ),
            @Result(property="zfmj"              , column="zfmj"           ),
            @Result(property="ywwscs"            , column="ywwscs"         ),
            @Result(property="sfwfh"             , column="sfwfh"          ),
            @Result(property="wfdj"              , column="wfdj"           ),
            @Result(property="wgnd"              , column="wgnd"           ),
            @Result(property="zfjg"              , column="zfjg"           ),
            @Result(property="sfjrnmzyhzs"       , column="sfjrnmzyhzs"    ),
            @Result(property="yczgljl"           , column="yczgljl"        ),
            @Result(property="rhllx"             , column="rhllx"          ),
            @Result(property="zyrllx"            , column="zyrllx"         ),
            @Result(property="bgqksm"            , column="bgqksm"         )
    })
    YmFamilyStatus getYmFamilyStatusByJtbh(String jtbh);


    @Insert("insert into ym_family_status(jtbh,zpyy1,zpyy2,zpyy3,ncjtrks,ndjtrks,gdmj,yxggmj,ldmj,tghlmj,lgmj,smmj,mcdmj,sfyltqydd,sfycyzfdtrdd,sftscyd,sftshyd,sftgbds,yssfkn,yssfaq,zfmj,ywwscs,sfwfh,wfdj,wgnd,zfjg,sfjrnmzyhzs,yczgljl,rhllx,zyrllx,bgqksm) values (#{jtbh},#{zpyy1},#{zpyy2},#{zpyy3},#{ncjtrks},#{ndjtrks},#{gdmj},#{yxggmj},#{ldmj},#{tghlmj},#{lgmj},#{smmj},#{mcdmj},#{sfyltqydd},#{sfycyzfdtrdd},#{sftscyd},#{sftshyd},#{sftgbds},#{yssfkn},#{yssfaq},#{zfmj},#{ywwscs},#{sfwfh},#{wfdj},#{wgnd},#{zfjg},#{sfjrnmzyhzs},#{yczgljl},#{rhllx},#{zyrllx},#{bgqksm})")
    int addYmFamilyStatus(YmFamilyStatus ymFamilyStatus);


    /*
     * Author:tpc
     * Date: 2019/11/27 15:33
     * Param: [jtbh]
     * Return: int
     * 功能描述: 通过家庭编号删除家庭条件信息
     */
    @Delete("delete from ym_family_status where jtbh=#{jtbh} ")
    int deleteYmFamilyStatusByJtbh(String jtbh);

}
