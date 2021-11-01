package cn.noexception.container.factory;

import cn.noexception.container.BeansException;
import cn.noexception.container.factory.config.AutowireCapableBeanFactory;
import cn.noexception.container.factory.config.BeanDefinition;
import cn.noexception.container.factory.config.BeanPostProcessor;
import cn.noexception.container.factory.config.ConfigurableBeanFactory;

/**
 * ConfigurableListableBeanFactory
 *
 * @author 吕滔
 * @Date 2021/10/23 14:34
 */
public interface ConfigurableListableBeanFactory extends ListableBeanFactory, AutowireCapableBeanFactory, ConfigurableBeanFactory {
    BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    /**
     * 提前实例化单例 bean 对象
     */
    void preInstantiateSingletons() throws BeansException;

    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);
}
