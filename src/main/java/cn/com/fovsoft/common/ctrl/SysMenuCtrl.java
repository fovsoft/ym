package cn.com.fovsoft.common.ctrl;

import cn.com.fovsoft.common.constant.VarConstant;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: by tpc
 * @date: 2019/11/1 17:00
 * @description:菜单控制类
 **/

@Controller
public class SysMenuCtrl {

    @RequestMapping("/admin/sysMenu")
    public ModelAndView listSysMenu(HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("menu");
        modelAndView.addObject("rootSysMenuList",request.getSession().getAttribute(VarConstant.SESSION_MENU));
        modelAndView.addObject("sessionUser",request.getSession().getAttribute(VarConstant.SESSION_USER));
        return modelAndView;
    }
}
