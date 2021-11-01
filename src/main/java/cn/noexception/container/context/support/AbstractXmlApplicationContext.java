package cn.noexception.container.context.support;

import cn.noexception.container.factory.support.DefaultListableBeanFactory;
import cn.noexception.container.factory.xml.XmlBeanDefinitionReader;

public abstract class AbstractXmlApplicationContext extends AbstractRefreshableApplicationContext {

    @Override
    protected void loadBeanDefinitions(DefaultListableBeanFactory beanFactory) {
        // 处理关于 xml 文件配置信息的操作
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory, this);
        String[] configLocations = getConfigLocations();
        if (null != configLocations) {
            beanDefinitionReader.loadBeanDefinitions(configLocations);
        }
    }

    // 从入口上下文类拿到配置信息的地址描述
    protected abstract String[] getConfigLocations();
}
