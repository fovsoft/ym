package cn.com.fovsoft.common.util;/*
 * @Author:tpc
 * @Date: 2019/12/19 10:59
 * 功能描述:通用工具类
 * @version:
 */

public class CommonUtil {

    public static int getStringInt(String input){
        if(input.equals("")||input==null){
            return 0;
        }
        return Integer.parseInt(input);
    }
}
