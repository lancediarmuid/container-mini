package cn.noexception.test.bean;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * UserServiceInterceptor
 *
 * @author 吕滔
 * @Date 2021/11/3 17:04
 */
public class UserServiceInterceptor implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        long start = System.currentTimeMillis();
        try {
            return invocation.proceed();
        }finally {
            System.out.println("监控 - 切面代理处理方法");
            System.out.println("方法名称："+invocation.getMethod());
            System.out.println("方法耗时："+(System.currentTimeMillis()-start)+" ms");
            System.out.println("监控 - 结束");
        }
    }
}
