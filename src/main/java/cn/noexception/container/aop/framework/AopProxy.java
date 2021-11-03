package cn.noexception.container.aop.framework;

/**
 * AopProxy - 定义接口
 * 定义一个标准接口，用于获取代理类。
 * <p>
 * 因为具体实现代理的方式可以有 JDK 方式，也可以是 Cglib 方式
 * </p>
 * @author 吕滔
 * @Date 2021/11/3 15:26
 */
public interface AopProxy {
    Object getProxy();
}
