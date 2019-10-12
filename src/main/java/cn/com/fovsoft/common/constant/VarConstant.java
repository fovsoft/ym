package cn.com.fovsoft.common.constant;

import java.util.Locale;

public interface VarConstant {

    //定义统一Locale.CHINA,程序中所有和Locale相关操作均默认使用此Locale
    public static final Locale LOCALE_CHINA = Locale.CHINA;
    //验证码信息
    public static final String SESSION_VERIFY_CODE = "sessionVerifyCode";
    //会话中用户名对于标识
    public static final String SESSION_USER = "sessionUser";

    //页面分页数量
    public static final Integer PAGE_SIZE = 6;
    //页面排序数量
    public static final Integer SORT_SIZE = 3;
}
