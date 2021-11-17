package cn.noexception.ratelimiter.valve.impl;

import cn.hutool.json.JSONUtil;
import cn.noexception.ratelimiter.Constants;
import cn.noexception.ratelimiter.annotation.DoRateLimiter;
import cn.noexception.ratelimiter.valve.IValveService;
import com.google.common.util.concurrent.RateLimiter;
import org.aspectj.lang.ProceedingJoinPoint;

import java.lang.reflect.Method;

/**
 * RateLimiterValve
 * 限流调用服务包装
 *
 * @author 吕滔
 * @Date 2021/11/16 14:22
 */
public class RateLimiterValve implements IValveService {
    @Override
    public Object accept(ProceedingJoinPoint jp, Method method, DoRateLimiter doRateLimiter, Object[] args) throws Throwable {
        // 判断是否开启限流器
        if (0 == doRateLimiter.rate()) return jp.proceed();

        String clazzName = jp.getTarget().getClass().getName();
        String methodName = method.getName();

        String key = clazzName + "." + methodName;

        if (null == Constants.rateLimiterMap.get(key)) {
            Constants.rateLimiterMap.put(key, RateLimiter.create(doRateLimiter.rate()));
        }

        RateLimiter rateLimiter = Constants.rateLimiterMap.get(key);
        if (rateLimiter.tryAcquire()) {
            return jp.proceed();
        }

        return JSONUtil.parse(doRateLimiter.returnJson()).toBean(method.getReturnType());
    }
}
