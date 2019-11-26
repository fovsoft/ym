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


    /**
     * @author: tpc
     * @date: 2019/11/26 22:02
     * @description: 转移性收入多记录写入服务方法
     */
    public int addYmTransferIncomeMore(List<YmTransferIncome> ymTransferIncomeList){
        return ymTransferIncomeDao.addYmTransferIncomeMore(ymTransferIncomeList);
    }

}
