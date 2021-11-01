package cn.noexception.container.factory.config;

/**
 * SingletonBeanRegistry
 *
 * @author 吕滔
 * @Date 2021/10/22 17:33
 */
public interface SingletonBeanRegistry {
    Object getSingleton(String beanName);

    void registerSingleton(String beanName, Object singletonObject);
}
