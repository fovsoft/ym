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


    /**
     * @author: tpc
     * @date: 2019/11/11 21:17
     * @description: 通过主键id查找行政区划信息
     */
    public AdministrativeDivision findAdministrativeDivisionById(String id){
        return administrativeDivisionDao.findAdministrativeDivisionById(id);
    }

    /**
     * @author: tpc
     * @date: 2019/11/11 22:16
     * @description:写入行政区划信息
     */
    public int addAdministrativeDivision(AdministrativeDivision administrativeDivision){
        return administrativeDivisionDao.addAdministrativeDivision(administrativeDivision);
    }



    /*
     * Author:tpc
     * Date: 2019/11/12 9:27
     * Param: [administrativeDivision]
     * Return: int
     * 功能描述: 修改对应的行政区划信息
     */
    public int updateAdministrativeDivisionById(AdministrativeDivision administrativeDivision){
        return administrativeDivisionDao.updateAdministrativeDivisionById(administrativeDivision);
    }


    /*
     * Author:tpc
     * Date: 2019/11/12 11:39
     * Param: [id]
     * Return: int
     * 功能描述: 功能描述: 通过行政区划id删除其及其子行政区划
     */
    public int deleteAdministrativeDivisionByXzqhdm(String xzqhdm){
        return administrativeDivisionDao.deleteAdministrativeDivisionByXzqhdm(xzqhdm);
    }
}
