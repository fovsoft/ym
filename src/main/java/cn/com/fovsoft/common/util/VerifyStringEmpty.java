package cn.com.fovsoft.common.util;

/**
 * @author: tpc
 * @date: 2019-10-12 12:05
 * @description:
 **/
public class VerifyStringEmpty {

    /**
     * 检测字符串是否不为空
     * @param str
     * @return
     */
    public static boolean isNotEmpty(String str){
        return str != null && !"".equals(str) ;
    }

    /**
     * 检测字符串是否为空
     * @param str
     * @return
     */
    public static boolean isEmpty(String str){
        return str == null || "".equals(str) ;
    }
}
