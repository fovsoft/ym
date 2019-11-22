package cn.com.fovsoft.ym.service;/*
 * Author:tpc
 * Date:2019-11-21 21:31:40
 * 功能描述:家庭基本条件服务类
 * version:
 */

import cn.com.fovsoft.ym.bean.YmFamilyStatus;
import cn.com.fovsoft.ym.dao.YmFamilyStatusDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class YmFamilyStatusService {

    @Resource
    YmFamilyStatusDao ymFamilyStatusDao;

    /*
     * Author:tpc
     * Date: 2019/11/21 21:34
     * Param: [ymFamilyStatus]
     * Return: int
     * 功能描述: 写入家庭基本信息服务方法
     */
    public int addYmFamilyStatus(YmFamilyStatus ymFamilyStatus){
        return ymFamilyStatusDao.addYmFamilyStatus(ymFamilyStatus);
    }
}
