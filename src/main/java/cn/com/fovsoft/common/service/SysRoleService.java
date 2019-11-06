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


}
