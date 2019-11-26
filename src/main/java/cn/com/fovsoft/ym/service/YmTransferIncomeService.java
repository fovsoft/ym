package cn.com.fovsoft.ym.service;/*
 * @Author:tpc
 * @Date: 2019/11/26 17:00
 * 功能描述:转移性收入服务类
 * @version:
 */

import cn.com.fovsoft.ym.dao.YmTransferIncomeDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class YmTransferIncomeService {

    @Resource
    private YmTransferIncomeDao ymTransferIncomeDao;
}
