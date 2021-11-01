package cn.noexception.container.factory;

/**
 * BeanNameAware - 容器感知类
 * 实现此接口，既能感知到所属的 BeanName
 *
 * @author 吕滔
 * @Date 2021/10/26 15:05
 */
public interface BeanNameAware extends Aware {
    void setBeanName(String beanName);
}
