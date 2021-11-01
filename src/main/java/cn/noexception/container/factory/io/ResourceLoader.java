package cn.noexception.container.factory.io;

/**
 * 资源加载器接口
 * ResourceLoader
 *
 * @author 吕滔
 * @Date 2021/10/23 10:23
 */
public interface ResourceLoader {
    String CLASSPATH_URL_PREFIX = "classpath:";
    Resource getResource(String location);
}
