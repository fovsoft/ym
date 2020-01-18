package cn.com.fovsoft.ym.controller;

import cn.com.fovsoft.common.bean.SysMenu;
import cn.com.fovsoft.ym.service.FamilySerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class QueryController {

//    @Autowired
//    IncomeSerivce familySerivce;

    @RequestMapping(value = "/query")
    public String index() {
        return "/query/index";
    }

    @RequestMapping(value = "/query/family")
    public String family(ModelMap model, String jtbh) {
        model.addAttribute("id", jtbh);
        return "/query/family";
    }

    @RequestMapping(value = "/query2")
    public ModelAndView index2(HttpServletRequest request) {

        //返回对象
        ModelAndView modelAndView = new ModelAndView();

        //获取验证信息
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        //首先判断用户有没有验证，验证了，则响应请求进入主页，如果没有验证，则进入登录页面
        if(authentication.isAuthenticated()){

            //用来存放所有菜单的list
            List<SysMenu> allSysMenusList = new ArrayList<>();
            //用来存放根菜单的list
            List<SysMenu> rootSysMenuList = new ArrayList<>();
            for(GrantedAuthority authority : authentication.getAuthorities()){
                System.out.println(authority.getAuthority());
                String[] menuStrArray = authority.getAuthority().split(";");
                SysMenu sysMenu = getMenuList(menuStrArray);
                if(sysMenu.getParentId().equals("0")){
                    rootSysMenuList.add(sysMenu);
                }
                allSysMenusList.add(sysMenu);
            }


            //把根菜单的子菜单注入到根菜单list中
            for(SysMenu sysMenu:rootSysMenuList){
                sysMenu.setChildMenuList(this.getChildMenuList(sysMenu.getMenuId(),allSysMenusList));

            }


            //把菜单信息写入session
            request.getSession().setAttribute("rootSysMenuList",rootSysMenuList);
            User user = (User)authentication.getPrincipal();
            request.getSession().setAttribute("sessionUser",user.getUsername());
            modelAndView.addObject("sessionUser",user.getUsername());
            modelAndView.addObject("rootSysMenuList",rootSysMenuList);
            modelAndView.setViewName("/query/index");
        }else {
            modelAndView.setViewName("redirect:/login");
        }

        return modelAndView;

    }

    /*
     * @author: by tpc
     * @date: 2019/10/16
     * @description: 封装用户菜单信息
     */
    private SysMenu getMenuList(String[] menuStrArray){
        SysMenu sysMenu = new SysMenu();
        sysMenu.setMenuId(menuStrArray[0]);
        sysMenu.setParentId(menuStrArray[1]);
        sysMenu.setMenuName(menuStrArray[2]);
        sysMenu.setCss(menuStrArray[3]);
        sysMenu.setUrl(menuStrArray[4]);
        sysMenu.setType(menuStrArray[5]);
        sysMenu.setPermission(menuStrArray[6]);
        sysMenu.setSequence(Integer.parseInt(menuStrArray[7]));
        sysMenu.setZt(menuStrArray[8]);
        return sysMenu;
    }


    private List<SysMenu> getChildMenuList(String id, List<SysMenu> allSysMenuList){
        //子菜单列表
        List<SysMenu> childMenuList = new ArrayList<>();
        for(SysMenu sysMenu:allSysMenuList){
            //遍历所有节点，将父菜单id传过来的id比较
            if(sysMenu.getParentId().equals(id)){
                childMenuList.add(sysMenu);
            }
        }
        return childMenuList;
    }

}
