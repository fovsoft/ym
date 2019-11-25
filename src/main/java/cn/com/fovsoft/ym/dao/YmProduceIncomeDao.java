package cn.com.fovsoft.ym.dao;/*
 * Author:tpc
 * Date:2019-11-25 16:08:34
 * 功能描述: 生产收入数据库服务类
 * version:
 */

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface  YmProduceIncomeDao {

    int addYmProduceIncome();
}
