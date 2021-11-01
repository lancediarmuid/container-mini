package cn.noexception.container.factory;

import cn.noexception.container.BeansException;

import java.util.Map;

/**
 * ListableBeanFactory
 *
 * @author 吕滔
 * @Date 2021/10/23 14:35
 */
public interface ListableBeanFactory extends BeanFactory {
    /**
     * 按照类型返回 Bean 实例
     */
    <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException;

    /**
     * 返回注册表中所有的 Bean 名称
     */
    String[] getBeanDefinitionNames();
}
