package cn.noexception.container.context.support;

import cn.noexception.container.factory.FactoryBean;
import cn.noexception.container.factory.InitializingBean;
import cn.noexception.container.factory.convert.ConversionService;
import cn.noexception.container.factory.convert.converter.Converter;
import cn.noexception.container.factory.convert.converter.ConverterFactory;
import cn.noexception.container.factory.convert.converter.ConverterRegistry;
import cn.noexception.container.factory.convert.converter.GenericConverter;
import cn.noexception.container.factory.convert.support.DefaultConversionService;
import cn.noexception.container.factory.convert.support.GenericConversionService;
import jdk.internal.jline.internal.Nullable;

import java.util.Set;

/**
 * ConversionServiceFactoryBean
 *
 * @author 吕滔
 * @Date 2021/11/19 16:21
 */
public class ConversionServiceFactoryBean implements FactoryBean<ConversionService>, InitializingBean {

    @Nullable
    private Set<?> converters;

    @Nullable
    private GenericConversionService conversionService;

    @Override
    public ConversionService getObject() throws Exception {
        return conversionService;
    }

    @Override
    public Class<?> getObjectType() {
        return conversionService.getClass();
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        this.conversionService = new DefaultConversionService();
        registerConversions(converters, conversionService);
    }

    private void registerConversions(Set<?> converters, ConverterRegistry registry) {
        if (converters != null) {
            for (Object converter : converters) {
                if (converter instanceof GenericConverter) {
                    registry.addConverter((GenericConverter) converter);
                } else if (converter instanceof Converter<?, ?>) {
                    registry.addConverterFactory((ConverterFactory<?, ?>) converter);
                } else if (converter instanceof ConverterFactory<?, ?>) {
                    registry.addConverterFactory((ConverterFactory<?, ?>) converter);
                } else {
                    throw new IllegalArgumentException("Each converter object must implememnt one of the " +
                            "Converter, ConverterFactory, or GenericConverter interfaces");
                }
            }
        }
    }

    public void setConverters(Set<?> converters) {
        this.converters = converters;
    }
}
