package cn.noexception.container.context;

import cn.noexception.container.BeansException;
import cn.noexception.container.context.ApplicationContext;
import cn.noexception.container.factory.Aware;

/**
 * ApplicationContextAware - 容器感知类
 * 实现此接口，既能感知到所属的 ApplicationContext
 *
 * @author 吕滔
 * @Date 2021/10/26 15:06
 */
public interface ApplicationContextAware extends Aware {
    void setApplicationContext(ApplicationContext applicationContext) throws BeansException;
}
