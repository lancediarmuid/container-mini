package cn.noexception.container.aop;

import java.lang.reflect.Method;

/**
 * MethodBeforeAdvice
 *
 * @author 吕滔
 * @Date 2021/11/4 16:07
 */
public interface MethodBeforeAdvice extends BeforeAdvice{
    /**
     * 给定方法调用之前的回调
     */
    void before(Method method, Object[] args, Object target) throws Throwable;
}
