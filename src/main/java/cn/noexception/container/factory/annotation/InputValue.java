package cn.noexception.container.factory.annotation;

import java.lang.annotation.*;

/**
 * InputValue
 *
 * @author 吕滔
 * @Date 2021/11/9 11:03
 */
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface InputValue {
    String value();
}
