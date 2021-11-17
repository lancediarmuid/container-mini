package cn.noexception.test.loop;

import cn.noexception.container.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * SpouseAdvice
 *
 * @author 吕滔
 * @Date 2021/11/17 15:15
 */
public class SpouseAdvice implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("关怀小两口：" + method);
    }
}
