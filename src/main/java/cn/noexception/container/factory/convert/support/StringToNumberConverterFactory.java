package cn.noexception.container.factory.convert.support;

import cn.noexception.container.factory.convert.converter.Converter;
import cn.noexception.container.factory.convert.converter.ConverterFactory;
import cn.noexception.container.factory.utils.NumberUtils;
import jdk.internal.jline.internal.Nullable;

/**
 * StringToNumberConverterFactory
 *
 * @author 吕滔
 * @Date 2021/11/19 15:39
 */
public class StringToNumberConverterFactory implements ConverterFactory<String, Number> {
    @Override
    public <T extends Number> Converter<String, T> getConverter(Class<T> targetType) {
        return new StringToNumber<>(targetType);
    }
    private static final class StringToNumber<T extends Number> implements Converter<String, T>{
        private final Class<T> targetType;

        public StringToNumber(Class<T> targetType) {
            this.targetType = targetType;
        }

        @Override
        @Nullable
        public T convert(String source) {
            if (source.isEmpty()) {
                return null;
            }
            return NumberUtils.parseNumber(source, this.targetType);
        }
    }
}
