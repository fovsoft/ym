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
}
