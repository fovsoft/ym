package cn.com.fovsoft.ym.service;/*
 * @Author:tpc
 * @Date: 2019/12/17 17:29
 * 功能描述:
 * @version:
 */

import cn.com.fovsoft.ym.bean.YmIncomeSum;
import cn.com.fovsoft.ym.dao.YmIncomeSumDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class YmIncomeSumService {

    @Resource
    private YmIncomeSumDao ymIncomeSumDao;

    public YmIncomeSum getYmIncomeSumByJtbh(String jtbh){
        return ymIncomeSumDao.getYmIncomeSumByJtbh(jtbh);
    }

    public int addYmIncomeSum(YmIncomeSum ymIncomeSum){
        return ymIncomeSumDao.addYmIncomeSum(ymIncomeSum);
    }

    public int deleteYmIncomeSumByJtbh(String jtbh){
        return ymIncomeSumDao.deleteYmIncomeSumByJtbh(jtbh);
    }
}
