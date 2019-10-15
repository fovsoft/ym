package cn.com.fovsoft.common.service;

import cn.com.fovsoft.common.bean.SysMenuPermission;
import cn.com.fovsoft.common.dao.SysMenuPermissionDao;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.Set;

/**
 * @Author by tpc
 * @Date 2019/10/15 21:21
 * description: 获取权限信息的服务类
 **/

@Service
public class SysMenuPermissionService {


    //注入数据服务类
    @Resource
    private SysMenuPermissionDao sysMenuPermissionDao;


    /**
     * @author: tpc
     * @date: 2019/10/15 21:24
     * @description:  通过用户id查找菜单和权限信息
     */
    public Set<SysMenuPermission> findMenuPermissionByUserId(int userId){
        return sysMenuPermissionDao.findMenuAndPermission(userId);
    }
}
