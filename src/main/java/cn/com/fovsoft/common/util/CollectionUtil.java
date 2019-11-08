package cn.com.fovsoft.common.util;/*
 * Author:tpc
 * Date: 2019-11-08 12:54
 * 功能描述:
 * version:
 */

import java.util.*;

public class CollectionUtil {


    /*
     * Author:tpc
     * Date: 2019/11/8 12:55
     * Param: [ioList]
     * Return: void
     * 功能描述:  list去重
     */
    public static List stringDuplicateRemoval(List<String> ioList)
    {
        LinkedHashSet<String> tmpSet = new LinkedHashSet<String>(ioList.size());
        tmpSet.addAll(ioList);
        ioList.clear();
        ioList.addAll(tmpSet);
        return ioList;
    }


    public static String[] StrArrayDuplicateRemoval(String [] arr){
        Map<String, Object> map = new HashMap<String, Object>();
        for (String str : arr) {
            map.put(str, str);
        }
        //返回一个包含所有对象的指定类型的数组
        String[] newArrStr =  map.keySet().toArray(new String[1]);
        return newArrStr;
    }
}
