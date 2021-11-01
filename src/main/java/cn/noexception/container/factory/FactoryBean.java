package cn.noexception.container.factory;

public interface FactoryBean<T> {
    /**
     * 获取对象
     */
    T getObject() throws Exception;

    /**
     * 获取对象类型
     */
    Class<?> getObjectType();

    /**
     * 是否单利对象
     */
    boolean isSingleton();
}
