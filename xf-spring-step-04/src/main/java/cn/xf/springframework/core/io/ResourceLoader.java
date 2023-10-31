package cn.xf.springframework.core.io;

/**
 * @Author: xiongfeng
 * @CreateTime: 2023-09-13  15:32
 * @Description: TODO 包装资源加载器
 * @Version: 1.0
 */
public interface ResourceLoader {

    Resource getResource(String location);
}
