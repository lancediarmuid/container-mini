package cn.noexception.test.bean;

import cn.noexception.container.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * UserServiceBeforeAdvice
 *
 * @author 吕滔
 * @Date 2021/11/4 17:30
 */
public class UserServiceBeforeAdvice implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("拦截方法：" + method.getName());
    }
}
