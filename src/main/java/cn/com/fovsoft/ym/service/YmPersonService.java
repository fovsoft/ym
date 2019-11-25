package cn.com.fovsoft.ym.service;

import cn.com.fovsoft.ym.bean.YmPerson;
import cn.com.fovsoft.ym.dao.YmPersonDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author by tpc
 * @Date 2019/10/20 16:35
 * description: 贫困人员的服务类
 **/

@Service
public class YmPersonService {

    //注入dao层类
    @Resource
    private YmPersonDao ymPersonDao;
    
    
    /*
     * @author: tpc
     * @date: 2019/10/20 16:37
     * @description:  通过用户名查找贫困人员信息
     */
    public YmPerson findYmPersonByXm(String xm){
        return ymPersonDao.findYmPersonByXm(xm);
    }

    /*
     * @author: tpc
     * @date: 2019/10/20 16:38
     * @description: 通过贫困人员的编号（也就是数据库表中主键)查找人员信息
     */
    public YmPerson findYmPersonByRybh(String rybh){
        return ymPersonDao.findYmPersonByRybh(rybh);
    }

    /*
     * @author: tpc
     * @date: 2019/10/20 16:44
     * @description: 获取所有贫困人员的用户信息
     */
    public List<YmPerson> findAllYmPerson(){
        return ymPersonDao.findAllYmPerson();
    }


    /*
     * Author:tpc
     * Date: 2019/11/21 15:40
     * Param: [ymPerson]
     * Return: int
     * 功能描述: 新增家庭人员服务方法
     */
    public int addYmPerson(YmPerson ymPerson){
        return ymPersonDao.addYmPerson(ymPerson);
    }


    /*
     * Author:tpc
     * Date: 2019/11/25 10:05
     * Param: [xm, sfzmhm, lxdh, csrq]
     * Return: java.util.List<cn.com.fovsoft.ym.bean.YmPerson>
     * 功能描述: 多条件的模糊查询
     */
    public List<YmPerson> findYmPersonByMoreCondition(String xm,String sfzmhm,String lxdh,String csrq){
        xm = xm + "%";
        sfzmhm = sfzmhm + "%";
        lxdh = lxdh + "%";
        csrq = csrq + "%";
        return ymPersonDao.findYmPersonByMoreCondition(xm,sfzmhm,lxdh,csrq);
    }

}
