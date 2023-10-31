package cn.xf.springframework.bean.support;

import cn.xf.springframework.bean.pojo.BeanDefinition;

import java.util.List;

public interface BeanDefinitionRegister {

    public void registerBeanDefinition(String name, BeanDefinition beanDefinition);

    BeanDefinition getBeanDefinition(String beanName);

    Boolean containsBeanDefinition(String beanName);

    List<Object> getBeanDefinitionNames();

}
