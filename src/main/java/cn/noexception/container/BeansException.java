package cn.noexception.container;

/**
 * BeansException
 *
 * @author 吕滔
 * @Date 2021/10/22 17:28
 */
public class BeansException extends RuntimeException {

    public BeansException(String msg) {
        super(msg);
    }

    public BeansException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
