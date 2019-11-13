package cn.com.fovsoft.common.service;

import cn.com.fovsoft.common.bean.SysRole;
import cn.com.fovsoft.common.dao.SysRoleDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author by tpc
 * @Date 2019/11/6 21:58
 * description:用户角色服务类
 **/


@Service
public class SysRoleService {
    //注入数据库服务类对象
    @Resource
    private SysRoleDao sysRoleDao;


    /**
     * @author: tpc
     * @date: 2019/11/6 22:01
     * @description: 修改角色服务方法
     */
    public int updateSysRole(SysRole sysRole){
        return sysRoleDao.updateSysRole(sysRole);
    }

    /**
     * @author: tpc
     * @date: 2019/11/6 22:02
     * @description: 删除角色服务方法
     */
    public int deleteSysRole(String roleId){
        return sysRoleDao.deleteSysRole(roleId);
    }


    /**
     * @author: tpc
     * @date: 2019/11/6 22:03
     * @description: 新增角色服务方法
     */
    public int addSysRole(SysRole sysRole){
        return sysRoleDao.addSysRole(sysRole);
    }


    /**
     * @author: tpc
     * @date: 2019/11/6 22:08
     * @description: 获取所有角色信息的服务方法
     */
    public List<SysRole> findAllSysRole(){
        return sysRoleDao.findAllSysRole();
    }


    /*
     * Author:tpc
     * Date: 2019/11/13 13:59
     * Param: [userId]
     * Return: java.util.List<cn.com.fovsoft.common.bean.SysRole>
     * 功能描述: 通过用户id查找用户角色信息
     */
    public List<SysRole> findSysRoleBySysUserId(String userId){
        return sysRoleDao.findSysRoleBySysUserId(userId);
    }

    /*
     * Author:tpc
     * Date: 2019/11/7 20:26
     * Param: [roleName]
     * Return: java.util.List<cn.com.fovsoft.common.bean.SysRole>
     * 功能描述: 封装一下参数roleName，用来匹配后端的like方法
     */
    public List<SysRole> findSysRoleLikeRoleName(String roleName){
        roleName = "%"+roleName+"%";
        return sysRoleDao.findSysRoleLikeRoleName(roleName);
    }


    /*
     * Author:tpc
     * Date: 2019/11/8 13:11
     * Param: [roleName]
     * Return: java.util.List<cn.com.fovsoft.common.bean.SysRole>
     * 功能描述: 通过角色名准确查找roleName
     */
    public SysRole findSysRoleByRoleName(String roleName){
        return sysRoleDao.findSysRoleByRoleName(roleName);
    };


    /**
     * @author: tpc
     * @date: 2019/11/9 10:25
     * @description: 通过角色id准确查找角色
     */
    public SysRole findSysRoleByRoleId(String roleId){
        return sysRoleDao.findSysRoleByRoleId(roleId);
    }


}
