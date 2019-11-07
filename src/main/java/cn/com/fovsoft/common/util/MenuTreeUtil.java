package cn.com.fovsoft.common.util;

import cn.com.fovsoft.common.bean.SysMenu;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: by tpc
 * @date: 2019/11/1 10:37
 * @description:根据一级菜单id获取子菜单列表
 **/
public class MenuTreeUtil {


    public static List getChilds(String menuId, List<SysMenu> MenuList){

        //子菜单
        List<SysMenu> childList = new ArrayList<SysMenu>();

        if (MenuList.size()>0){
            for(SysMenu sysMenu:MenuList){
                if(sysMenu.getParentId().equals(menuId)){
                    childList.add(sysMenu);
                }
            }
        }

        if(childList.size()<1){
            return null;
        }

        for(SysMenu sysMenu:childList){
            //递归
            sysMenu.setChildMenuList(getChilds(sysMenu.getMenuId(),MenuList));
        }



        return childList;


    }

}
