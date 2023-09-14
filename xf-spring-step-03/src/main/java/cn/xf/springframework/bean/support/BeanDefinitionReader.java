package cn.xf.springframework.bean.support;

import cn.xf.springframework.core.io.Resource;
import cn.xf.springframework.core.io.ResourceLoader;
import com.sun.org.apache.xalan.internal.xsltc.compiler.SourceLoader;

import java.io.IOException;

/**
 * @Author: xiongfeng
 * @CreateTime: 2023-09-13  15:56
 * @Description: TODO Bean定义读取接口
 * @Version: 1.0
 */
public interface BeanDefinitionReader {

    BeanDefinitionRegister getBeanDefinitionRegistry();

    ResourceLoader getResourceLoader();

    void loadBeanDefinition(Resource resource) throws IOException, ClassNotFoundException;

    void loadBeanDefinition(Resource... resources) throws IOException, ClassNotFoundException;

    void loadBeanDefinition(String location) throws IOException, ClassNotFoundException;
}
