package cn.noexception.container.context.support;

import cn.noexception.container.BeansException;
import cn.noexception.container.context.ApplicationContext;
import cn.noexception.container.context.ApplicationContextAware;
import cn.noexception.container.factory.config.BeanPostProcessor;

/**
 * ApplicationContextAwareProcessor
 *
 * @author 吕滔
 * @Date 2021/10/26 15:10
 */
public class ApplicationContextAwareProcessor implements BeanPostProcessor {

    private final ApplicationContext applicationContext;

    public ApplicationContextAwareProcessor(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof ApplicationContextAware){
            ((ApplicationContextAware) bean).setApplicationContext(applicationContext);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
