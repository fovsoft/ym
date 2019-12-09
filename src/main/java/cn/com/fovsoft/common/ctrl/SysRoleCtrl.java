package cn.com.fovsoft.common.ctrl;

import cn.com.fovsoft.common.bean.SysMenu;
import cn.com.fovsoft.common.bean.SysRole;
import cn.com.fovsoft.common.bean.SysRoleMenu;
import cn.com.fovsoft.common.bean.SysUser;
import cn.com.fovsoft.common.constant.VarConstant;
import cn.com.fovsoft.common.dto.MenuTreeDto;
import cn.com.fovsoft.common.service.SysMenuService;
import cn.com.fovsoft.common.service.SysRoleMenuService;
import cn.com.fovsoft.common.service.SysRoleService;
import cn.com.fovsoft.common.util.CollectionUtil;
import cn.com.fovsoft.common.util.DateUtil;
import cn.com.fovsoft.common.util.MenuTreeUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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

    @Autowired
    private SysRoleService sysRoleService;

    @Autowired
    private SysRoleMenuService sysRoleMenuService;


    @Autowired
    private ObjectMapper objectMapper;


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
        modelAndView.addObject("sessionUser",request.getSession().getAttribute(VarConstant.SESSION_USER));
        return modelAndView;
    }


    @RequestMapping(value = "/role/rootPermission")
    @ResponseBody
    public void listSysRolePermission(HttpServletRequest request, HttpServletResponse response) throws IOException {

        List<SysMenu> sysMenuList = sysMenuService.findAllMenu();
        //首先获取根菜单信息
        List<SysMenu> rootMenuList = new ArrayList<>();
        for(SysMenu sysMenu:sysMenuList){
            if(sysMenu.getParentId().equals("0")){
                rootMenuList.add(sysMenu);
            }
        }

        List<MenuTreeDto> menuTreeDtoList = new ArrayList<>();
        //封装菜单树对象
        for(SysMenu sysMenu:rootMenuList){
            MenuTreeDto menuTreeDto = new MenuTreeDto();
            menuTreeDto.setNodeid(sysMenu.getMenuId());
            menuTreeDto.setText(sysMenu.getMenuName());
            menuTreeDto.setNodes(new ArrayList<>());
            menuTreeDtoList.add(menuTreeDto);
        }

        //返回结果
        Map<String,Object> map = new HashMap<>();

        map.put("rootNodes",menuTreeDtoList);

        map.put("result","success");

        response.setContentType("application/json;charset=utf-8");
        //map.put("ymPerson_data",ymPersonList);
        response.getWriter().write(objectMapper.writeValueAsString(map));
        System.out.println(objectMapper.writeValueAsString(map));
        response.getWriter().flush();
        response.getWriter().close();
    }


    @RequestMapping(value = "/role/getChild")
    @ResponseBody
    public void getChildNodes(HttpServletRequest request,HttpServletResponse response) throws IOException{

        //获取传过来的菜单id
        String menuId = request.getParameter("id");
        //根据菜单id获取当前菜单的子菜单
        List<SysMenu> childMenuList = sysMenuService.findChildMenu(menuId);

        List<MenuTreeDto> menuTreeDtoList = new ArrayList<>();


        //用来指定菜单复选指定状态的map
        Map<String,Object> nodeStatMap = new HashMap<>();
        nodeStatMap.put("checked",false);
        //封装菜单树对象
        for(SysMenu sysMenu:childMenuList){
            MenuTreeDto menuTreeDto = new MenuTreeDto();
            menuTreeDto.setNodeid(sysMenu.getMenuId());
            menuTreeDto.setText(sysMenu.getMenuName());
            menuTreeDto.setNodes(new ArrayList<>());
            menuTreeDto.setState(nodeStatMap);
            menuTreeDtoList.add(menuTreeDto);
        }

        //返回结果
        Map<String,Object> map = new HashMap<>();

        map.put("childNodes",menuTreeDtoList);

        map.put("result","success");

        response.setContentType("application/json;charset=utf-8");
        //map.put("ymPerson_data",ymPersonList);
        response.getWriter().write(objectMapper.writeValueAsString(map));
        System.out.println(objectMapper.writeValueAsString(map));
        response.getWriter().flush();
        response.getWriter().close();

    }



    /*
     * Author:tpc
     * Date: 2019/11/7 20:16
     * Param: [request, response]
     * Return: void
     * 功能描述: 获取所有角色信息
     */
    @RequestMapping(value = "/role/list")
    @ResponseBody
    public void listAllSysRole(HttpServletRequest request, HttpServletResponse response) throws IOException{
        //前端获取到的页码数
        int pageNum = Integer.parseInt(request.getParameter("page"));
        //前端获取到的显示每页的数量
        int pageSize = Integer.parseInt(request.getParameter("rows"));
        //分页获取到所有用户信息
        PageHelper.startPage(pageNum,pageSize);
        List<SysRole> sysRoleList = sysRoleService.findAllSysRole();
        PageInfo<SysRole> pageInfo = new PageInfo<>(sysRoleList);
        //获得总记录数
        long records = pageInfo.getTotal();
        //默认当前页码
        int page = pageInfo.getPageNum();
        //获得总页数
        int total = pageInfo.getPages();
        //用来序列化json数据的map
        Map<String,Object> map=new HashMap<>();
        //设置json格式写出
        map.put("rows",sysRoleList);
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
    }


    @RequestMapping(value = "/role/search")
    @ResponseBody
    public void searchSysRoleByRoleName(HttpServletRequest request,HttpServletResponse response) throws IOException{
        //获取查询角色提交过来的数据信息
        String roleName  = request.getParameter("roleName"  );

        //前端获取到的页码数
        int pageNum = Integer.parseInt(request.getParameter("page"));
        //前端获取到的显示每页的数量
        int pageSize = Integer.parseInt(request.getParameter("rows"));
        //分页获取到所有用户信息
        PageHelper.startPage(pageNum,pageSize);
        List<SysRole> sysRoleList = sysRoleService.findSysRoleLikeRoleName(roleName);
        PageInfo<SysRole> pageInfo = new PageInfo<>(sysRoleList);
        //获得总记录数
        long records = pageInfo.getTotal();
        //默认当前页码
        int page = pageInfo.getPageNum();
        //获得总页数
        int total = pageInfo.getPages();
        //用来序列化json数据的map
        Map<String,Object> map=new HashMap<>();
        //设置json格式写出
        map.put("rows",sysRoleList);
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
    }



    /*
     * Author:tpc
     * Date: 2019/11/8 19:42
     * Param:
     * Return:
     * 功能描述: 添加角色功能实现
     */

    @RequestMapping(value = "/role/add")
    @ResponseBody
    public Map<String,Object> addSysRole(HttpServletRequest request){

        //获取提交过来的角色信息
        String roleId  = request.getParameter("roleId"  );
        String roleName = request.getParameter("roleName");
        String description   = request.getParameter("description"       );
        String zt  = request.getParameter("zt"  );
        String idArray    = request.getParameter("idArray" );

        System.out.println(idArray.substring(0,idArray.length()-1));
        //获取菜单id
        String[] menuIdArray = CollectionUtil.StrArrayDuplicateRemoval(idArray.substring(0,idArray.length()-1).split(","));



        //用来返回信息的封装对象
        Map<String,Object> map=new HashMap<>();
        //用来返回前端的信息
        int status = 0;
        String result = "";

        //如果账号为空格字符,返回报错
        if(roleName.trim().equals("")){
            status = 0;
            result = "isNull";
        }


        //先根据用户名去查找数据库，比对是否存在相同用户
        SysRole sysRole = sysRoleService.findSysRoleByRoleName(roleName);

        if(sysRole!=null){
            //如果存在用户，则返回错误信息
            status = 0;
            result = "havedRole";
        }else {
            //不存在的话，写入数据库
            sysRole = new SysRole();
            sysRole.setRoleName(roleName);
            sysRole.setDescription(description);
            sysRole.setZt(zt);
            sysRole.setCjsj(DateUtil.getStringDate());
            sysRole.setGxsj(DateUtil.getStringDate());

            //写入角色信息
            int resultInt = sysRoleService.addSysRole(sysRole);


            //获取写入角色id
            sysRole = sysRoleService.findSysRoleByRoleName(roleName);
            String newRoleId = sysRole.getRoleId();

            for(String str:menuIdArray){
                SysRoleMenu sysRoleMenu = new SysRoleMenu();
                sysRoleMenu.setRoleId(newRoleId);
                sysRoleMenu.setMenuId(str);
                //写入角色权限
                sysRoleMenuService.addSysRoleMenu(sysRoleMenu);
            }

            if(resultInt<1) {
                status = 0;
                result = "error";
            }else {
                status = 1;
                result = "success";
            }

        }

        map.put("status",status);
        map.put("result",result);

        return map;

    }


    /**
     * @author: tpc
     * @date: 2019/11/9 12:26
     * @description: 点击修改按钮，响应菜单树信息，把拥有的菜单设置为选中的
     */
    @RequestMapping(value = "/role/listSelfPermission")
    @ResponseBody
    public void listSelfPermission(HttpServletRequest request,HttpServletResponse response) throws IOException{

        //获取提交过来的角色信息
        String roleId  = request.getParameter("roleId"  );
        String roleName = request.getParameter("roleName");
        String description   = request.getParameter("description"       );
        String zt  = request.getParameter("zt"  );
        //用来返回信息的封装对象
        Map<String,Object> map=new HashMap<>();
        //用来返回前端的信息
        int status = 0;
        String result = "";

        //根据角色id查找到角色对应的菜单权限信息
        List<SysMenu> privsMenuList = sysMenuService.findMenuByRoleId(roleId);
        //拿到所有的菜单权限信息
        List<SysMenu> sysMenuList = sysMenuService.findAllMenu();
        //首先获取根菜单信息
        List<SysMenu> rootMenuList = new ArrayList<>();
        for(SysMenu sysMenu:sysMenuList){
            if(sysMenu.getParentId().equals("0")){
                rootMenuList.add(sysMenu);
            }
        }

        //用来封装节点树的list
        List<MenuTreeDto> menuTreeDtoList = new ArrayList<>();

        //用来记录是否包含关系的
        boolean containTree = false;

        //封装菜单树对象
        for(SysMenu sysMenu:rootMenuList){
            MenuTreeDto menuTreeDto = new MenuTreeDto();
            menuTreeDto.setNodeid(sysMenu.getMenuId());
            menuTreeDto.setText(sysMenu.getMenuName());

            for(SysMenu sysMenu1:privsMenuList){
                if (sysMenu.getMenuId().equals(sysMenu1.getMenuId())){
                    containTree = true;
                }
            }
            //用来封装是否选中的map
            Map<String,Object> checkedMap = new HashMap<>();
            if(containTree){

                checkedMap.put("checked",true);
                checkedMap.put("expanded",true);
            }else {

                checkedMap.put("checked",false);
                checkedMap.put("expanded",false);

            }
            menuTreeDto.setState(checkedMap);
            containTree = false;
            //封装子菜单
            menuTreeDto.setNodes(MenuTreeUtil.getChildNodes(sysMenu.getMenuId(),sysMenuList,privsMenuList));
            menuTreeDtoList.add(menuTreeDto);
        }

        map.put("treeNodes",menuTreeDtoList);

        map.put("result","success");

        response.setContentType("application/json;charset=utf-8");
        //map.put("ymPerson_data",ymPersonList);
        response.getWriter().write(objectMapper.writeValueAsString(map));
        System.out.println(objectMapper.writeValueAsString(map));
        response.getWriter().flush();
        response.getWriter().close();
        response.getWriter().close();

    }





    @RequestMapping(value = "/role/edit")
    @ResponseBody
    public Map<String,Object> editSysRole(HttpServletRequest request){
        //获取提交过来的角色信息
        String roleId  = request.getParameter("roleId"  );
        String roleName = request.getParameter("roleName");
        String description   = request.getParameter("description"       );
        String zt  = request.getParameter("zt"  );
        String idArray    = request.getParameter("idArray" );

        System.out.println(idArray.substring(0,idArray.length()-1));
        //获取菜单id
        String[] menuIdArray = CollectionUtil.StrArrayDuplicateRemoval(idArray.substring(0,idArray.length()-1).split(","));



        //用来返回信息的封装对象
        Map<String,Object> map=new HashMap<>();
        //用来返回前端的信息
        int status = 0;
        String result = "";

        //如果账号为空格字符,返回报错
        if(roleName.trim().equals("")){
            status = 0;
            result = "isNull";
        }

        //提交修改的角色信息
        SysRole sysRole = new SysRole();
        sysRole.setRoleId(roleId);
        sysRole.setRoleName(roleName);
        sysRole.setDescription(description);
        sysRole.setZt(zt);
        sysRole.setGxsj(DateUtil.getStringDate());
        sysRoleService.updateSysRole(sysRole);

        //删除角色原有权限信息
        sysRoleMenuService.deleteSysRoleMenuByRoleId(roleId);
        //再写入新的角色权限信息
        SysRoleMenu sysRoleMenu = new SysRoleMenu();
        for(String str:menuIdArray){
            sysRoleMenu.setRoleId(roleId);
            sysRoleMenu.setMenuId(str);
            //写入角色权限
            sysRoleMenuService.addSysRoleMenu(sysRoleMenu);
        }

        status = 2;
        result = "success";

        map.put("status",status);
        map.put("result",result);

        return map;


    }


    @RequestMapping(value = "/role/delete")
    @ResponseBody
    public Map<String,Object> deleteSysRole(HttpServletRequest request){


        //获取封装的角色id信息
        String idArray = request.getParameter("idArr");
        idArray = idArray.substring(0,idArray.length()-1);

        Map<String,Object> map = new HashMap<>();
        int status = 0;
        String result = "error";


        System.out.println("角色id"+idArray);

        //获取选中行的所有id，存入数组中
        if(idArray.length()==1){
            //先删权限信息
            sysRoleMenuService.deleteSysRoleMenuByRoleId(idArray);
            //再删角色信息
            int resultInt = sysRoleService.deleteSysRole(idArray);
            status = 1;
            result = "success";
        }else {
            String[] userIdArray = idArray.split(",");
            for(String str:userIdArray){
                //先删权限信息
                sysRoleMenuService.deleteSysRoleMenuByRoleId(str);
                //再删角色信息
                int resultInt = sysRoleService.deleteSysRole(str);
            }
            status = 1;
            result = "success";
        }
        map.put("status",status);
        map.put("result",result);

        return map;
    }


    @RequestMapping(value = "/role/deleteOne")
    @ResponseBody
    public Map<String,Object> deleteSysRoleOne(HttpServletRequest request){


        Map<String,Object> map = new HashMap<>();
        int status = 0;
        String result = "error";
        //获取封装的角色id信息
        String roleId = request.getParameter("roleId");
        //先删权限信息
        sysRoleMenuService.deleteSysRoleMenuByRoleId(roleId);
        //再删角色信息
        int resultInt = sysRoleService.deleteSysRole(roleId);
        if(resultInt>0){

            status = 1;
            result = "success";
        }
        map.put("status",status);
        map.put("result",result);

        return map;
    }



}
