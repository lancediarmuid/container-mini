package cn.noexception.container.context;

import cn.noexception.container.factory.HierarchicalBeanFactory;
import cn.noexception.container.factory.ListableBeanFactory;
import cn.noexception.container.factory.io.ResourceLoader;

/**
 * 容器核心接口
 */
public interface ApplicationContext extends ListableBeanFactory, HierarchicalBeanFactory, ResourceLoader, ApplicationEventPublisher {
}
