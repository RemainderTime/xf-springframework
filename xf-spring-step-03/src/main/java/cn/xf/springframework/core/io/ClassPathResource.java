package cn.xf.springframework.core.io;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.ClassUtil;
import cn.xf.springframework.util.ClassUtils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * @Author: xiongfeng
 * @CreateTime: 2023-09-13  15:06
 * @Description: TODO
 * @Version: 1.0
 */
public class ClassPathResource implements Resource {

    private final String path;
    private ClassLoader classLoader;
    

    public ClassPathResource(String path) {
        this(path, (ClassLoader) null);
    }

    public ClassPathResource(String path, ClassLoader classLoader) {
        Assert.notNull(path, "Path must not be null");
        this.path = path;
        this.classLoader = (classLoader != null ? classLoader : ClassUtils.getDefaultClassLoader());
    }

    @Override
    public InputStream getInputStream() throws IOException {

        InputStream resourceAsStream = classLoader.getResourceAsStream(path);
        if (resourceAsStream == null) {
            throw new FileNotFoundException(
                    this.path + " cannot be opened because it does not exist");
        }
        return resourceAsStream;
    }

}
