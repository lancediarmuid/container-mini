package cn.noexception.container.context;

/**
 * 事件发布者
 */
public interface ApplicationEventPublisher {
    void publishEvent(ApplicationEvent event);
}
