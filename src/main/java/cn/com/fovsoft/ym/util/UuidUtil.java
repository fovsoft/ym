package cn.com.fovsoft.ym.util;

import java.util.UUID;

/**
 * @Author by tpc
 * @Date 2019/10/17 22:33
 * description: 生成uuid
 **/

public class UuidUtil {

        public static String getRandomNum(){
            String s = UUID.randomUUID().toString();
            s =  s.substring(0,8)+s.substring(9,13)+s.substring(14,18)+s.substring(19,23)+s.substring(24);
            return s.substring(0, 12);
        }


    public static void main(String[] args) {
        System.out.println(getRandomNum());
    }

}
