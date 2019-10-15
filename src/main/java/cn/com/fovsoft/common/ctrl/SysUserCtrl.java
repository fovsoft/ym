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
        return SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

}
