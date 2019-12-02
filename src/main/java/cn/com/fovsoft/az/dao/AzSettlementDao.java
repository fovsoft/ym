package cn.com.fovsoft.az.dao;/*
 * @Author:tpc
 * @Date: 2019/12/2 10:15
 * 功能描述:
 * @version:
 */


import cn.com.fovsoft.az.bean.AzSettlement;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AzSettlementDao {



    /*
     * Author:tpc
     * Date: 2019/12/2 10:22
     * Param: []
     * Return: java.util.List<cn.com.fovsoft.az.bean.AzSettlement>
     * 功能描述: 查找所有的安置点信息
     */
    @Select("select * from az_settlement order by id asc")
    @Results(id="settlementResultMap", value = {
            @Result(property = "id", column = "id"),
            @Result(property = "azdbh", column = "azdbh"),
            @Result(property = "xzqhdm", column = "xzqhdm"),
            @Result(property = "azdmz", column = "azdmz"),
            @Result(property = "azfs", column = "azfs"),
            @Result(property = "cjsj", column = "cjsj"),
            @Result(property = "gxsj", column = "gxsj")
    })
    List<AzSettlement> findAllAzSettlement();

    /*
     * Author:tpc
     * Date: 2019/12/2 15:28
     * Param: [id]
     * Return: cn.com.fovsoft.az.bean.AzSettlement
     * 功能描述: 通过id查找安置点
     */
    @Select("select * from az_settlement where id=#{id} ")
    @ResultMap(value={"settlementResultMap"})
    AzSettlement findAzSettlementById(String id);

    /*
     * Author:tpc
     * Date: 2019/12/2 11:39
     * Param: [azSettlement]
     * Return: int
     * 功能描述: 新增安置点
     */
    @Insert("insert into az_settlement(azdbh,xzqhdm,azdmz,azfs,cjsj,gxsj) values(#{azdbh},#{xzqhdm},#{azdmz},#{azfs},#{cjsj},#{gxsj}) ")
    int addAzSettlement(AzSettlement azSettlement);


    /*
     * Author:tpc
     * Date: 2019/12/2 16:37
     * Param: [azSettlement]
     * Return: int
     * 功能描述: 通过id进行修改信息
     */
    @Update("update az_settlement set xzqhdm=#{xzqhdm},azdmz=#{azdmz},azfs=#{azfs},gxsj=#{gxsj} where id=#{id}")
    int updateAzSettlementById(AzSettlement azSettlement);

    /*
     * Author:tpc
     * Date: 2019/12/2 16:54
     * Param: [id]
     * Return: int
     * 功能描述: 通过id删除安置点
     */
    @Delete("delete from az_settlement where id=#{id} ")
    int deleteAzSettlementById(String id);

}
