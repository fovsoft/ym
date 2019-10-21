package cn.com.fovsoft.ym.ctrl;

import cn.com.fovsoft.common.bean.SysMenu;
import cn.com.fovsoft.common.constant.VarConstant;
import cn.com.fovsoft.ym.bean.YmPerson;
import cn.com.fovsoft.ym.service.YmPersonService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author by tpc
 * @Date 2019/10/20 16:21
 * description: 贫困人员控制类
 **/

@Controller
public class YmPersonCtrl {


    //注入贫困人员服务类
    @Autowired
    private YmPersonService ymPersonService;


    @Autowired
    private ObjectMapper objectMapper;

    /*
     * @author: tpc
     * @date: 2019/10/20 16:39
     * @description: 响应前端页面的贫困人员信息展示按钮，列出所有贫困人员信息
     */
    @RequestMapping(value = "/ym/all",method = RequestMethod.POST)
    @ResponseBody
    public void FindPerson(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //获取到所有用户信息
        List<YmPerson> ymPersonList = ymPersonService.findAllYmPerson();
        //用来序列化json数据的map
        Map<String,Object> map=new HashMap<>();
        //设置json格式写出
        response.setContentType("application/json;charset=utf-8");
       map.put("ymPerson_data",ymPersonList);
        response.getWriter().write(objectMapper.writeValueAsString(map));
        response.getWriter().flush();
        response.getWriter().close();
    }

    @RequestMapping(value="/ym/add")
    public ModelAndView listPersonHtml(HttpServletRequest request){

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("list-person");
        modelAndView.addObject("rootSysMenuList",request.getSession().getAttribute(VarConstant.SESSION_MENU));
        for(SysMenu sysMenu:(List<SysMenu>) request.getSession().getAttribute("rootSysMenuList")){
            System.out.println(sysMenu.getMenuName());
        }

        return modelAndView;
    }
}
