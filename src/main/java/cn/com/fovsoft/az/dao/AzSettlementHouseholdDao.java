package cn.com.fovsoft.az.dao;/*
 * @Author:tpc
 * @Date: 2019/12/2 10:16
 * 功能描述:搬迁安置户数据库操作类
 * @version:
 */


import cn.com.fovsoft.az.bean.AzSettlementHousehold;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AzSettlementHouseholdDao {


    /**
     * @author: tpc
     * @date: 2019/12/2 23:05
     * @description: 查找所有的安置户
     */
    @Select("select * from az_settlement_household order by id asc ")
    @Results(id="settlementHouseholdMap", value = {
            @Result(property = "id",           column = "id"         ),
            @Result(property = "azdbh",        column = "azdbh"      ),
            @Result(property = "jtbh",         column = "jtbh"       ),
            @Result(property = "hz",           column = "hz"         ),
            @Result(property = "ldfh",         column = "ldfh"       ),
            @Result(property = "ndfqrw",       column = "ndfqrw"     ),
            @Result(property = "bqlx",         column = "bqlx"       ),
            @Result(property = "qcdsj",        column = "qcdsj"      ),
            @Result(property = "qcdxj",        column = "qcdxj"      ),
            @Result(property = "qcdxxdz",      column = "qcdxxdz"    ),
            @Result(property = "qcdlx",        column = "qcdlx"      ),
            @Result(property = "jtsyhrk",      column = "jtsyhrk"    ),
            @Result(property = "zfmj",         column = "zfmj"       ),
            @Result(property = "zczj",         column = "zczj"       ),
            @Result(property = "bqrzsj",       column = "bqrzsj"     ),
            @Result(property = "sjrzsj",       column = "sjrzsj"     ),
            @Result(property = "sfsjrzmln",    column = "sfsjrzmln"  ),
            @Result(property = "yyzf",         column = "yyzf"       ),
            @Result(property = "yzfmj",        column = "yzfmj"      ),
            @Result(property = "ccjf",         column = "ccjf"       ),
            @Result(property = "bhzfzl",       column = "bhzfzl"     ),
            @Result(property = "ccsj",         column = "ccsj"       ),
            @Result(property = "ccjfmj",       column = "ccjfmj"     ),
            @Result(property = "dxcfjl",       column = "dxcfjl"     ),
            @Result(property = "fkfl",         column = "fkfl"       ),
            @Result(property = "fkflmj",       column = "fkflmj"     ),
            @Result(property = "cyfcxm",       column = "cyfcxm"     ),
            @Result(property = "nnhdcyfczj",   column = "nnhdcyfczj" ),
            @Result(property = "tpqk",         column = "tpqk"       ),
            @Result(property = "hkqy",         column = "hkqy"       ),
            @Result(property = "fczbl",        column = "fczbl"      ),
            @Result(property = "lxdh",         column = "lxdh"       )
    })
    List<AzSettlementHousehold> findAllAzSettlementHousehold();


    /*
     * Author:tpc
     * Date: 2019/12/3 17:33
     * Param: [id]
     * Return: cn.com.fovsoft.az.bean.AzSettlementHousehold
     * 功能描述: 通过主键查找安置户
     */
    @Select("select * from az_settlement_household where id=#{id}")
    @ResultMap(value = {"settlementHouseholdMap"})
    AzSettlementHousehold findAzSettlementHouseholdById(String id);


    /**
     * @author: tpc
     * @date: 2019/12/2 23:07
     * @description: 通过主键id进行删除
     */
    @Delete("delete from az_settlement_household where id=#{id} ")
    int deleteAzSettlementHouseholdById(String id);


    /*
     * @author: tpc
     * @date: 2019/12/2 23:10
     * @description: 新增安置户
     */
    @Insert("insert into az_settlement_household(azdbh,jtbh,hz,ldfh,ndfqrw,bqlx,qcdsj,qcdxj,qcdxxdz,qcdlx,jtsyhrk,zfmj,zczj,bqrzsj,sjrzsj,sfsjrzmln,yyzf,yzfmj,ccjf,bhzfzl,ccsj,ccjfmj,dxcfjl,fkfl,fkflmj,cyfcxm,nnhdcyfczj,tpqk,hkqy,fczbl,lxdh) " +
            " values(#{azdbh},#{jtbh},#{hz},#{ldfh},#{ndfqrw},#{bqlx},#{qcdsj},#{qcdxj},#{qcdxxdz},#{qcdlx},#{jtsyhrk},#{zfmj},#{zczj},#{bqrzsj},#{sjrzsj},#{sfsjrzmln},#{yyzf},#{yzfmj},#{ccjf},#{bhzfzl},#{ccsj},#{ccjfmj},#{dxcfjl},#{fkfl},#{fkflmj},#{cyfcxm},#{nnhdcyfczj},#{tpqk},#{hkqy},#{fczbl},#{lxdh})")
    int addAzSettlementHousehold(AzSettlementHousehold azSettlementHousehold);
}
