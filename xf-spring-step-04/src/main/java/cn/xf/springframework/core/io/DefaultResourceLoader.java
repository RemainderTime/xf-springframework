package cn.xf.springframework.core.io;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @Author: xiongfeng
 * @CreateTime: 2023-09-13  15:34
 * @Description: TODO 策略模式实现类包装资源加载器
 * @Version: 1.0
 */
public class DefaultResourceLoader implements ResourceLoader {

    private static final String CLASS_PATH = "classpath:";

    @Override
    public Resource getResource(String location) {
        if (location.startsWith(CLASS_PATH)) {
            return new ClassPathResource(location.substring(CLASS_PATH.length()));
        } else {
            try {
                return new UrlResource(new URL(location));
            } catch (MalformedURLException e) {
                return new FileSystemResource(location);
            }
        }
    }
}
