package cn.com.fovsoft.common.service;

import cn.com.fovsoft.common.bean.SysMenu;
import cn.com.fovsoft.common.dao.SysMenuDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: by tpc
 * @date: 2019/10/16 9:01
 * @description: 菜单服务类
 **/

@Service
public class SysMenuService {

    @Resource
    private SysMenuDao sysMenuDao;


    /**
     * 功能描述:  根据用户id获取菜单信息
     * @author by tpc
     * @date 2019/10/16 9:04
     * @param userId
     * @return java.util.List<cn.com.fovsoft.common.bean.SysMenu>
     */
    public List<SysMenu> findMenuByUserId(int userId){

        return sysMenuDao.findMenuByUserId(userId);
    }


    /**
     * 功能描述:  根据用户名获取菜单信息
     * @author by tpc
     * @date 2019/10/16 9:31
     * @param userName
     * @return java.util.List<cn.com.fovsoft.common.bean.SysMenu>
     */
    public List<SysMenu> findMenuByUserName(String userName){
        return sysMenuDao.findMenuByUserName(userName);
    }

    /*
     * 功能描述: 查找所有的菜单权限信息服务类
     * @author by tpc
     * @date 2019/11/7 13:13
     * @param []
     * @return java.util.List<cn.com.fovsoft.common.bean.SysMenu>
     */
    public List<SysMenu> findAllMenu(){
        return sysMenuDao.findAllMenu();
    }
}
