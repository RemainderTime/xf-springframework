package cn.xf.springframework.bean.support;

import cn.xf.springframework.bean.BeanFactory;
import cn.xf.springframework.bean.pojo.BeanDeifition;
import cn.xf.springframework.bean.strategy.CglibInstantiationStrategy;
import cn.xf.springframework.bean.strategy.InstantiationStrategy;

import java.lang.reflect.Constructor;
import java.util.Objects;

/**
 * @author xiongfeng
 * @date 2023/9/7 11:38
 */

public abstract class AbstractBeanFactory extends DefaultSingletonBeanFactory implements BeanFactory {

//    @Override
//    public Object getBean(String name) {
//        Object singletonBean = getSingletonBean(name);
//        if (Objects.nonNull(singletonBean)) {
//            return singletonBean;
//        }
//        BeanDeifition bean = getBeanDeifition(name);
//        return createBean(name, bean);
//    }

    @Override
    public Object getBean(String beanName, Object... args) {

        Object singletonBean = getSingletonBean(beanName);
        if (Objects.nonNull(singletonBean)) {
            return singletonBean;
        }
        BeanDeifition bean = getBeanDeifition(beanName);
        return createBean(beanName, bean, args);
    }



    protected abstract BeanDeifition getBeanDeifition(String beanName);

    protected abstract Object createBean(String beanName, BeanDeifition beanDeifition, Object[] args);
}
