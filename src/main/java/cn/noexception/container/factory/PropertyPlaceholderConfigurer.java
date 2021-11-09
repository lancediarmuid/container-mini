package cn.noexception.container.factory;

import cn.noexception.container.BeansException;
import cn.noexception.container.PropertyValue;
import cn.noexception.container.PropertyValues;
import cn.noexception.container.factory.config.BeanDefinition;
import cn.noexception.container.factory.config.BeanFactoryPostProcessor;
import cn.noexception.container.factory.io.DefaultResourceLoader;
import cn.noexception.container.factory.io.Resource;
import cn.noexception.container.factory.utils.StringValueResolver;

import java.util.Properties;

/**
 * PropertyPlaceholderConfigurer
 * 占位符配置
 *
 * @author 吕滔
 * @Date 2021/11/8 16:14
 */
public class PropertyPlaceholderConfigurer implements BeanFactoryPostProcessor {

    private static final String DEFAULT_PLACEHOLDER_PREFIX = "${";

    private static final String DEFAULT_PLACEHOLDER_SUFFIX = "}";

    private String location;

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        // 加载属性文件
        try {
            DefaultResourceLoader resourceLoader = new DefaultResourceLoader();
            Resource resource = resourceLoader.getResource(location);
            Properties properties = new Properties();
            properties.load(resource.getInputStream());

            // 占位符替换
            String[] beanDefinitionNames = beanFactory.getBeanDefinitionNames();
            for (String beanName : beanDefinitionNames) {
                BeanDefinition beanDefinition = beanFactory.getBeanDefinition(beanName);
                PropertyValues propertyValues = beanDefinition.getPropertyValues();
                for (PropertyValue propertyValue : propertyValues.getPropertyValues()) {
                    Object value = propertyValue.getValue();
                    if (!(value instanceof String)) continue;
                    value = resolvePlaceholder((String) value, properties);
                    propertyValues.addPropertyValue(new PropertyValue(propertyValue.getName(), value));
                }
            }
            StringValueResolver valueResolver = new PlaceholderResolvingStringValueResolver(properties);
            beanFactory.addEmbeddedValueResolver(valueResolver);


        }catch (Exception ex){
            throw new BeansException(" properties 加载失败", ex);
        }
    }

    public void setLocation(String location) {
        this.location = location;
    }

    private class PlaceholderResolvingStringValueResolver implements StringValueResolver{

        private final Properties properties;

        private PlaceholderResolvingStringValueResolver(Properties properties) {
            this.properties = properties;
        }

        @Override
        public String resolveStringValue(String strVal) {
            return PropertyPlaceholderConfigurer.this.resolvePlaceholder(strVal, properties);
        }
    }

    private String resolvePlaceholder(String strVal, Properties properties) {
        StringBuilder buffer = new StringBuilder(strVal);
        int startIdx = strVal.indexOf(DEFAULT_PLACEHOLDER_PREFIX);
        int stopIdx = strVal.indexOf(DEFAULT_PLACEHOLDER_SUFFIX);
        if (startIdx != -1 && stopIdx != -1 && startIdx < stopIdx) {
            String propKey = strVal.substring(startIdx + 2, stopIdx);
            String propVal = properties.getProperty(propKey);
            buffer.replace(startIdx, stopIdx + 1, propVal);
        }
        return buffer.toString();
    }


}
