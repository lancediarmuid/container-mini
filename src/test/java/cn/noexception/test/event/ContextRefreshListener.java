package cn.noexception.test.event;

import cn.noexception.container.ApplicationListener;
import cn.noexception.container.context.event.ContextRefreshEvent;

/**
 * ContextRefreshListener
 *
 * @author 吕滔
 * @Date 2021/11/10 16:56
 */
public class ContextRefreshListener implements ApplicationListener<ContextRefreshEvent> {
    @Override
    public void onApplicationEvent(ContextRefreshEvent event) {
        System.out.println("容器初始化完成");
    }
}
