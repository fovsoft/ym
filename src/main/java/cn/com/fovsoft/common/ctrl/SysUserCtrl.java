package cn.com.fovsoft.common.ctrl;

import cn.com.fovsoft.common.bean.SysMenu;
import cn.com.fovsoft.common.bean.SysRole;
import cn.com.fovsoft.common.bean.SysUser;
import cn.com.fovsoft.common.bean.SysUserRole;
import cn.com.fovsoft.common.constant.VarConstant;
import cn.com.fovsoft.common.service.SysMenuService;
import cn.com.fovsoft.common.service.SysRoleService;
import cn.com.fovsoft.common.service.SysUserRoleService;
import cn.com.fovsoft.common.service.SysUserService;
import cn.com.fovsoft.common.util.DateUtil;
import cn.com.fovsoft.ym.bean.YmPerson;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

/**
 * @author: tpc
 * @date: 2019/11/2 12:39
 * @description:  用户管理控制类
 */
@Controller
public class SysUserCtrl {

    @Autowired
    private SysUserService sysUserService;



    @Autowired
    private SysRoleService sysRoleService;

    @Autowired
    private SysUserRoleService sysUserRoleService;

    @Autowired
    private SysMenuService sysMenuService;


    @Autowired
    private ObjectMapper objectMapper;

    @RequestMapping("/whoim")
    @ResponseBody
    private Object whoIm()
    {
        System.out.println("是否已经验证："+SecurityContextHolder.getContext().getAuthentication().isAuthenticated());
        System.out.println("验证密码为："+ SecurityContextHolder.getContext().getAuthentication().getCredentials());

        return SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    /*/**
     * @author: tpc
     * @date: 2019/10/15
     * @description: 对应系统管理用户管理菜单
     */


    @RequestMapping(value = "/admin/user")
    public ModelAndView listSysUser(HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("sysuser");
        modelAndView.addObject("rootSysMenuList",request.getSession().getAttribute(VarConstant.SESSION_MENU));
        //获取所有角色信息，并返回前端
        List<SysRole> sysRoleList = sysRoleService.findAllSysRole();
        modelAndView.addObject("sysRoleList",sysRoleList);
        modelAndView.addObject("sessionUser",request.getSession().getAttribute(VarConstant.SESSION_USER));
        return modelAndView;
    }




    /**
     * @author: tpc
     * @date: 2019/11/13 21:09
     * @description: 修改密码实现方法
     */

    @RequestMapping("/user/password")
    @ResponseBody
    public Map<String,Object> updatePassword(HttpServletRequest request){
        //获取用户名
        String userName = (String)request.getSession().getAttribute(VarConstant.SESSION_USER);
        //通过用户名查找用户
        SysUser sysUser = sysUserService.findByUserName(userName);

        String oldPassword = request.getParameter("oldPassword");
        String newPassword = request.getParameter("newPassword");

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();



        //返回给前端的对象
        Map<String,Object> map = new HashMap<>();
        int status = 0;
        String result = "";

        System.out.println(oldPassword);
        System.out.println(sysUser.getPassword());

        if(!bCryptPasswordEncoder.matches(oldPassword,sysUser.getPassword())){
            result = "errorPw";
        }else {
            sysUserService.updatePasswordByUserId(sysUser.getUserId(),bCryptPasswordEncoder.encode(newPassword));
            status = 1;
            result = "success";
        }

        map.put("status",status);
        map.put("result",result);

        return map;
    }



    /*
     * Author:tpc
     * Date: 2019/11/13 14:01
     * Param: [request]
     * Return: java.util.Map<java.lang.String,java.lang.Object>
     * 功能描述: 获取用户拥有角色信息
     */
    @RequestMapping(value = "/user/getRole")
    @ResponseBody
    public Map<String,Object> getSysUserRole(HttpServletRequest request){
        String userId    = request.getParameter("userId");
        List<SysRole> sysRoleList = sysRoleService.findSysRoleBySysUserId(userId);

        Map<String,Object> map = new HashMap<>();

        map.put("sysRoleList",sysRoleList);
        return map;
    }

    /**
     * @author: tpc
     * @date: 2019/11/2 21:47
     * @description: 展示所有用户信息
     */

    @RequestMapping(value = "/user/list",method = RequestMethod.POST)
    @ResponseBody
    public void listAllSysUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //前端获取到的页码数
        int pageNum = Integer.parseInt(request.getParameter("page"));
        //前端获取到的显示每页的数量
        int pageSize = Integer.parseInt(request.getParameter("rows"));
        //分页获取到所有用户信息
        PageHelper.startPage(pageNum,pageSize);
        List<SysUser> sysUserList = sysUserService.findAllSysUser();
        PageInfo<SysUser> pageInfo = new PageInfo<SysUser>(sysUserList);
        //获得总记录数
        long records = pageInfo.getTotal();
        //默认当前页码
        int page = pageInfo.getPageNum();
        //获得总页数
        int total = pageInfo.getPages();
        //用来序列化json数据的map
        Map<String,Object> map=new HashMap<>();
        //设置json格式写出
        map.put("rows",sysUserList);
        map.put("page",page);
        map.put("total",total);
        map.put("records",records);
        System.out.println(objectMapper.writeValueAsString(map));
        // modelAndView.addObject("rows",objectMapper.writeValueAsString(ymPersonList));
        response.setContentType("application/json;charset=utf-8");
        //map.put("ymPerson_data",ymPersonList);
        response.getWriter().write(objectMapper.writeValueAsString(map));
        response.getWriter().flush();
        response.getWriter().close();
//        return modelAndView;
    }



