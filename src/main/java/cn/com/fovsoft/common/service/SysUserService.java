package cn.com.fovsoft.common.service;

import cn.com.fovsoft.common.bean.SysUser;
import cn.com.fovsoft.common.dao.SysUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class SysUserService {


    @Resource
    private SysUserDao sysUserDao;


    public SysUser findByUserName(String userName) {


        return sysUserDao.findByUserName(userName);

    }

    public SysUser findByUserNameAndPwd(String username,String password){
        return sysUserDao.findByUserNameAndPwd(username,password);
    }


    public int updateUserZjdlip(String zjdlip, String userName){
        return sysUserDao.updateUserZjdlip(zjdlip,userName);
    }


    public List<SysUser> findAllSysUser(){
        return sysUserDao.findAllSysUser();
    }


    public int addSysUser(SysUser sysUser){
        return sysUserDao.addSysUser(sysUser);
    }


    /*
     * 功能描述: 通过用户名或者身份证明号码或者联系电话或者邮箱查找
     * @author by tpc
     * @date 2019/11/6 11:26
     * @param [userName, sfzmhm, lxdh, email]
     * @return java.util.List<cn.com.fovsoft.common.bean.SysUser>
     */
    public List<SysUser> findByUserNameOrOther(String userName,String sfzmhm,String lxdh,String email){
        return sysUserDao.findByUserNameOrOther(userName,sfzmhm,lxdh,email);
    }

    /*
     * 功能描述: 修改用户信息
     * @author by tpc
     * @date 2019/11/6 17:45
     * @param [sysUser]
     * @return int
     */
    public int updateSysUserInfo(SysUser sysUser){
        return sysUserDao.updateSysUserInfo(sysUser);
    }



    /**
     * @author: tpc
     * @date: 2019/11/6 21:27
     * @description: 根据用户id删除数据信息
     */
    public int deleteSysUser(int userId){
        return sysUserDao.deleteSysUser(userId);
    }


}
