package cn.com.fovsoft.common.ctrl;

import cn.com.fovsoft.common.bean.SysUser;
import cn.com.fovsoft.common.constant.VarConstant;
import cn.com.fovsoft.common.service.CustomUserDetailsService;
import cn.com.fovsoft.common.service.SysUserService;
import cn.com.fovsoft.common.util.VerifyStringEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;


@Controller
public class SysUserLoginCtrl {

    @Autowired
    private SessionRegistry sessionRegistry;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Autowired
    private SysUserService sysUserService;

    @RequestMapping(value = "/")
    public String userlogin1(ModelMap mp) {
        //mp.addAttribute("sysUser", new SysUser());
        System.out.println("startup ..........");
        return "login";
    }
//    @RequestMapping(value = "/login")
//    public String userToLogin(ModelMap mp) {
//        //mp.addAttribute("sysUser", new SysUser());
//        System.out.println("startup ..........");
//        return "login";
//    }

    @RequestMapping(value = "/logout")
    public String userLogout(HttpServletRequest request){
        String sessionId = request.getRequestedSessionId();
        sessionRegistry.removeSessionInformation(sessionId);
        return"redirect:/login";

    }

    @RequestMapping(value = "/login_page",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> loginPage() {
        String result = "needlogin";
        Integer status = 0;
        Map<String, Object> mp = new HashMap<>();
        mp.put("status",status);
        mp.put("result",result);
        return mp;
    }





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

    @RequestMapping("/index")
    public String loginToIndex(){
        return "index";
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
