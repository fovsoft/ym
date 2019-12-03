package cn.com.fovsoft.az.service;/*
 * @Author:tpc
 * @Date: 2019/12/2 10:17
 * 功能描述:搬迁安置户数据库操作类
 * @version:
 */

import cn.com.fovsoft.az.bean.AzSettlementHousehold;
import cn.com.fovsoft.az.dao.AzSettlementHouseholdDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AzSettlementHouseholdService {

    @Resource
    private AzSettlementHouseholdDao azSettlementHouseholdDao;


    /**
     * @author: tpc
     * @date: 2019/12/2 23:13
     * @description: 查找所有安置户服务方法
     */
    public List<AzSettlementHousehold> findAllAzSettlementHousehold(){
        return azSettlementHouseholdDao.findAllAzSettlementHousehold();
    }


    /*
     * Author:tpc
     * Date: 2019/12/3 17:34
     * Param: [id]
     * Return: cn.com.fovsoft.az.bean.AzSettlementHousehold
     * 功能描述: 通过主键查找安置户信息服务方法
     */
    public AzSettlementHousehold findAzSettlementHouseholdById(String id){
        return azSettlementHouseholdDao.findAzSettlementHouseholdById(id);
    }


    /**
     * @author: tpc
     * @date: 2019/12/2 23:13
     * @description: 根据主键id删除安置户信息服务方法
     */
    public int deleteAzSettlementHouseholdById(String id){
        return azSettlementHouseholdDao.deleteAzSettlementHouseholdById(id);
    }


    /**
     * @author: tpc
     * @date: 2019/12/2 23:13
     * @description: 新增安置户服务方法
     */
    public int addAzSettlementHousehold(AzSettlementHousehold azSettlementHousehold){
        return azSettlementHouseholdDao.addAzSettlementHousehold(azSettlementHousehold);
    }


    /**
     * @author: tpc
     * @date: 2019/12/3 23:01
     * @description: 首先进行字段的模糊匹配拼接，然后调用查询方法
     */
    public List<AzSettlementHousehold> findAzSettlementHouseholdByMoreCondition(String azdmz,String hz,String lxdh,String ldfh){
        //进行模糊查询的条件拼接
        azdmz = "%"+azdmz+"%";
        hz = "%"+hz+"%";
        lxdh = "%"+lxdh+"%";
        ldfh = "%"+ldfh+"%";
        return azSettlementHouseholdDao.findAzSettlementHouseholdByMoreCondition(azdmz,hz,lxdh,ldfh);

    }
}
