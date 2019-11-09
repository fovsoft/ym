package cn.com.fovsoft.common.service;


import cn.com.fovsoft.common.bean.SysRoleMenu;
import cn.com.fovsoft.common.dao.SysRoleMenuDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/*
 * Author:tpc
 * Date:2019-11-08 13:47
 * 功能描述:
 * version:
 */

@Service
public class SysRoleMenuService {

    @Resource
    SysRoleMenuDao sysRoleMenuDao;


    /*
     * Author:tpc
     * Date: 2019/11/8 13:50
     * Param: [sysRoleMenu]
     * Return: int
     * 功能描述: 添加权限角色对应
     */
    public int addSysRoleMenu(SysRoleMenu sysRoleMenu){
        return sysRoleMenuDao.addSysRoleMenu(sysRoleMenu);
    };


    /*
     * Author:tpc
     * Date: 2019/11/8 13:50
     * Param: [sysRoleMenu]
     * Return: int
     * 功能描述: 删除角色权限对应
     */
    public int deleteSysRoleMenu(SysRoleMenu sysRoleMenu){
        return sysRoleMenuDao.deleteSysRoleMenu(sysRoleMenu);
    };


    /**
     * @author: tpc
     * @date: 2019/11/9 16:33
     * @description: 根据角色id删除所有权限
     */
    public int deleteSysRoleMenuByRoleId(String roleId){
        return sysRoleMenuDao.deleteSysRoleMenuByRoleId(roleId);
    }


}
