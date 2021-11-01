package cn.noexception.container.factory;

import cn.noexception.container.BeansException;

/**
 * BeanFactoryAware - 容器感知类
 * 实现此接口，既能感知到所属的 BeanFactory
 *
 * @author 吕滔
 * @Date 2021/10/26 14:54
 */
public interface BeanFactoryAware extends Aware{
    void setBeanFactory(BeanFactory beanFactory) throws BeansException;
}
