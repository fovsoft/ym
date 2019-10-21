package cn.com.fovsoft.ym.ctrl;

import cn.com.fovsoft.common.bean.SysMenu;
import cn.com.fovsoft.common.constant.VarConstant;
import cn.com.fovsoft.ym.bean.YmPerson;
import cn.com.fovsoft.ym.service.YmPersonService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
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
    public void FindPerson(HttpServletRequest request,HttpServletResponse response) throws IOException {
//        for(Enumeration e= request.getParameterMap();e.hasMoreElements();){
//            System.out.println(e.nextElement());
//        }
        //ModelAndView modelAndView = new ModelAndView();
//        int pageNo = (int)request.getAttribute("page");
//        int pageSize = (int)request.getAttribute("rowNum");
//        System.out.print(pageNo+"  "+pageSize);
        //分页获取到所有用户信息
        System.out.println(request.getParameter("page"));
        PageHelper.startPage(1,10);
        List<YmPerson> ymPersonList = ymPersonService.findAllYmPerson();
        PageInfo<YmPerson> pageInfo = new PageInfo<YmPerson>(ymPersonList);
        //获得总记录数
        long records = pageInfo.getTotal();
        //默认当前页码
        int page = 1;
        //获得总页数
        int total = pageInfo.getPages();
        //用来序列化json数据的map
        Map<String,Object> map=new HashMap<>();
        //设置json格式写出
        map.put("rows",ymPersonList);
        map.put("page",page);
        map.put("total",total);
        map.put("records",records);
        System.out.println(objectMapper.writeValueAsString(map));
       // modelAndView.addObject("rows",objectMapper.writeValueAsString(ymPersonList));
        response.setContentType("application/json;charset=utf-8");
        //map.put("ymPerson_data",ymPersonList);
        response.getWriter().write(objectMapper.writeValueAsString(map));
        response.getWriter().flush();
        response.getWriter().close();
//        return modelAndView;
    }

    @RequestMapping(value="/ym/add")
    public ModelAndView listPersonHtml(HttpServletRequest request,HttpServletResponse response) throws IOException{

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("list-person");
        modelAndView.addObject("rootSysMenuList",request.getSession().getAttribute(VarConstant.SESSION_MENU));

        for(SysMenu sysMenu:(List<SysMenu>) request.getSession().getAttribute("rootSysMenuList")){
            System.out.println(sysMenu.getMenuName());
        }

        return modelAndView;
    }
}
