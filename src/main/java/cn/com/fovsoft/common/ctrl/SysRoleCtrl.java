package cn.com.fovsoft.common.ctrl;

import cn.com.fovsoft.common.bean.SysMenu;
import cn.com.fovsoft.common.constant.VarConstant;
import cn.com.fovsoft.common.service.SysMenuService;
import cn.com.fovsoft.common.util.MenuTreeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author by tpc
 * @Date 2019/11/6 21:49
 * description:用户角色管理控制类
 **/

@Controller
public class SysRoleCtrl {

    @Autowired
    private SysMenuService sysMenuService;


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


    @RequestMapping(value = "/role/permission")
    @ResponseBody
    public Map<String,Object> listSysRolePermission(HttpServletRequest request, HttpServletResponse response){

        List<SysMenu> sysMenuList = sysMenuService.findAllMenu();
        //首先获取根菜单信息
        List<SysMenu> rootMenuList = new ArrayList<>();
        for(SysMenu sysMenu:sysMenuList){
            if(sysMenu.getParentId().equals("0")){
                rootMenuList.add(sysMenu);
            }
        }
        //接下来递归获取所有根菜单的子菜单信息
        for(SysMenu sysMenu:rootMenuList){
            sysMenu.setChildMenuList(MenuTreeUtil.getChilds(sysMenu.getMenuId(),sysMenuList));
        }

        //返回结果
        Map<String,Object> map = new HashMap<>();
        map.put("rootMenuList",rootMenuList);
        map.put("result","success");

        //最终返回菜单树形结构
        return map;
    }
}
