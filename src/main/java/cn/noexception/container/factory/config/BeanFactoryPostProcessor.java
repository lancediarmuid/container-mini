package cn.noexception.container.factory.config;

import cn.noexception.container.BeansException;
import cn.noexception.container.factory.ConfigurableListableBeanFactory;

/**
 * 在所有的 BeanDefinition 加载完成后，实例化 Bean 对象之前，提供修改 BeanDefinition 属性的机制
 */
public interface BeanFactoryPostProcessor {
    /**
     * 在所有 BeanDefinition 加载完成后，实例化 Bean 对象之前，提供修改 BeanDefinition 属性的机制
     */
    void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException;
}
