package cn.com.fovsoft.common.sercurity.exception;


import org.springframework.security.core.AuthenticationException;

/**
 * @author tpc
 * @date 2019-10-14 21:36
 * description: 添加图像验证码错误抛错误
 */
public class VerifyCodeAuthenticationException extends AuthenticationException {

    //通过父类抛出异常
    public VerifyCodeAuthenticationException(String msg) {
        super(msg);
    }
}
