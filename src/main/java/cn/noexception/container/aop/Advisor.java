package cn.noexception.container.aop;

import org.aopalliance.aop.Advice;

/**
 * Advisor
 * 定义访问者
 * <p>
 *     Advisor 承担了 Pointcut 和 Advice 的组合，
 *     Pointcut 用于获取 JoinPoint，而 Advice 决定于 JointPoint 执行什么操作
 * </p>
 * @author 吕滔
 * @Date 2021/11/4 16:17
 */
public interface Advisor {
    Advice getAdvice();
}
