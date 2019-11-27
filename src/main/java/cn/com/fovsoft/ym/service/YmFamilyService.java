package cn.com.fovsoft.ym.service;/*
 * Author:tpc
 * Date:2019-11-21 15:29:30
 * 功能描述: 贫困人员家庭基本信息服务类
 * version:
 */

import cn.com.fovsoft.ym.bean.YmFamily;
import cn.com.fovsoft.ym.dao.YmFamilyDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class YmFamilyService {

    @Resource
    YmFamilyDao ymFamilyDao;


    /*
     * Author:tpc
     * Date: 2019/11/21 15:31
     * Param: [ymFamily]
     * Return: int
     * 功能描述: 写入家庭基本信息
     */
    public int addYmFamily(YmFamily ymFamily){
        return ymFamilyDao.addYmFamily(ymFamily);
    }


    /*
     * Author:tpc
     * Date: 2019/11/27 15:34
     * Param: [jtbh]
     * Return: int
     * 功能描述: 通过家庭编号信息删除数据
     */
    public int deleteYmFamilyByJtbh(String jtbh){
        return ymFamilyDao.deleteYmFamilyByJtbh(jtbh);
    }


    /*
     * Author:tpc
     * Date: 2019/11/27 16:37
     * Param: [jtbh]
     * Return: cn.com.fovsoft.ym.bean.YmFamily
     * 功能描述: 通过家庭编号获取信息
     */
    public YmFamily getYmFamilyByJtbh(String jtbh){
        return ymFamilyDao.getYmFamilyByJtbh(jtbh);
    }
}
