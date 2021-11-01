package cn.noexception.container.context.event;

import cn.noexception.container.ApplicationListener;
import cn.noexception.container.context.ApplicationEvent;

/**
 * 事件广播器
 */
public interface ApplicationEventMulticaster {

    // 添加监听器
    void addApplicationListener(ApplicationListener<?> listener);

    // 移除监听器
    void removeApplicationListener(ApplicationListener<?> listener);

    /**
     * 广播事件
     */
    void multicastEvent(ApplicationEvent event);
}
