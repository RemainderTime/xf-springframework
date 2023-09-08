package cn.xf.springframework.bean.strategy;

import cn.xf.springframework.bean.pojo.BeanDeifition;

import java.lang.reflect.Constructor;

public interface InstantiationStrategy {

    public Object instantiationBean(BeanDeifition beanDeifition, Constructor constructor, Object[] args);

}
