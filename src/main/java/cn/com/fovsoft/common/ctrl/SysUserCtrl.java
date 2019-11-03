package cn.com.fovsoft.common.ctrl;

import cn.com.fovsoft.common.bean.SysUser;
import cn.com.fovsoft.common.constant.VarConstant;
import cn.com.fovsoft.common.service.SysUserService;
import cn.com.fovsoft.ym.bean.YmPerson;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

        return modelAndView;
    }


    /**
     * @author: tpc
     * @date: 2019/11/2 21:47
     * @description: 展示所有用户信息
     */

    @RequestMapping(value = "/user/list",method = RequestMethod.POST)
    @ResponseBody
    public void listSysUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
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




}
