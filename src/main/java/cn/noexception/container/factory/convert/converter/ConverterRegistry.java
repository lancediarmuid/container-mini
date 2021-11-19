package cn.noexception.container.factory.convert.converter;

/**
 * ConverterRegistry
 * 类型转换注册接口
 *
 * @author 吕滔
 * @Date 2021/11/18 16:45
 */
public interface ConverterRegistry {
    void addConverter(Converter<?, ?> converter);

    void addConverter(GenericConverter converter);

    void addConverterFactory(ConverterFactory<?, ?> converterFactory);
}
