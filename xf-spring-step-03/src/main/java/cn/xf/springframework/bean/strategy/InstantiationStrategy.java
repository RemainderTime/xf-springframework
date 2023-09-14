package cn.xf.springframework.bean.strategy;

import cn.xf.springframework.bean.pojo.BeanDefinition;

import java.lang.reflect.Constructor;

public interface InstantiationStrategy {

    public Object instantiationBean(BeanDefinition beanDefinition, Constructor constructor, Object[] args);

}
