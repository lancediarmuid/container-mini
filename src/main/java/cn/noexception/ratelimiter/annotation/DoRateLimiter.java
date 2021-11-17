package cn.noexception.ratelimiter.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * DoRateLimiter
 * 自定义限流器注解
 *
 * @author 吕滔
 * @Date 2021/11/16 14:19
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface DoRateLimiter {
    double rate() default 1; // 限流许可量
    String returnJson() default ""; // 返回结果信息

}
