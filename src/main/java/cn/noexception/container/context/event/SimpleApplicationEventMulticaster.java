package cn.noexception.container.context.event;

import cn.noexception.container.ApplicationListener;
import cn.noexception.container.context.ApplicationEvent;
import cn.noexception.container.factory.BeanFactory;

public class SimpleApplicationEventMulticaster extends AbstractApplicationEventMulticaster{

    public SimpleApplicationEventMulticaster(BeanFactory beanFactory) {
        setBeanFactory(beanFactory);
    }

    @Override
    public void multicastEvent(ApplicationEvent event) {
        for (ApplicationListener listener : getApplicationListeners(event)) {
            // 执行监听器的响应方法
            listener.onApplicationEvent(event);
        }
    }
}
