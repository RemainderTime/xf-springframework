package cn.xf.springframework.bean.strategy;

import cn.xf.springframework.bean.pojo.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * @Author: xiongfeng
 * @CreateTime: 2023-09-08  17:30
 * @Description: jdk动态代理构造器策略
 * @Version: 1.0
 */
public class JDKInstantiationStrategy implements InstantiationStrategy {
    @Override
    public Object instantiationBean(BeanDefinition beanDefinition, Constructor constructor, Object[] args) {

        Class beanClass = beanDefinition.getBeanClass();
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
