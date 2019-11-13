package cn.com.fovsoft.common.ctrl;


import cn.com.fovsoft.common.bean.SysMenu;
import cn.com.fovsoft.common.bean.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@Controller
public class SysUserLoginCtrl {

    @Autowired
    private SessionRegistry sessionRegistry;

    /**
     * 功能描述:实现登录页面跳转
     * @param mp
     * @return
     */
    @RequestMapping(value = "/")
    public String userlogin1(ModelMap mp) {
        return "login";
    }

    /**
     * 功能描述：当指定路径/login时，实现登录页面跳转
     * @param mp
     * @return
     */
    @RequestMapping(value = "/login" ,method = RequestMethod.GET)
    public String userToLogin(ModelMap mp) {
        return "login";
    }

    //当注销时，跳转到登录页面
    @RequestMapping(value = "/logout")
    public String userLogout(HttpServletRequest request){
        String sessionId = request.getRequestedSessionId();
        sessionRegistry.removeSessionInformation(sessionId);
        return "redirect:/login";

    }

//    @GetMapping(value = "/login_page")
//    @ResponseBody
//    public Map<String,Object> loginPage() {
//        String result = "needlogin";
//        Integer status = 0;
//        Map<String, Object> mp = new HashMap<>();
//        mp.put("status",status);
//        mp.put("result",result);
//        return mp;
//    }

//    @GetMapping("/login_page")
//    @ResponseBody
//    public Object loginPage() {
//        return new BaseResult(ReturnCode.FAILED.getCode(), "尚未登录，请登录!");
//    }





//    @RequestMapping(value = "/loginCheck", method = RequestMethod.POST)
//    @ResponseBody
//    public Map<String, Object> userLoginCheck(HttpServletRequest request){
//
//        //返回给前端的信息
//        Map<String, Object> mp = new HashMap<>();
//        //返回的错误信息
//        String result = "";
//        //状态
//        Integer status = 0;
//        //获取到的登陆数据信息
//        String loginData[] = request.getParameter("LOGINDATA").split(",");
//        if (loginData != null && loginData.length == 3) {
//
//            //获取验证码
//            String verifyCode = loginData[2];
//            String sessionVerifyCode = (String)request.getSession().getAttribute(VarConstant.SESSION_VERIFY_CODE);
//            //检查
//            if (VerifyStringEmpty.isEmpty(verifyCode)) {
//                status = 0;
//                result = "nullcode";
//            }else{
//                String userName = loginData[0];
//                String password = loginData[1];
//
//                //判断session中验证码是否为空
//                if(VerifyStringEmpty.isNotEmpty(sessionVerifyCode)&&verifyCode.equals(sessionVerifyCode)){
//                    System.out.println(userName);
//                    System.out.println(password);
//                    SysUser sysUser = sysUserService.findByUserNameAndPwd(userName,password);
//                    if(sysUser != null){
//                        if(sysUser.getZt()=="2"){
//                            status = 0 ;
//                            result = "locked";
//                        }else {
//                            customUserDetailsService.setSysUser(sysUser);
//                            customUserDetailsService.loadUserByUsername(userName);
//                            request.getSession().removeAttribute(VarConstant.SESSION_VERIFY_CODE);
//                            String ip = getIpAddress(request);
//                            sysUserService.updateUserZjdlip(ip, userName);
//                            //代表登陆成功
//                            status = 1;
//                            result = "success";
//                        }
//
//                    }else {
//                        //账号或者密码错误
//                        status = 0;
//                        result = "uerror";
//                    }
//                }else {
//                    //验证码错误
//                    status = 0 ;
//                    result = "codeerror";
//                }
//            }
//
//        }


//        System.out.println(result);
//        System.out.println(status);
//        mp.put("status", status);
//        mp.put("result", result);
//        return mp;
//    }

    
    /*
     * @author: tpc
     * @date: 2019/10/15
     * @description: 根据权限信息加载菜单
     */
    @RequestMapping("/index")
    public ModelAndView loginToIndex(HttpServletRequest request){

        //返回对象
        ModelAndView modelAndView = new ModelAndView();

        System.out.println("是否已经验证："+SecurityContextHolder.getContext().getAuthentication().isAuthenticated());

        System.out.println("是否已经验证："+SecurityContextHolder.getContext().getAuthentication().getPrincipal());

        //获取验证信息
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        //首先判断用户有没有验证，验证了，则响应请求进入主页，如果没有验证，则进入登录页面
        if(authentication.isAuthenticated()){

            //用来存放所有菜单的list
            List<SysMenu> allSysMenusList = new ArrayList<>();
            //用来存放根菜单的list
            List<SysMenu> rootSysMenuList = new ArrayList<>();
            for(GrantedAuthority authority : authentication.getAuthorities()){
                System.out.println(authority.getAuthority());
                //获取菜单信息，menuStrArray总共有9个元素，分别对应 菜单id-菜单父id-菜单名字-菜单css-菜单url-菜单类型-权限-排序-状态
                String[] menuStrArray = authority.getAuthority().split(";");
                //获取SysMenu封装信息
                SysMenu sysMenu = getMenuList(menuStrArray);
                //判断是否是根菜单，如果是的就存入根菜单列表
                if(sysMenu.getParentId().equals("0")){
                    rootSysMenuList.add(sysMenu);
                }
                //把菜单存入所有菜单列表
                allSysMenusList.add(sysMenu);
            }


            //把根菜单的子菜单注入到根菜单list中
            for(SysMenu sysMenu:rootSysMenuList){
                sysMenu.setChildMenuList(getChildMenuList(sysMenu.getMenuId(),allSysMenusList));

            }
//            try {
//                response.getWriter().print(rootSysMenuList);
//                response.
//            } catch (IOException e) {
//                e.printStackTrace();
//            }

            //把菜单信息写入session
            request.getSession().setAttribute("rootSysMenuList",rootSysMenuList);
            User user = (User)authentication.getPrincipal();
            request.getSession().setAttribute("sysUser",user.getUsername());
            modelAndView.addObject("sessionUser",user.getUsername());
            modelAndView.addObject("rootSysMenuList",rootSysMenuList);
            modelAndView.setViewName("index");
        }else {
            modelAndView.setViewName("redirect:/login");
        }

        return modelAndView;
    }


