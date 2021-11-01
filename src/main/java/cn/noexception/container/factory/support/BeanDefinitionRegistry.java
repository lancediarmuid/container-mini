package cn.noexception.container.factory.support;

import cn.noexception.container.BeansException;
import cn.noexception.container.factory.config.BeanDefinition;

/**
 * BeanDefinitionRegistry
 *
 * @author 吕滔
 * @Date 2021/10/22 17:54
 */
public interface BeanDefinitionRegistry {
    /**
     * 注册 BeanDefinition
     */
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);

    /**
     * 使用 Bean 名称查询 BeanDefinition
     */
    BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    /**
     * 判断是否包含指定名称的 BeanDefinition
     */
    boolean containsBeanDefinition(String beanName);

    /**
     * 返回注册表中所有的 Bean 名称
     */
    String[] getBeanDefinitionNames();
}
