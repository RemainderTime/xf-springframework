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

    private InstantiationStrategy instantiationStrategy = new CglibInstantiationStrategy();

    @Override
    public Object getBean(String name) {
        Object singletonBean = getSingletonBean(name);
        if (Objects.nonNull(singletonBean)) {
            return singletonBean;
        }
        BeanDeifition bean = getBeanDeifition(name);

        return createBean(name, bean);
    }

    @Override
    public Object getBean(String beanName, Object... args) {

        Object singletonBean = getSingletonBean(beanName);
        if (Objects.nonNull(singletonBean)) {
            return singletonBean;
        }
        BeanDeifition bean = getBeanDeifition(beanName);
        return createInstantiationBean(bean, args);
    }

    protected Object createInstantiationBean(BeanDeifition beanDeifition, Object[] args) {
        Class beanClass = beanDeifition.getBeanClass();
        Constructor ctr = null;
        Constructor[] constructors = beanClass.getConstructors();
        try {
            for (Constructor con : constructors) {
                if (args != null && con.getParameterTypes().length == args.length) {
                    ctr = con;
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("create constructor bean error", e);
        }
        return instantiationStrategy.instantiationBean(beanDeifition, ctr, args);
    }


    protected abstract BeanDeifition getBeanDeifition(String beanName);

    protected abstract Object createBean(String beanName, BeanDeifition beanDeifition);
}
