package cn.noexception.test.event;

import cn.noexception.container.ApplicationListener;

import java.util.Date;

/**
 * 用于监听CustomEvent事件的监听器，这里可以处理收到消息后想要进行的操作；
 * 例如：用户注册后，发放优惠券、或者短信通知用户注册成功等。
 */
public class CustomEventListener implements ApplicationListener<CustomEvent> {
    @Override
    public void onApplicationEvent(CustomEvent event) {
        System.out.println("收到：" + event.getSource() + "消息；时间：" + new Date());
        System.out.println("消息：" + event.getId() + ": " + event.getMessage());
    }
}
