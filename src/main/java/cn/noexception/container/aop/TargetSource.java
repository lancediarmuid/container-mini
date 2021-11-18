package cn.noexception.container.aop;

import cn.noexception.container.factory.utils.ClassUtils;

/**
 * TargetSource
 *
 * @author 吕滔
 * @Date 2021/11/3 15:16
 */
public class TargetSource {

    private final Object target;

    public TargetSource(Object target) {
        this.target = target;
    }

    public Class<?>[] getTargetClass() {
        Class<?> clazz = this.target.getClass();
        // 如果是 cglib 代理的话，得获取 superClass 才可以
        clazz = ClassUtils.isCglibProxyClass(clazz) ? clazz.getSuperclass() : clazz;
        return clazz.getInterfaces();
    }

    public Object getTarget() {
        return this.target;
    }

}
