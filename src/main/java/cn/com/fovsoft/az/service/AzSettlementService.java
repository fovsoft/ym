package cn.com.fovsoft.az.service;/*
 * @Author:tpc
 * @Date: 2019/12/2 10:16
 * 功能描述:搬迁安置点服务类
 * @version:
 */

import cn.com.fovsoft.az.bean.AzSettlement;
import cn.com.fovsoft.az.dao.AzSettlementDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AzSettlementService {


    @Resource
    private AzSettlementDao azSettlementDao;

    /*
     * Author:tpc
     * Date: 2019/12/2 10:23
     * Param: []
     * Return: java.util.List<cn.com.fovsoft.az.bean.AzSettlement>
     * 功能描述: 查找所有的安置点信息
     */
    public List<AzSettlement> findAllAzSettlement(){
        return azSettlementDao.findAllAzSettlement();
    }


    /*
     * Author:tpc
     * Date: 2019/12/2 11:39
     * Param: [azSettlement]
     * Return: int
     * 功能描述: 新增安置点服务方法
     */
    public int addAzSettlement(AzSettlement azSettlement){
        return azSettlementDao.addAzSettlement(azSettlement);
    }


    /*
     * Author:tpc
     * Date: 2019/12/2 15:29
     * Param: [id]
     * Return: cn.com.fovsoft.az.bean.AzSettlement
     * 功能描述: 通过安置点id查找安置点
     */
    public AzSettlement findAzSettlementById(String id){
        return azSettlementDao.findAzSettlementById(id);
    }

    /*
     * Author:tpc
     * Date: 2019/12/2 16:37
     * Param: [azSettlement]
     * Return: int
     * 功能描述: 通过id进行修改信息
     */
    public int updateAzSettlementById(AzSettlement azSettlement){
        return azSettlementDao.updateAzSettlementById(azSettlement);
    }


    /*
     * Author:tpc
     * Date: 2019/12/2 16:55
     * Param: [id]
     * Return: int
     * 功能描述: 通过id删除安置点
     */
    public int deleteAzSettlementById(String id){
        return azSettlementDao.deleteAzSettlementById(id);
    }
}
