package cn.noexception.container.factory.config;

import cn.noexception.container.BeansException;
import cn.noexception.container.PropertyValues;

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

    /**
     * 在 Bean 对象执行初始化方法之后，执行此方法
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException;

    /**
     * 在 Bean 对象实例化完成后，设置属性操作之前执行此方法
     * @param pvs
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    PropertyValues postProcessPropertyValues(PropertyValues pvs, Object bean, String beanName) throws BeansException;
}
