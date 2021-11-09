package cn.noexception.container.factory.annotation;

import java.lang.annotation.*;

/**
 * Priority
 *
 * @author 吕滔
 * @Date 2021/11/9 11:01
 */
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Priority {
    String value() default "";
}
