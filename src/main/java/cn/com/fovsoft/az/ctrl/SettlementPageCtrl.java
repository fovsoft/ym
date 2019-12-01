package cn.com.fovsoft.az.ctrl;/*
 * @Author:tpc
 * @Date: 2019/11/29 17:32
 * 功能描述:安置管理菜单url跳转控制类
 * @version:
 */

import cn.com.fovsoft.common.bean.SysMenu;
import cn.com.fovsoft.common.constant.VarConstant;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class SettlementPageCtrl {


    /*
     * Author:tpc
     * Date: 2019/11/29 17:37
     * Param: [request]
     * Return: org.springframework.web.servlet.ModelAndView
     * 功能描述: 调整到新增安置户信息的页面
     */
    @RequestMapping("/az/add")
    public ModelAndView toAddSettlementHouseholdPage(HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("add-settlement-household");
        modelAndView.addObject("rootSysMenuList",request.getSession().getAttribute(VarConstant.SESSION_MENU));

        modelAndView.addObject("sessionUser",request.getSession().getAttribute(VarConstant.SESSION_USER));

        return modelAndView;
    }


    @RequestMapping("/az/household")
    public ModelAndView toSettlementHouseholdMgr(HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("settlement-household-mgr");
        modelAndView.addObject("rootSysMenuList",request.getSession().getAttribute(VarConstant.SESSION_MENU));

        modelAndView.addObject("sessionUser",request.getSession().getAttribute(VarConstant.SESSION_USER));

        return modelAndView;
    }


    @RequestMapping("/az/settlement")
    public ModelAndView toSettlement(HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("settlement-household-mgr");
        modelAndView.addObject("rootSysMenuList",request.getSession().getAttribute(VarConstant.SESSION_MENU));

        modelAndView.addObject("sessionUser",request.getSession().getAttribute(VarConstant.SESSION_USER));

        return modelAndView;
    }


}
