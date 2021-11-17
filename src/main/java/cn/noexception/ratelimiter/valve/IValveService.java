package cn.noexception.ratelimiter.valve;

import cn.noexception.ratelimiter.annotation.DoRateLimiter;
import org.aspectj.lang.ProceedingJoinPoint;

import java.lang.reflect.Method;

/**
 * IValveService
 *
 * @author 吕滔
 * @Date 2021/11/16 14:22
 */
public interface IValveService {
    Object accept(ProceedingJoinPoint jp, Method method, DoRateLimiter doRateLimiter, Object[] args) throws Throwable;
}
