package cn.noexception.container.factory;

/**
 * 销毁方法接口
 */
public interface DisposableBean {
    void destroy() throws Exception;
}
