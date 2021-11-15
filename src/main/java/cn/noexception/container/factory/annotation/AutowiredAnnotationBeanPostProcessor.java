package cn.noexception.container.factory.annotation;

import cn.hutool.core.bean.BeanUtil;
import cn.noexception.container.BeansException;
import cn.noexception.container.PropertyValues;
import cn.noexception.container.factory.BeanFactory;
import cn.noexception.container.factory.BeanFactoryAware;
import cn.noexception.container.factory.ConfigurableListableBeanFactory;
import cn.noexception.container.factory.config.InstantiationAwareBeanPostProcessor;
import cn.noexception.container.factory.utils.ClassUtils;

import java.lang.reflect.Field;

/**
 * AutowiredAnnotationBeanPostProcessor
 * 扫描自定义注解
 *
 * @author 吕滔
 * @Date 2021/11/9 11:08
 */
public class AutowiredAnnotationBeanPostProcessor implements InstantiationAwareBeanPostProcessor, BeanFactoryAware {

    private ConfigurableListableBeanFactory beanFactory;

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return null;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return null;
    }

    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        return null;
    }

    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        return true;
    }

    @Override
    public PropertyValues postProcessPropertyValues(PropertyValues pvs, Object bean, String beanName) throws BeansException {
        // 1. 处理注解 @InputValue
        Class<?> clazz = bean.getClass();
        clazz = ClassUtils.isCglibProxyClass(clazz) ? clazz.getSuperclass() : clazz;

        Field[] declaredFields = clazz.getDeclaredFields();

        for (Field field : declaredFields) {
            InputValue valueAnnotation = field.getAnnotation(InputValue.class);
            if (null != valueAnnotation) {
                // 将注解中的占位符表达式转换成值
                String value = valueAnnotation.value();
                value = beanFactory.resolveEmbeddedValue(value);
                BeanUtil.setFieldValue(bean, field.getName(), value);
            }
        }

        // 2. 处理注解 @Inject
        for (Field field : declaredFields) {
            Inject injectAnnotation = field.getAnnotation(Inject.class);
            if (null != injectAnnotation) {
                Class<?> fieldType = field.getType();
                String dependentBeanName = null;
                Priority priorityAnnotation = field.getAnnotation(Priority.class);
                Object dependentBean = null;
                if (null != priorityAnnotation) {
                    dependentBeanName = priorityAnnotation.value();
                    dependentBean = beanFactory.getBean(dependentBeanName, fieldType);
                } else {
                    dependentBean = beanFactory.getBean(fieldType);
                }
                BeanUtil.setFieldValue(bean, field.getName(), dependentBean);
            }
        }
        return pvs;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = (ConfigurableListableBeanFactory) beanFactory;
    }
}
