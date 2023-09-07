package cn.xf.springframework.bean.support;

import cn.xf.springframework.bean.pojo.BeanDeifition;

public interface BeanDefinitionRegister {

    public void registerBeanDefinition(String name, BeanDeifition beanDeifition);

}
