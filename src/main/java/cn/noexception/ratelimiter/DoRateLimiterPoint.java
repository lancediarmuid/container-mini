package cn.noexception.ratelimiter;

import cn.noexception.container.factory.stereotype.Cube;
import cn.noexception.ratelimiter.annotation.DoRateLimiter;
import cn.noexception.ratelimiter.valve.IValveService;
import cn.noexception.ratelimiter.valve.impl.RateLimiterValve;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.reflect.Method;

/**
 * DoRateLimiterPoint
 *
 * @author 吕滔
 * @Date 2021/11/16 14:19
 */
@Cube
public class DoRateLimiterPoint {
    @Pointcut("@annotation(cn.noexception.ratelimiter.annotation.DoRateLimiter)")
    public void aopPoint() {
    }

    @Around("aopPoint() && @annotation(doRateLimiter)")
    public Object doRouter(ProceedingJoinPoint jp, DoRateLimiter doRateLimiter) throws Throwable {
        IValveService valveService = new RateLimiterValve();
        return valveService.accept(jp, getMethod(jp), doRateLimiter, jp.getArgs());
    }

    private Method getMethod(JoinPoint joinPoint) throws NoSuchMethodException {
        Signature sig = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) sig;
        return joinPoint.getTarget().getClass().getMethod(methodSignature.getName(), methodSignature.getParameterTypes());
    }
}
