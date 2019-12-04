package cn.com.fovsoft.ym.ctrl;

import cn.com.fovsoft.common.constant.VarConstant;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author by tpc
 * @Date 2019/12/4 22:30
 * description:
 **/

@Controller
public class YmTestCtrl {


    @RequestMapping(value="/ym/img")
    public ModelAndView addYmInformation(HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("test-ym-information");
        modelAndView.addObject("rootSysMenuList",request.getSession().getAttribute(VarConstant.SESSION_MENU));
        modelAndView.addObject("sessionUser",request.getSession().getAttribute(VarConstant.SESSION_USER));

        return modelAndView;
    }
}
