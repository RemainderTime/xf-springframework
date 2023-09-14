package cn.xf.springframework.bean.support;

import cn.xf.springframework.core.io.DefaultResourceLoader;
import cn.xf.springframework.core.io.ResourceLoader;

/**
 * @Author: xiongfeng
 * @CreateTime: 2023-09-13  15:59
 * @Description: TODO
 * @Version: 1.0
 */
public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader{

    private final BeanDefinitionRegister register;

    private final ResourceLoader loader;

    public AbstractBeanDefinitionReader(BeanDefinitionRegister register) {
        this(register, new DefaultResourceLoader());
    }

    protected AbstractBeanDefinitionReader(BeanDefinitionRegister register, ResourceLoader loader) {
        this.register = register;
        this.loader = loader;
    }

    public BeanDefinitionRegister getRegister() {
        return this.register;
    }

    @Override
    public ResourceLoader getResourceLoader() {
        return this.loader;
    }
}
