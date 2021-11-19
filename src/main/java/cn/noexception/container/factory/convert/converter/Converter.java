package cn.noexception.container.factory.convert.converter;

/**
 * Converter
 * 定义类型转换接口
 *
 * @author 吕滔
 * @Date 2021/11/18 16:42
 */
public interface Converter<S, T> {
    T convert(S source);
}
