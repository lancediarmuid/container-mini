package cn.noexception.container.factory.config;

import cn.noexception.container.BeansException;

/**
 * InstantiationAwareBeanPostProcessor
 *
 * @author 吕滔
 * @Date 2021/11/4 16:55
 */
public interface InstantiationAwareBeanPostProcessor extends BeanPostProcessor {
    /**
     * 在 Bean 对象执行初始化方法之前，执行此方法
     */
    Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException;
}
