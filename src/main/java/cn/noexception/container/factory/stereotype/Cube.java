package cn.noexception.container.factory.stereotype;

import java.lang.annotation.*;

/**
 * Cube
 * 定义容器组件注解标记
 *
 * @author 吕滔
 * @Date 2021/11/8 16:53
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Cube {
    String value() default "";
}
