package cn.com.fovsoft.ym.ctrl;/*
 * Author:tpc
 * Date:2019-11-12 17:27
 * 功能描述:贫困人员收入信息控制类
 * version:
 */

import cn.com.fovsoft.common.bean.SysMenu;
import cn.com.fovsoft.common.constant.VarConstant;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class YmPersonIncomeCtrl {

    /*
     * Author:tpc
     * Date: 2019/11/12 17:29
     * Param: [request, response]
     * Return: org.springframework.web.servlet.ModelAndView
     * 功能描述: 贫困人员收入信息表
     */
    @RequestMapping(value="/ym/income")
    public ModelAndView listPersonHtml(HttpServletRequest request, HttpServletResponse response) throws IOException {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("person-income");
        modelAndView.addObject("rootSysMenuList",request.getSession().getAttribute(VarConstant.SESSION_MENU));

        modelAndView.addObject("sessionUser",request.getSession().getAttribute(VarConstant.SESSION_USER));

        for(SysMenu sysMenu:(List<SysMenu>) request.getSession().getAttribute("rootSysMenuList")){
            System.out.println(sysMenu.getMenuName());
        }

        return modelAndView;
    }

}
