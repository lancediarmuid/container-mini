package cn.noexception.test.loop;

import cn.noexception.container.factory.FactoryBean;

import java.lang.reflect.Proxy;

/**
 * HusbandMother
 *
 * @author 吕滔
 * @Date 2021/11/17 15:12
 */
public class HusbandMother implements FactoryBean<IMother> {
    @Override
    public IMother getObject() throws Exception {
        return (IMother) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{IMother.class}, ((proxy, method, args) -> "婚后媳妇妈妈的职责被婆婆代理了！"+method.getName()));
    }

    @Override
    public Class<?> getObjectType() {
        return IMother.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
