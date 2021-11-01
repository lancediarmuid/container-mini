package cn.noexception.container.factory.support;

import cn.noexception.container.BeansException;
import cn.noexception.container.factory.io.Resource;
import cn.noexception.container.factory.io.ResourceLoader;
import cn.noexception.container.factory.support.BeanDefinitionRegistry;

/**
 * Bean读取接口
 * BeanDefinitionReader
 *
 * @author 吕滔
 * @Date 2021/10/23 10:43
 */
public interface BeanDefinitionReader {
    BeanDefinitionRegistry getRegistry();

    ResourceLoader getResourceLoader();

    void loadBeanDefinitions(Resource resource) throws BeansException;

    void loadBeanDefinitions(Resource... resource) throws BeansException;

    void loadBeanDefinitions(String location) throws BeansException;

    void loadBeanDefinitions(String... location) throws BeansException;
}
