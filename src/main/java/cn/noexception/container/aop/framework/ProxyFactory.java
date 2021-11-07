package cn.noexception.container.aop.framework;

import cn.noexception.container.aop.AdvisedSupport;

/**
 * ProxyFactory<p>
 * - 代理工厂类，用于解决关于选择Cglib 和 JDK 两种代理的问题<p>
 * - 有了代理工厂就可以安札不同的创建需求进行控制
 *
 * @author 吕滔
 * @Date 2021/11/4 16:43
 */
public class ProxyFactory {
    private AdvisedSupport advisedSupport;

    public ProxyFactory(AdvisedSupport advisedSupport) {
        this.advisedSupport = advisedSupport;
    }

    public Object getProxy() {
        return createAopProxy().getProxy();
    }

    private AopProxy createAopProxy() {
        if (advisedSupport.isProxyTargetClass()) {
            return new Cglib2AopProxy(advisedSupport);
        }
        return new JdkDynamicAopProxy(advisedSupport);
    }
}
