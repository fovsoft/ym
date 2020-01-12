package cn.com.fovsoft.ym.dao;

import cn.com.fovsoft.ym.entity.YmFamilyBaseAddition;
import cn.com.fovsoft.ym.entity.holders.YmQueryAdditionHolder;
import org.apache.ibatis.annotations.*;

@Mapper
public interface YmFamilyBaseAdditionDao {

    @Select("SELECT zpyy1, zpyy2, zpyy3, ncjtrks, ndjtrks  From ym_family_status WHERE jtbh = #{fid}")
    YmQueryAdditionHolder get(String fid);

}