    /**
     * @author: tpc
     * @date: 2019/11/6 20:47
     * @description: 删除选定用户
     */
    @RequestMapping(value = "/user/delete")
    @ResponseBody
    public Map<String,Object> deleteSysUser(HttpServletRequest request){
        //获取封装的用户id信息
        String idArray = request.getParameter("idArr");
        idArray = idArray.substring(0,idArray.length()-1);

        Map<String,Object> map = new HashMap<>();
        int status = 0;
        String result = "error";

        //获取选中行的所有id，存入数组中
        if(idArray.length()==1){
            int resultInt = sysUserService.deleteSysUser(Integer.parseInt(idArray));
            sysUserRoleService.deleteSysUserRoleByUserId(idArray);
            status = 1;
            result = "success";
        }else {
            String[] userIdArray = idArray.split(",");
            for(String str:userIdArray){
                //删除角色信息
                sysUserRoleService.deleteSysUserRoleByUserId(str);
                //删除用户信息
                sysUserService.deleteSysUser(Integer.parseInt(str));
            }
            status = 1;
            result = "success";
        }
        map.put("status",status);
        map.put("result",result);

        return map;

    }

    @RequestMapping(value = "/user/deleteOne")
    @ResponseBody
    public Map<String,Object> deleteSysUserOne(HttpServletRequest request){
        //获取封装的用户id信息
        String userId = request.getParameter("userId");
        Map<String,Object> map = new HashMap<>();
        int status = 0;
        String result = "error";

        //删除角色信息
        sysUserRoleService.deleteSysUserRoleByUserId(userId);
        //删除用户信息
        int resultInt = sysUserService.deleteSysUser(Integer.parseInt(userId));
        //获取选中行的所有id，存入数组中
        if(resultInt>0){
            status = 1;
            result="success";
        }
        map.put("status",status);
        map.put("result",result);

        return map;

    }



