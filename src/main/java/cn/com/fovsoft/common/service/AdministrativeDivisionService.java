package cn.com.fovsoft.common.service;/*
 * Author:tpc
 * Date:2019-11-11 15:58
 * 功能描述: 行政区划服务类
 * version:
 */

import cn.com.fovsoft.common.bean.AdministrativeDivision;
import cn.com.fovsoft.common.dao.AdministrativeDivisionDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AdministrativeDivisionService {

    //注入数据库底层类
    @Resource
    private AdministrativeDivisionDao administrativeDivisionDao;


    /*
     * Author:tpc
     * Date: 2019/11/11 16:00
     * Param: []
     * Return: java.util.List<cn.com.fovsoft.common.bean.AdministrativeDivision>
     * 功能描述: 查找所有行政区划信息
     */
    public List<AdministrativeDivision> findAllAdministrativeDivision(){
        return administrativeDivisionDao.findAllAdministrativeDivision();
    };


    /*
     * Author:tpc
     * Date: 2019/11/11 16:01
     * Param: [sjxzqhdm]
     * Return: java.util.List<cn.com.fovsoft.common.bean.AdministrativeDivision>
     * 功能描述: 通过行政区划代码查找下属行政区划
     */
    public List<AdministrativeDivision> findChildAdministrativeDivision(String sjxzqhdm){
        return administrativeDivisionDao.findChildAdministrativeDivision(sjxzqhdm);
    };


    /*
     * Author:tpc
     * Date: 2019/11/11 16:48
     * Param: [id]
     * Return: java.util.List<cn.com.fovsoft.common.bean.AdministrativeDivision>
     * 功能描述: 通过当前树节点查找子节点
     */
    public List<AdministrativeDivision> findChildAdministrativeDivisionById(String id){
        return administrativeDivisionDao.findChildAdministrativeDivisionById(id);
    };
}
