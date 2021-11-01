package cn.noexception.container.factory;

import cn.noexception.container.BeansException;

/**
 * BeanFactory
 *
 * @author 吕滔
 * @Date 2021/10/22 15:39
 */
public interface BeanFactory {
    Object getBean(String name) throws BeansException;

    /**
     * 重载一个含有入参信息 args 的 getBean 方法，方便传递入参给构造函数实例化
     */
    Object getBean(String name, Object... args) throws BeansException;

    <T> T getBean(String name, Class<T> requiredType) throws BeansException;
}
