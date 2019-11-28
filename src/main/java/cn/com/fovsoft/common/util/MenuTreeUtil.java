package cn.com.fovsoft.common.util;

import cn.com.fovsoft.common.bean.SysMenu;
import cn.com.fovsoft.common.dto.MenuTreeDto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: by tpc
 * @date: 2019/11/1 10:37
 * @description:根据一级菜单id获取子菜单列表
 **/
public class MenuTreeUtil {



    /*
     * Author:tpc
     * Date: 2019/11/7 16:05
     * Param:
     * Return:
     * 功能描述: 迭代获取所有菜单
     */
    public static List getChilds(String menuId, List<SysMenu> menuList){

        //子菜单
        List<SysMenu> childList = new ArrayList<SysMenu>();

        if (menuList.size()>0){
            for(SysMenu sysMenu:menuList){
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
            sysMenu.setChildMenuList(getChilds(sysMenu.getMenuId(),menuList));
        }

        return childList;

    }



    public static List getChildNodes(String menuId, List<SysMenu> menuList,List<SysMenu> checkedMenuList){
        //用来存放菜单树节点的list
        List<MenuTreeDto> childNodeList = new ArrayList<>();



        //用来记录是否包含关系的
        boolean containTree = false;

        if (menuList.size()>0){
            for(SysMenu sysMenu:menuList){
                if(sysMenu.getParentId().equals(menuId)){
                    MenuTreeDto menuTreeDto= new MenuTreeDto();
                    menuTreeDto.setText(sysMenu.getMenuName());
                    menuTreeDto.setNodeid(sysMenu.getMenuId());
                    for(SysMenu sysMenu1:checkedMenuList){
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
                    childNodeList.add(menuTreeDto);
                    containTree = false;
                }

            }
        }

        if(childNodeList.size()<1){
            return null;
        }

        for(MenuTreeDto menuTreeDto:childNodeList){
            //递归
            menuTreeDto.setNodes(getChildNodes(menuTreeDto.getNodeid(),menuList,checkedMenuList));
        }

        return childNodeList;
    }


//    /*
//     * Author:tpc
//     * Date: 2019/11/7 16:38
//     * Param: [menuList]
//     * Return: java.lang.String
//     * 功能描述:  封装菜单json
//     */
//    public static String getMenuJson(List<SysMenu> menuList){
//        if(menuList.size()==1){
//            return "{ text:"+"\""+menuList.get(0).getMenuName()+"\",nodes:\"\"}";
//        }
//
//        String menuJson = " ";
//        for(SysMenu sysMenu:menuList){
//            menuJson = menuJson+"{text : \""+sysMenu.getMenuName()+"\",nodes:\"\"},";
//        }
//        menuJson = menuJson.substring(0,menuJson.length()-1);
//        return menuJson;
//    }
}