    /*
     * 功能描述: 修改用户实现
     * @author by tpc
     * @date 2019/11/6 17:28
     * @param [request]
     * @return java.util.Map<java.lang.String,java.lang.Object>
     */
    @RequestMapping(value = "/user/edit")
    @ResponseBody
    public Map<String,Object> editSysUser(HttpServletRequest request){

        //获取新增用户提交过来的数据信息
        String userId    = request.getParameter("userId");
        String userName  = request.getParameter("userName"  );
        String department= request.getParameter("department");
        String sex       = request.getParameter("sex"       );
        String birthday  = request.getParameter("birthday"  );
        String sfzmhm    = request.getParameter("sfzmhm"    );
        String email     = request.getParameter("email"     );
        String ipks      = request.getParameter("ipks"      );
        String ipjs      = request.getParameter("ipjs"      );
        String zhyxq     = request.getParameter("zhyxq"     );
        String mmyxq     = request.getParameter("mmyxq"     );
        String yhlx      = request.getParameter("yhlx"      );
        String lxdh      = request.getParameter("lxdh"      );
        String zt        = request.getParameter("zt"        );
        String roleIdArr = request.getParameter("roleIdArr" );

        //用来返回信息的封装对象
        Map<String,Object> map=new HashMap<>();
        //用来返回前端的信息
        int status = 0;
        String result = "";

        //为空的参数初始化
        if(birthday ==null){
            birthday="0000-00-00";
        }

        //写入修改用户信息
        SysUser sysUser = new SysUser();
        sysUser.setUserId(Integer.parseInt(userId));
        sysUser.setUserName(userName);
        sysUser.setDepartment(department);
        sysUser.setBirthday(DateUtil.strToDate(birthday));
        sysUser.setCjsj(DateUtil.getStringDate());
        sysUser.setEmail(email);
        sysUser.setGxsj(DateUtil.getStringDate());
        sysUser.setIpks(ipks);
        sysUser.setIpjs(ipjs);
        sysUser.setLxdh(lxdh);
        sysUser.setYhlx(yhlx);
        sysUser.setMmyxq(DateUtil.strToDate(mmyxq));
        sysUser.setZhyxq(DateUtil.strToDate(zhyxq));
        sysUser.setZjdlip("0.0.0.0");
        if(sex.equals("woman")){
            sysUser.setSex("女");
        }else {
            sysUser.setSex("男");
        }
        sysUser.setSfzmhm(sfzmhm);
        sysUser.setZt(zt);

        String[] roleIdArray = roleIdArr.substring(0,roleIdArr.length()-1).split(",");
        //先删除原先拥有的角色信息
        sysUserRoleService.deleteSysUserRoleByUserId(userId);
        //再写入修改后的角色信息
        for(String str:roleIdArray){
            SysUserRole sysUserRole = new SysUserRole();
            sysUserRole.setUserId(userId);
            sysUserRole.setRoleId(str);
            sysUserRoleService.addSysUserRole(sysUserRole);
        }
        //角色修改完成后，加入新增的权限
        List<SysMenu> allSysMenuList = sysMenuService.findAllMenu();
        //用来存放根菜单的list
        List<SysMenu> rootSysMenuList = new ArrayList<>();
        for(SysMenu sysMenu:allSysMenuList){
            if(sysMenu.getParentId().equals("0")){
                rootSysMenuList.add(sysMenu);
            }
        }
        //循环根菜单，然后写入子菜单
        for(SysMenu sysMenu1:rootSysMenuList){
            sysMenu1.setChildMenuList(sysMenuService.findChildMenu(sysMenu1.getMenuId()));
        }
        //修改session缓存
        //request.getSession().removeAttribute("rootSysMenuList");
        //把菜单信息写入session
        request.getSession().setAttribute("rootSysMenuList",rootSysMenuList);

        //再写入修改后的用户信息
        int returnInt = sysUserService.updateSysUserInfo(sysUser);
        if(returnInt<1) {
            status = 0;
            result = "inerror";
        }else {
            status = 2;
            result = "success";
        }

        map.put("status",status);
        map.put("result",result);
        return map;
    }


