package cn.noexception.container.factory.config;

import cn.noexception.container.factory.HierarchicalBeanFactory;

/**
 * ConfigurableBeanFactory
 *
 * @author 吕滔
 * @Date 2021/10/23 14:21
 */
public interface ConfigurableBeanFactory extends HierarchicalBeanFactory, SingletonBeanRegistry {
    String SCOPE_SINGLETON = "singleton";
    String SCOPE_PROPTOTYPE = "prototype";

    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);

    /**
     * 销毁单例对象
     */
    void destroySingletons();
}
