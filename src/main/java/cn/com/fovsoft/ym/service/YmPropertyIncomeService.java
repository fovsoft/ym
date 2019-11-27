package cn.com.fovsoft.ym.service;

import cn.com.fovsoft.ym.bean.YmPropertyIncome;
import cn.com.fovsoft.ym.dao.YmPropertyIncomeDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author by tpc
 * @Date 2019/11/26 21:55
 * description:财产收入服务类
 **/

@Service
public class YmPropertyIncomeService {
    @Resource
    private YmPropertyIncomeDao ymPropertyIncomeDao;

    /**
     * @author: tpc
     * @date: 2019/11/26 22:01
     * @description: 多条财产收入信息服务方法
     */
    public int addYmPropertyIncomeMore(List<YmPropertyIncome> ymPropertyIncomeList){
        return ymPropertyIncomeDao.addYmPropertyIncomeMore(ymPropertyIncomeList);
    }



    public int deleteYmPropertyIncomeByJtbh(String jtbh){
        return ymPropertyIncomeDao.deleteYmPropertyIncomeByJtbh(jtbh);
    }


}
