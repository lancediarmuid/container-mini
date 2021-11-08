package cn.noexception.container.context.annotation;

import java.lang.annotation.*;

/**
 * Scope
 * 作用域注解
 *
 * @author 吕滔
 * @Date 2021/11/8 16:40
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Scope {
    /**
     * 方便通过配置 Bean 对象注解的时候，拿到 Bean 对象的作用域。
     *
     * @return 默认使用 singleton
     */
    String value() default "singleton";

}
