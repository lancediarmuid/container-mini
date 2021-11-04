package cn.noexception.container.aop;

/**
 * PointcutAdvisor
 *
 * @author 吕滔
 * @Date 2021/11/4 16:27
 */
public interface PointcutAdvisor extends Advisor {
    Pointcut getPointcut();
}
