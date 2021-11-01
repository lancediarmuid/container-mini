package cn.noexception.container.factory;

import cn.noexception.container.BeansException;

/**
 * BeanClassLoaderAware - 容器感知类
 * 实现此接口，既能感知到所属的 ClassLoader
 *
 * @author 吕滔
 * @Date 2021/10/26 15:02
 */
public interface BeanClassLoaderAware extends Aware{
    void setBeanClassLoader(ClassLoader classLoader);
}
