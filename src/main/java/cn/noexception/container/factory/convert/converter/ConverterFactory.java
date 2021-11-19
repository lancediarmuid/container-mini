package cn.noexception.container.factory.convert.converter;

/**
 * ConverterFactory
 * 类型转换工厂
 *
 * @author 吕滔
 * @Date 2021/11/18 16:43
 */
public interface ConverterFactory<S, R> {
    <T extends R> Converter<S, T> getConverter(Class<T> targetType);
}
