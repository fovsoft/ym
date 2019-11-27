package cn.com.fovsoft.ym.service;

import cn.com.fovsoft.ym.bean.YmOutPovertyIncome;
import cn.com.fovsoft.ym.dao.YmOutPovertyIncomeDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author by tpc
 * @Date 2019/11/26 21:57
 * description:不计入家庭脱贫收入服务类
 **/

@Service
public class YmOutPovertyIncomeService {

    @Resource
    private YmOutPovertyIncomeDao ymOutPovertyIncomeDao;

    
    /**
     * @author: tpc
     * @date: 2019/11/26 22:00
     * @description: 多条脱贫收入写入方法
     */
    public int addYmOutPovertyIncomeMore(List<YmOutPovertyIncome> ymOutPovertyIncomeList){
        return ymOutPovertyIncomeDao.addYmOutPovertyIncomeMore(ymOutPovertyIncomeList);
    }

    /*
     * Author:tpc
     * Date: 2019/11/27 15:17
     * Param: [jtbh]
     * Return: int
     * 功能描述: 通过家庭编号删除信息
     */
    public int deleteYmOutPovertyIncomeByJtbh(String jtbh){
        return ymOutPovertyIncomeDao.deleteYmOutPovertyIncomeByJtbh(jtbh);
    }
}
