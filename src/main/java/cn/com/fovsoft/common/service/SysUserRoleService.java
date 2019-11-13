package cn.com.fovsoft.common.service;/*
 * Author:tpc
 * Date:2019-11-13 15:27
 * 功能描述:
 * version:
 */

import cn.com.fovsoft.common.bean.SysUserRole;
import cn.com.fovsoft.common.dao.SysUserRoleDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SysUserRoleService {

    @Resource
    private SysUserRoleDao sysUserRoleDao;

    /*
     * Author:tpc
     * Date: 2019/11/13 15:29
     * Param: [sysUserRole]
     * Return: int
     * 功能描述: 新增用户角色对应信息
     */
    public int addSysUserRole(SysUserRole sysUserRole){
        return sysUserRoleDao.addSysUserRole(sysUserRole);
    }

    /*
     * Author:tpc
     * Date: 2019/11/13 15:29
     * Param: [userId]
     * Return: int
     * 功能描述: 删除用户角色信息
     */
    public int deleteSysUserRoleByUserId(String userId){
        return sysUserRoleDao.deleteSysUserRoleByUserId(userId);
    }
}
