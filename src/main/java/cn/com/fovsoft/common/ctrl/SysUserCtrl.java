package cn.com.fovsoft.common.ctrl;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SysUserCtrl {

    @RequestMapping("/whoim")
    @ResponseBody
    private Object whoIm()
    {
        System.out.println("是否已经验证："+SecurityContextHolder.getContext().getAuthentication().isAuthenticated());

        return SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    /*/**
     * @author: tpc
     * @date: 2019/10/15
     * @description: 对应系统管理菜单
     */
    public String sysUserAdmin(){
        return null;
    }


}