    /*
     * @author: by tpc
     * @date: 2019/10/16
     * @description: 封装用户菜单信息
     */
    public SysMenu getMenuList(String[] menuStrArray){
        SysMenu sysMenu = new SysMenu();
        sysMenu.setMenuId(menuStrArray[0]);
        sysMenu.setParentId(menuStrArray[1]);
        sysMenu.setMenuName(menuStrArray[2]);
        sysMenu.setCss(menuStrArray[3]);
        sysMenu.setUrl(menuStrArray[4]);
        sysMenu.setType(menuStrArray[5]);
        sysMenu.setPermission(menuStrArray[6]);
        sysMenu.setSequence(Integer.parseInt(menuStrArray[7]));
        sysMenu.setZt(menuStrArray[8]);
        return sysMenu;
    }

    /**
     * @author: tpc
     * @date: 2019/10/16 21:50
     * @description:  通过父菜单id与菜单列表进行比对，获取所有子菜单。
     */

    public List<SysMenu> getChildMenuList(String id, List<SysMenu> allSysMenuList){
        //子菜单列表
        List<SysMenu> childMenuList = new ArrayList<>();
        for(SysMenu sysMenu:allSysMenuList){
            //遍历所有节点，将父菜单id传过来的id比较
            if(sysMenu.getParentId().equals(id)){
                childMenuList.add(sysMenu);
            }
        }
        return childMenuList;
    }


    @RequestMapping("/login-error")
    public String loginError()

    {
        return "error-404";
    }



    /**
     *功能描述:获取用户ip
     * @author tpc
     * @date 2019/10/12
     * @param
     * @return java.lang.String
     */

    public String getIpAddress(HttpServletRequest request){

        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
}
