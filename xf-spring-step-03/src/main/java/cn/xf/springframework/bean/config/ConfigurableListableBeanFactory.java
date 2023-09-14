package cn.xf.springframework.bean.config;

import cn.xf.springframework.bean.AutowireCapableBeanFactory;
import cn.xf.springframework.bean.ListableBeanFactory;
import cn.xf.springframework.bean.pojo.BeanDefinition;

/**
 * @Author: xiongfeng
 * @CreateTime: 2023-09-14  18:10
 * @Description: TODO
 * @Version: 1.0
 */
public interface ConfigurableListableBeanFactory extends ListableBeanFactory, ConfigurableBeanFactory, AutowireCapableBeanFactory {

    BeanDefinition getBeanDefinition(String beanName);

    void preInstantiateSingletons();

}
