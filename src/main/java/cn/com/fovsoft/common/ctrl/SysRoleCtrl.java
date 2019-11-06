package cn.com.fovsoft.common.ctrl;

import cn.com.fovsoft.common.constant.VarConstant;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author by tpc
 * @Date 2019/11/6 21:49
 * description:用户角色管理控制类
 **/

@Controller
public class SysRoleCtrl {


    /**
     * @author: tpc
     * @date: 2019/11/6 22:10
     * @description: 跳转到角色管理界面的界面
     */
    @RequestMapping(value = "/admin/role")
    public ModelAndView listSysRole(HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("sysrole");
        modelAndView.addObject("rootSysMenuList",request.getSession().getAttribute(VarConstant.SESSION_MENU));

        return modelAndView;
    }
}
