package cn.com.fovsoft.ym.service;/*
 * @Author:tpc
 * @Date: 2019/11/26 15:46
 * 功能描述:工资性收入服务类
 * @version:
 */

import cn.com.fovsoft.ym.bean.YmSalaryIncome;
import cn.com.fovsoft.ym.dao.YmSalaryIncomeDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class YmSalaryIncomeService {

    @Resource
    private YmSalaryIncomeDao ymSalaryIncomeDao;




    public int getCountByJtbhAndYear(String jtbh,String year){
        return ymSalaryIncomeDao.getCountByJtbhAndYear(jtbh, year);
    }

    public List<YmSalaryIncome> getSalaryIncomeByJtbhAndYear(String jtbh,String year){
        return ymSalaryIncomeDao.getSalaryIncomeByJtbhAndYear(jtbh, year);
    }
    /*
     * Author:tpc
     * Date: 2019/11/26 15:48
     * Param: [ymSalaryIncomeList]
     * Return: int
     * 功能描述: 多记录写入工资收入信息服务方法
     */
    public int addYmSalaryIncomeMore(List<YmSalaryIncome> ymSalaryIncomeList){
        return ymSalaryIncomeDao.addYmSalaryIncomeMore(ymSalaryIncomeList);
    }


    /*
     * Author:tpc
     * Date: 2019/11/27 15:18
     * Param: [jtbh]
     * Return: int
     * 功能描述: 通过家庭编号删除数据
     */
    public int deleteYmSalaryIncomeByJtbh(String jtbh){
        return ymSalaryIncomeDao.deleteYmSalaryIncomeByJtbh(jtbh);
    }


    public int deleteYmSalaryIncomeByJtbhAndYear(String jtbh,String year){
        return ymSalaryIncomeDao.deleteYmSalaryIncomeByJtbhAndYear(jtbh, year);
    }
}
