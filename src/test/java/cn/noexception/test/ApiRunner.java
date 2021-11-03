package cn.noexception.test;

import cn.noexception.container.aop.AdvisedSupport;
import cn.noexception.container.aop.TargetSource;
import cn.noexception.container.aop.aspectj.AspectJExpressionPointcut;
import cn.noexception.container.aop.framework.Cglib2AopProxy;
import cn.noexception.container.aop.framework.JdkDynamicAopProxy;
import cn.noexception.container.context.support.ClassPathXmlApplicationContext;
import cn.noexception.test.bean.IUserService;
import cn.noexception.test.bean.UserService;
import cn.noexception.test.bean.UserServiceInterceptor;
import cn.noexception.test.event.CustomEvent;
import org.junit.Test;

public class ApiRunner {
    @Test
    public void test_prototype() {
        // 1.初始化 BeanFactory
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:config.xml");
        applicationContext.registerShutdownHook();

        // 2. 获取Bean对象调用方法
        UserService userService01 = applicationContext.getBean("userService", UserService.class);
        UserService userService02 = applicationContext.getBean("userService", UserService.class);

        // 3. 配置 scope="prototype/singleton"
        System.out.println(userService01);
        System.out.println(userService02);

        // 4. 打印十六进制哈希
        System.out.println(userService01 + " 十六进制哈希：" + Integer.toHexString(userService01.hashCode()));

    }

    @Test
    public void test_factory_bean() {
        // 1.初始化 BeanFactory
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:config.xml");
        applicationContext.registerShutdownHook();

        // 2. 调用代理方法
        UserService userService = applicationContext.getBean("userService", UserService.class);
        System.out.println("测试结果：" + userService.queryUserInfo());
    }

    @Test
    public void test_event() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:config.xml");
        applicationContext.publishEvent(new CustomEvent(applicationContext, 1019129009086763L, "成功了！"));

        applicationContext.registerShutdownHook();
    }

    @Test
    public void test_dynamic(){
        // 目标对象
        IUserService userService = new cn.noexception.test.bean.impl.UserService();
        // 组装代理信息
        AdvisedSupport advisedSupport = new AdvisedSupport();
        advisedSupport.setTargetSource(new TargetSource(userService));
        advisedSupport.setMethodInterceptor(new UserServiceInterceptor());
        advisedSupport.setMethodMatcher(new AspectJExpressionPointcut("execution(* cn.noexception.test.bean.IUserService.*(..))"));

        // 代理对象（使用JDK代理JdkDynamicAopProxy）
        IUserService proxy_jdk = (IUserService) new JdkDynamicAopProxy(advisedSupport).getProxy();
        // 测试调用
        System.out.println("测试结果："+proxy_jdk.queryUserInfo());

        // 代理对象（使用Cglib代理Cglib2AopProxy）
        IUserService proxy_cglib = (IUserService) new Cglib2AopProxy(advisedSupport).getProxy();
        // 测试调用
        System.out.println("测试结果："+proxy_cglib.register("感冒灵"));
    }
}
