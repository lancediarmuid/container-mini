package cn.noexception.container.factory.convert;

import jdk.internal.jline.internal.Nullable;

/**
 * ConversionService
 *
 * @author 吕滔
 * @Date 2021/11/19 12:00
 */
public interface ConversionService {
    boolean canConvert(@Nullable Class<?> sourceType, Class<?> targetType);


    <T> T convert(Object source, Class<T> targetType);
}
