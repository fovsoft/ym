package cn.com.fovsoft.ym.service;/*
 * Author:tpc
 * Date:2019-11-26 10:56:34
 * 功能描述:生产收入服务类
 * version:
 */

import cn.com.fovsoft.ym.bean.YmProduceIncome;
import cn.com.fovsoft.ym.dao.YmProduceIncomeDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class YmProduceIncomeService {

    @Resource
    private YmProduceIncomeDao ymProduceIncomeDao;

    /*
     * Author:tpc
     * Date: 2019/11/26 10:58
     * Param: [ymProduceIncomeList]
     * Return: int
     * 功能描述: 多条记录写入服务方法
     */
    public int addYmProduceIncomeMore(List<YmProduceIncome> ymProduceIncomeList){
        return ymProduceIncomeDao.addYmProduceIncomeMore(ymProduceIncomeList);
    }
}
