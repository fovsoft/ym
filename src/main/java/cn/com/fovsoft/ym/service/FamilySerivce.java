package cn.com.fovsoft.ym.service;

import cn.com.fovsoft.ym.dao.*;
import cn.com.fovsoft.ym.entity.*;

import cn.com.fovsoft.ym.entity.holders.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service
public class FamilySerivce {


    @Resource
    private YmFamilyBaseDao ymFamilyBaseDao;

    @Resource
    private YmFamilyBaseAdditionDao ymFamilyBaseAdditionDao;

    @Resource
    private YmFamilyBaseConditionDao ymFamilyBaseConditionDao;

    @Resource
    private YmFamilyBaseMemberDao ymFamilyBaseMemberDao;
    @Resource
    private YmHouseHoldDao ymHouseHoldDao;
    /**
     *
     * @return
     */
    public PageInfo getList(HashMap<String, Object> paramMap) {
        PageHelper.startPage((int)paramMap.get("page"), (int)paramMap.get("limit"));
        List<YmQueryFamilyHolder> list =  ymFamilyBaseDao.list2(paramMap);
        return new PageInfo(list);
    }

    /**
     *
     * @param id
     * @return
     */
    public int del(Integer id) {
        return ymFamilyBaseDao.delete(id);
    }

    public int delMember(Integer id) {
        return ymFamilyBaseMemberDao.delete(id);
    }

    /**
     * 新增或更新家庭基本信息表
     *
     * @param ymFamilyBase
     * @return
     */
    public int addOrUpdateFamilyBase(YmFamilyBase ymFamilyBase) {
        int id = 0;
        if(ymFamilyBase.getId() == 0) {
            ymFamilyBase.setAddTime(new Timestamp(new Date().getTime()));
            // 插入
            ymFamilyBaseDao.add(ymFamilyBase);
            id = ymFamilyBase.getId();
        }
        else {
            // 更新
            ymFamilyBase.setUpdateTime(new Timestamp(new Date().getTime()));
            ymFamilyBaseDao.update(ymFamilyBase);
            id = ymFamilyBase.getId();
        }
        return id;
    }

    public YmQueryFamilyBaseHolder get(String id) {
        return ymFamilyBaseDao.get(id);
    }





    public int addOrUpdateFamilyBaseCondition(YmFamilyBaseCondition ymFamilyBaseCondition) {
        int id = 0;
        if(ymFamilyBaseCondition.getId() == 0) {
            // 插入
            ymFamilyBaseConditionDao.add(ymFamilyBaseCondition);
            id = ymFamilyBaseCondition.getId();
        }
        else {
            // 更新
            ymFamilyBaseConditionDao.update(ymFamilyBaseCondition);
            id = ymFamilyBaseCondition.getId();
        }
        return id;
    }

    public int addOrUpdateFamilyBaseMember(YmFamilyBaseMember ymFamilyBaseMember) {
        int id = 0;
        if(ymFamilyBaseMember.getId() == 0) {
            // 插入
            ymFamilyBaseMemberDao.add(ymFamilyBaseMember);
            id = ymFamilyBaseMember.getId();
        }
        else {
            // 更新
            ymFamilyBaseMemberDao.update(ymFamilyBaseMember);
            id = ymFamilyBaseMember.getId();
        }
        return id;
    }

    public List<YmQueryPersionHolder> getMemberList(String fid) {
        List<YmQueryPersionHolder> list =  ymFamilyBaseMemberDao.list(fid);
        return list;
    }

    public int delAll(String inStr) {
        int affectRows = ymFamilyBaseDao.delAll(inStr);
        return affectRows;
     }

     public YmQueryAdditionHolder getAddiction(String fid) {
        return ymFamilyBaseAdditionDao.get(fid);
     }

    public YmQueryConditionHolder getCondition(String fid) {
        return ymFamilyBaseConditionDao.get(fid);
    }

    public YmQueryHouseHold getHouseHold(String fid) {
        return ymHouseHoldDao.get(fid);
    }
}
