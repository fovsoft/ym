package cn.com.fovsoft.ym.service;/*
 * @Author:tpc
 * @Date: 2019/11/26 17:00
 * 功能描述:转移性收入服务类
 * @version:
 */

import cn.com.fovsoft.ym.bean.YmTransferIncome;
import cn.com.fovsoft.ym.dao.YmTransferIncomeDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class YmTransferIncomeService {

    @Resource
    private YmTransferIncomeDao ymTransferIncomeDao;


    public List<YmTransferIncome> getTransferIncomeByJtbhAndYear(String jtbh,String year){
        return ymTransferIncomeDao.getTransferIncomeByJtbhAndYear(jtbh, year);
    }


    public int getCountByJtbhAndYear(String jtbh,String year){
        return ymTransferIncomeDao.getCountByJtbhAndYear(jtbh, year);
    }

    /**
     * @author: tpc
     * @date: 2019/11/26 22:02
     * @description: 转移性收入多记录写入服务方法
     */
    public int addYmTransferIncomeMore(List<YmTransferIncome> ymTransferIncomeList){
        return ymTransferIncomeDao.addYmTransferIncomeMore(ymTransferIncomeList);
    }


    public int deleteYmTransferIncomeByJtbh(String jtbh){
        return ymTransferIncomeDao.deleteYmTransferIncomeByJtbh(jtbh);
    }

    public int deleteYmTransferIncomeByJtbhAndYear(String jtbh,String year){
        return ymTransferIncomeDao.deleteYmTransferIncomeByJtbhAndYear(jtbh,year);
    }

}
