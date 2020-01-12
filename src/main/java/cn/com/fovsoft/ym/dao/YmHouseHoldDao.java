package cn.com.fovsoft.ym.dao;

import cn.com.fovsoft.ym.entity.holders.YmQueryHouseHold;
import org.apache.ibatis.annotations.*;

@Mapper
public interface YmHouseHoldDao {
    @Select("SELECT ldfh,ndfqrw,bqlx,qcdsj,qcdxj,qcdxxdz,qcdlx,jtsyhrk,zfmj,zczj,bqrzsj,sjrzsj,sfsjrzmln,yyzf,yzfmj,ccjf,bhzfzl,ccsj,ccjfmj,dxcfjl,fkfl,fkflmj,cyfcxm,nnhdcyfczj,tpqk,hkqy,fczbl,lxdh" +
            " From az_settlement_household WHERE jtbh = #{fid}")
    YmQueryHouseHold get(String fid);
}


