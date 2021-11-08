package cn.noexception.container.context.annotation;

import cn.hutool.core.util.ClassUtil;
import cn.noexception.container.factory.config.BeanDefinition;
import cn.noexception.container.factory.stereotype.Cube;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * ClassPathScanningCandidateComponentProvider
 *
 * @author 吕滔
 * @Date 2021/11/8 16:55
 */
public class ClassPathScanningCandidateComponentProvider {
    public Set<BeanDefinition> findCandidateComponents(String basePackage){
        Set<BeanDefinition> candidates = new LinkedHashSet<>();
        Set<Class<?>> classes = ClassUtil.scanPackageByAnnotation(basePackage, Cube.class);
        for (Class<?> clazz : classes) {
            candidates.add(new BeanDefinition(clazz));
        }
        return candidates;
    }

}
