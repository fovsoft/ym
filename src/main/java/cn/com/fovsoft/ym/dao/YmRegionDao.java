package cn.com.fovsoft.ym.dao;

import cn.com.fovsoft.ym.entity.YmRegion;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface YmRegionDao {

    @Select("<script>" +
            "select * from ym_region where 1 = 1 " +
            "<if test=\"id != null\"> and pid = #{id}</if>" +
            "<if test=\"id == null\"> and pid = 0</if>" +
            "</script>")
    List<YmRegion> getRegionList(@Param("id") Integer id);
}
