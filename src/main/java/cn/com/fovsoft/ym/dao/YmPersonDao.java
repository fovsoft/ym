package cn.com.fovsoft.ym.dao;

import cn.com.fovsoft.ym.bean.YmPerson;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author: by tpc
 * @date: 2019/10/18 9:21
 * @description:
 **/

@Mapper
public interface YmPersonDao {


    @Insert(" insert into ym_person(jtbh,xm,sex,sfzmhm,qfjg,sfzyxqs,sfzyxqz,yhzgx,mz,csrq,zzmm,whcd,zxsqk,sxhcxyy,jkqk,ldjn,sfhjpth,sfxyjr,sfcjylbx1,sfcjsybx,sfxsdb,sfcjylbx2,sfxsywbxbt,lxdh) values "+
            " (#{jtbh},#{xm},#{sex},#{sfzmhm},#{qfjg},#{sfzyxqs},#{sfzyxqz},#{yhzgx},#{mz},#{csrq},#{zzmm},#{whcd},#{zxsqk},#{sxhcxyy},#{jkqk},#{ldjn},#{sfhjpth},#{sfxyjr},#{sfcjylbx1},#{sfcjsybx},#{sfxsdb},#{sfcjylbx2},#{sfxsywbxbt},#{lxdh})")
    int addYmPerson(YmPerson ymPerson);
}
