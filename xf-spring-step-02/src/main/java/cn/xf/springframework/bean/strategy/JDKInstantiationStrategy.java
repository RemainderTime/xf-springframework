package cn.xf.springframework.bean.strategy;

import cn.xf.springframework.bean.pojo.BeanDeifition;

import java.lang.reflect.Constructor;

/**
 * @Author: xiongfeng
 * @CreateTime: 2023-09-08  17:30
 * @Description: jdk动态代理构造器策略
 * @Version: 1.0
 */
public class JDKInstantiationStrategy implements InstantiationStrategy {
    @Override
    public Object instantiationBean(BeanDeifition beanDeifition, Constructor constructor, Object[] args) {

        Class beanClass = beanDeifition.getBeanClass();
        try {
            if(constructor != null){
                return beanClass.getDeclaredConstructor(constructor.getParameterTypes()).newInstance(args);
            }else {
                return beanClass.newInstance();
            }
        }catch (Exception e){
            throw new RuntimeException("jdk instantiation strategy error", e);
        }
    }
}
