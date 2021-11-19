package cn.noexception.container.factory.convert.support;

import cn.noexception.container.factory.convert.converter.ConverterRegistry;

/**
 * DefaultConversionService
 *
 * @author 吕滔
 * @Date 2021/11/18 16:50
 */
public class DefaultConversionService extends GenericConversionService  {
    public DefaultConversionService(){
        addDefaultConverters(this);
    }

    public static void addDefaultConverters(ConverterRegistry converterRegistry) {
        // 添加各类类型转换工厂
        converterRegistry.addConverterFactory(new StringToNumberConverterFactory());
    }
}