    /*
     * 功能描述:  新增用户实现
     * @author by tpc
     * @date 2019/11/6 17:27
     * @param [request]
     * @return java.util.Map<java.lang.String,java.lang.Object>
     */
    @RequestMapping(value = "/user/add")
    @ResponseBody
    public Map<String,Object> addSysUser(HttpServletRequest request){
        //获取新增用户提交过来的数据信息
        String userName  = request.getParameter("userName"  );
        String department= request.getParameter("department");
        String sex       = request.getParameter("sex"       );
        String birthday  = request.getParameter("birthday"  );
        String sfzmhm    = request.getParameter("sfzmhm"    );
        String email     = request.getParameter("email"     );
        String ipks      = request.getParameter("ipks"      );
        String ipjs      = request.getParameter("ipjs"      );
        String zhyxq     = request.getParameter("zhyxq"     );
        String mmyxq     = request.getParameter("mmyxq"     );
        String yhlx      = request.getParameter("yhlx"      );
        String lxdh      = request.getParameter("lxdh"      );
        String zt        = request.getParameter("zt"        );
        String roleIdArr = request.getParameter("roleIdArr"        );

        //用来返回信息的封装对象
        Map<String,Object> map=new HashMap<>();
        //用来返回前端的信息
        int status = 0;
        String result = "";

        //为空的参数初始化
        if(birthday ==null){
            birthday="0000-00-00";
        }
        //如果账号为空格字符,返回报错
        if(userName.trim().equals("")){
            status = 0;
            result = "isNull";
        }


        //先根据用户名去查找数据库，比对是否存在相同用户
        SysUser sysUser = sysUserService.findByUserName(userName);
        if(sysUser!=null){
            //如果存在用户，则返回错误信息
            status = 0;
            result = "havedUser";
        }else {
            //不存在，则写入新增用户信息
            sysUser = new SysUser();
            sysUser.setUserName(userName);
            sysUser.setDepartment(department);
            sysUser.setBirthday(DateUtil.strToDate(birthday));
            sysUser.setCjsj(DateUtil.getStringDate());
            sysUser.setEmail(email);
            sysUser.setGxsj(DateUtil.getStringDate());
            sysUser.setIpks(ipks);
            sysUser.setIpjs(ipjs);
            sysUser.setLxdh(lxdh);
            sysUser.setYhlx(yhlx);
            sysUser.setMmyxq(DateUtil.strToDate(mmyxq));
            sysUser.setZhyxq(DateUtil.strToDate(zhyxq));
            sysUser.setZjdlip("0.0.0.0");
            if(sex.equals("woman")){
                sysUser.setSex("女");
            }else {
                sysUser.setSex("男");
            }
            sysUser.setSfzmhm(sfzmhm);
            String password = new BCryptPasswordEncoder().encode("888888");
            sysUser.setPassword(password);
            sysUser.setZt(zt);

            //获取授权角色id
            String[] roleIdArray = roleIdArr.substring(0,roleIdArr.length()-1).split(",");
            //写入用户信息
            int returnInt = sysUserService.addSysUser(sysUser);
            //获取写入信息
            sysUser = sysUserService.findByUserName(userName);
            //再写入修改后的角色信息
            for(String str:roleIdArray){
                SysUserRole sysUserRole = new SysUserRole();
                sysUserRole.setUserId(Integer.toString(sysUser.getUserId()));
                sysUserRole.setRoleId(str);
                sysUserRoleService.addSysUserRole(sysUserRole);
            }
            if(returnInt<1) {
                status = 0;
                result = "error";
            }else {
                status = 1;
                result = "success";
            }

        }
        map.put("status",status);
        map.put("result",result);
        return map;
    }

    @RequestMapping("/user/search")
    @ResponseBody
    public void searchSysUserByUserNameOrOther(HttpServletRequest request,HttpServletResponse response) throws IOException {
        //获取新增用户提交过来的数据信息
        String userName  = request.getParameter("userName"  );
        String sfzmhm    = request.getParameter("sfzmhm"    );
        String email     = request.getParameter("email"     );
        String lxdh      = request.getParameter("lxdh"      );

        //前端获取到的页码数
        int pageNum = Integer.parseInt(request.getParameter("page"));
        //前端获取到的显示每页的数量
        int pageSize = Integer.parseInt(request.getParameter("rows"));
        //分页获取到所有用户信息
        PageHelper.startPage(pageNum,pageSize);
        List<SysUser> sysUserList = sysUserService.findByUserNameOrOther(userName,sfzmhm,lxdh,email);
        PageInfo<SysUser> pageInfo = new PageInfo<SysUser>(sysUserList);
        //获得总记录数
        long records = pageInfo.getTotal();
        //默认当前页码
        int page = pageInfo.getPageNum();
        //获得总页数
        int total = pageInfo.getPages();
        //用来序列化json数据的map
        Map<String,Object> map=new HashMap<>();
        //设置json格式写出
        map.put("rows",sysUserList);
        map.put("page",page);
        map.put("total",total);
        map.put("records",records);
        System.out.println(objectMapper.writeValueAsString(map));
        // modelAndView.addObject("rows",objectMapper.writeValueAsString(ymPersonList));
        response.setContentType("application/json;charset=utf-8");
        //map.put("ymPerson_data",ymPersonList);
        response.getWriter().write(objectMapper.writeValueAsString(map));
        response.getWriter().flush();
        response.getWriter().close();


    }




}
