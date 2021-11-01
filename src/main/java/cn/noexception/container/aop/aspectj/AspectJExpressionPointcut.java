package cn.noexception.container.aop.aspectj;

import cn.noexception.container.aop.ClassFilter;
import cn.noexception.container.aop.MethodMatcher;
import cn.noexception.container.aop.Pointcut;

import java.lang.reflect.Method;

/**
 * 切点表达式类
 */
public class AspectJExpressionPointcut implements Pointcut, ClassFilter, MethodMatcher {


    @Override
    public boolean matches(Class<?> clazz) {
        return false;
    }

    @Override
    public boolean matches(Method method, Class<?> targetClass) {
        return false;
    }

    @Override
    public ClassFilter getClassFilter() {
        return null;
    }

    @Override
    public MethodMatcher getMethodMatcher() {
        return null;
    }
}
