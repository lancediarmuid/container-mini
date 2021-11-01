package cn.noexception.container.factory.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * 资源加载接口 Resource
 *
 * @author 吕滔
 * @Date 2021/10/23 10:00
 */
public interface Resource {
    InputStream getInputStream() throws IOException;
}
