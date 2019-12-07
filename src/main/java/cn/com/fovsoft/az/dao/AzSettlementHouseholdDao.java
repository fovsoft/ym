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
     * @date: 2019/12/3 22:59
     * @description: 通过前端输入条件进行模糊查询
     */
    @SelectProvider(type = findSettlementHouseholdByMoreProvider.class, method = "findAzSettlementHouseholdByMoreCondition")
    @ResultMap(value = {"settlementHouseholdMap"})
    List<AzSettlementHousehold> findAzSettlementHouseholdByMoreCondition(String azdmz,String hz,String lxdh,String ldfh);
    class findSettlementHouseholdByMoreProvider{
        public String findAzSettlementHouseholdByMoreCondition(String azdmz,String hz,String lxdh,String ldfh){
            String sql = "select a.* from az_settlement_household a,az_settlement b where 1=1 ";
            if(!azdmz.equals("%%")){
                sql = sql + " and b.azdmz like #{azdmz} and a.azdbh=b.azdbh ";
            }
            if(!hz.equals("%%")){
                sql = sql + " and a.hz like #{hz} ";
            }
            if(!lxdh.equals("%%")){
                sql = sql + " and a.lxdh like #{lxdh} ";
            }
            if(!ldfh.equals("%%")){
                sql = sql + " and a.ldfh like #{ldfh} ";
            }
            return sql;
        }

    }


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


    /**
     * @author: tpc
     * @date: 2019/12/7 18:19
     * @description: 通过id修改信息
     */
    @Update("update az_settlement_household set azdbh=#{azdbh},jtbh=#{jtbh},hz=#{hz},ldfh=#{ldfh},ndfqrw=#{ndfqrw},bqlx=#{bqlx},qcdsj=#{qcdsj},qcdxj=#{qcdxj},qcdxxdz=#{qcdxxdz},qcdlx=#{qcdlx},jtsyhrk=#{jtsyhrk},zfmj=#{zfmj},zczj=#{zczj},bqrzsj=#{bqrzsj}," +
            "sjrzsj=#{sjrzsj},sfsjrzmln=#{sfsjrzmln},yyzf=#{yyzf},yzfmj=#{yzfmj},ccjf=#{ccjf},bhzfzl=#{bhzfzl},ccsj=#{ccsj},ccjfmj=#{ccjfmj},dxcfjl=#{dxcfjl},fkfl=#{fkfl},fkflmj=#{fkflmj},cyfcxm=#{cyfcxm},nnhdcyfczj=#{nnhdcyfczj},tpqk=#{tpqk},hkqy=#{hkqy},fczbl=#{fczbl},lxdh=#{lxdh} where id=#{id} ")
    int updateAzSettlementHouseholdById(AzSettlementHousehold azSettlementHousehold);
}
