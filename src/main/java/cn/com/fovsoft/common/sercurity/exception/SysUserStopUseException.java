package cn.com.fovsoft.common.sercurity.exception;/*
 * @Author:tpc
 * @Date: 2019/11/29 15:44
 * 功能描述:用户被停用抛出异常
 * @version:
 */

import org.springframework.security.core.AuthenticationException;

public class SysUserStopUseException extends AuthenticationException {
    //通过父类抛出异常
    public SysUserStopUseException(String msg){
        super(msg);
    }
}
