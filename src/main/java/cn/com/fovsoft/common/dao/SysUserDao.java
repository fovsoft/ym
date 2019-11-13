package cn.com.fovsoft.common.dao;

import cn.com.fovsoft.common.bean.SysMenu;
import cn.com.fovsoft.common.bean.SysUser;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * @author: tpc
 * @date: 2019-10-11 14:58
 * @description:
 **/

@Mapper
public interface SysUserDao {

    /**
     * 列出所有用户
     *
     * @return
     */
    @Select("select * from frm_sysuser s order by s.userId asc")
    @Results(id = "sysUserResultMap", value = {
            @Result(property = "userId", column = "userId"),
            @Result(property = "userName", column = "userName"),
            @Result(property = "password", column = "password"),
            @Result(property = "department", column = "department"),
            @Result(property = "sex", column = "sex"),
            @Result(property = "birthday", column = "birthday"),
            @Result(property = "sfzmhm", column = "sfzmhm"),
            @Result(property = "email", column = "email"),
            @Result(property = "ipks", column = "ipks"),
            @Result(property = "ipjs", column = "ipjs"),
            @Result(property = "zhyxq", column = "zhyxq"),
            @Result(property = "mmyxq", column = "mmyxq"),
            @Result(property = "yhlx", column = "yhlx"),
            @Result(property = "lxdh", column = "lxdh"),
            @Result(property = "zjdlip", column = "zjdlip"),
            @Result(property = "zt", column = "zt"),
            @Result(property = "cjsj", column = "cjsj"),
            @Result(property = "gxsj", column = "gxsj"),
    })
    List<SysUser> findAllUser();


    /**
     * 通过用户名去查找用户
     *
     * @return
     */
    @Select("select * from frm_sysuser s where s.username=#{userName}")
    @ResultMap(value = {"sysUserResultMap"})
    SysUser findByUserName(String userName);


    /**
     * 通过用户名和密码去查找用户
     *
     * @return
     */
    @Select("select * from frm_sysuser s where s.userName=#{userName} and s.password=#{password}")
    @ResultMap(value = {"sysUserResultMap"})
    SysUser findByUserNameAndPwd(String userName, String password);


    /**
     * 通过用户名或者身份证明号码或者联系电话或者邮箱查找人员
     *
     * @return
     */
    @SelectProvider(type = SysUserDaoProvider.class, method = "findByUserNameOrOther")
    @ResultMap(value = {"sysUserResultMap"})
    List<SysUser> findByUserNameOrOther(String userName, String sfzmhm, String lxdh, String email);

    //用来拼接条件的内部类
    class SysUserDaoProvider {
        public String findByUserNameOrOther(String userName, String sfzmhm, String lxdh, String email) {
            String sql = "SELECT * FROM frm_sysuser where 1=1 ";
            if (!userName.equals("")) {
                sql += " and userName = #{userName} ";
            }
            if (!sfzmhm.equals("")) {
                sql += " and sfzmhm = #{sfzmhm} ";
            }
            if (!lxdh.equals("")) {
                sql += " and lxdh = #{lxdh} ";
            }
            if (!sfzmhm.equals("")) {
                sql += " and email = #{email} ";
            }
            return sql;
        }
    }


    /**
     * @author: tpc
     * @date: 2019/11/2 12:41
     * @description: 获取所有用户信息
     */

    @Select("select * from frm_sysuser order by userId")
    @ResultMap(value = {"sysUserResultMap"})
    List<SysUser> findAllSysUser();


    /**
     * 功能描述:记录用户登陆ip地址
     *
     * @param zjdlip, userName
     * @return int
     * @author tpc
     * @date 2019/10/12
     */
    @Update(value = "update frm_sysuser u set u.zjdlip =#{zjdlip} where u.userName = #{userName}")
    int updateUserZjdlip(String zjdlip, String userName);



    /*
     * 功能描述: 修改用户信息
     * @author by tpc
     * @date 2019/11/6 17:44
     * @param [sysUser]
     * @return int
     */
    @Update(value = "update frm_sysuser set userName = #{userName},department = #{department} ,sex = #{sex},birthday = #{birthday},sfzmhm = #{sfzmhm},email = #{email},ipks = #{ipks},ipjs= #{ipjs},zhyxq = #{zhyxq},mmyxq = #{mmyxq} ,yhlx = #{yhlx},lxdh= #{lxdh},zjdlip = #{zjdlip},zt = #{zt},cjsj = #{cjsj} ,gxsj = #{gxsj} where userId=#{userId} ")
    int updateSysUserInfo(SysUser sysUser);



    /**
     * @author: tpc
     * @date: 2019/11/13 21:05
     * @description: 通过用户id修改密码
     */
    @Update(value = "update frm_sysuser set password=#{password} where userId=#{userId} ")
    int updatePasswordByUserId(int userId,String password);


    /**
     * @author: by tpc
     * @date: 2019/10/17 22:01
     * @description: 新增用户信息
     */
    @Insert("insert into frm_sysuser(userName,password,department,sex,birthday,sfzmhm,email,ipks,ipjs,zhyxq,mmyxq,yhlx,lxdh,zjdlip,zt,cjsj) values(#{userName},#{password},#{department},#{sex},#{birthday},#{sfzmhm},#{email},#{ipks},#{ipjs},#{zhyxq},#{mmyxq},#{yhlx},#{lxdh},#{zjdlip},#{zt},#{cjsj})")
    int addSysUser(SysUser sysUser);

    /**
     * @author: tpc
     * @date: 2019/11/6 21:24
     * @description: 根据id删除用户
     */
    @Delete("delete from frm_sysuser where userId=#{userId}")
    int deleteSysUser(int userId);


}
