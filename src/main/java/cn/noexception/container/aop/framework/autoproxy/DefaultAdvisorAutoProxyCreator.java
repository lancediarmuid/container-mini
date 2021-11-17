package cn.noexception.container.aop.framework.autoproxy;

import cn.noexception.container.BeansException;
import cn.noexception.container.PropertyValues;
import cn.noexception.container.aop.*;
import cn.noexception.container.aop.aspectj.AspectJExpressionPointcutAdvisor;
import cn.noexception.container.aop.framework.ProxyFactory;
import cn.noexception.container.factory.BeanFactory;
import cn.noexception.container.factory.BeanFactoryAware;
import cn.noexception.container.factory.config.InstantiationAwareBeanPostProcessor;
import cn.noexception.container.factory.support.DefaultListableBeanFactory;
import org.aopalliance.aop.Advice;
import org.aopalliance.intercept.MethodInterceptor;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * DefaultAdvisorAutoProxyCreator
 * <p>加入 Bean 生命周期的自动代理创建者</p>
 *
 * @author 吕滔
 * @Date 2021/11/4 16:53
 */
public class DefaultAdvisorAutoProxyCreator implements InstantiationAwareBeanPostProcessor, BeanFactoryAware {

    private DefaultListableBeanFactory beanFactory;

    private final Set<Object> earlyProxyReferences = Collections.synchronizedSet(new HashSet<>());

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = (DefaultListableBeanFactory) beanFactory;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (!earlyProxyReferences.contains(beanName)) {
            return wrapIfNecessary(bean, beanName);
        }
        return bean;
    }

    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        return null;
    }

    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        return true;
    }

    /**
     * 检测/感知 bean 是否是切点 <p>按需拦截
     */
    private boolean isInfrastructureClass(Class<?> beanClass) {
        return Advice.class.isAssignableFrom(beanClass) || Pointcut.class.isAssignableFrom(beanClass) || Advisor.class.isAssignableFrom(beanClass);
    }

    @Override
    public PropertyValues postProcessPropertyValues(PropertyValues pvs, Object bean, String beanName) throws BeansException {
        return pvs;
    }

    @Override
    public Object getEarlyBeanReference(Object exposedObject, String beanName) {
        earlyProxyReferences.add(beanName);
        return wrapIfNecessary(exposedObject, beanName);
    }

    protected Object wrapIfNecessary(Object bean, String beanName) {
        if (isInfrastructureClass(bean.getClass())) {
            return bean;
        }
        Collection<AspectJExpressionPointcutAdvisor> advisors = beanFactory.getBeansOfType(AspectJExpressionPointcutAdvisor.class).values();
        for (AspectJExpressionPointcutAdvisor advisor : advisors) {
            ClassFilter classFilter = advisor.getPointcut().getClassFilter();
            // 过滤匹配类
            if (!classFilter.matches(bean.getClass())) continue;

            AdvisedSupport advisedSupport = new AdvisedSupport();

            TargetSource targetSource = new TargetSource(bean);
            // 设置目标对象
            advisedSupport.setTargetSource(targetSource);
            // 设置拦截方法
            advisedSupport.setMethodInterceptor((MethodInterceptor) advisor.getAdvice());
            // 设置匹配器
            advisedSupport.setMethodMatcher(advisor.getPointcut().getMethodMatcher());
            // 设置选择使用的代理方法
            advisedSupport.setProxyTargetClass(true);

            // 返回代理对象
            return new ProxyFactory(advisedSupport).getProxy();
        }
        return bean;
    }
}




