package cn.xf.springframework.core.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Author: xiongfeng
 * @CreateTime: 2023-09-13  15:05
 * @Description: 资源加载接口类
 * @Version: 1.0
 */
public interface Resource {

    InputStream getInputStream() throws IOException;
}
