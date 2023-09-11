package cn.xf.springframework.bean.support;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateTime;
import cn.xf.springframework.bean.pojo.BeanDeifition;
import cn.xf.springframework.bean.pojo.BeanReference;
import cn.xf.springframework.bean.pojo.PropertyValue;
import cn.xf.springframework.bean.pojo.PropertyValues;
import cn.xf.springframework.bean.strategy.CglibInstantiationStrategy;
import cn.xf.springframework.bean.strategy.InstantiationStrategy;

import java.lang.reflect.Constructor;
import java.util.Objects;
import java.util.logging.Logger;

/**
 * @author xiongfeng
 * @date 2023/9/7 14:14
 */

public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {

    private InstantiationStrategy instantiationStrategy = new CglibInstantiationStrategy();

    @Override
    protected Object createBean(String beanName, BeanDeifition beanDeifition, Object[] args) {
        Object bean = null;
        try {
            bean = createInstantiationBean(beanDeifition, args);
        } catch (Exception e) {
            Logger.getLogger("dfsdfdsfs");
        }
        addSingletonBean(beanName, bean);
        applyPropertyVaules(beanDeifition, beanName, args);
        return bean;
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

    protected void applyPropertyVaules(BeanDeifition beanDeifition, String beanName, Object bean) {
        try {
            PropertyValues propertyValues = beanDeifition.getPropertyValues();
            for (PropertyValue propertyValue : propertyValues.getPropertyValues()) {
                String name = propertyValue.getName();
                Object value = propertyValue.getValue();
                if (value instanceof BeanReference) {
                    BeanReference valueReference = (BeanReference) value;
                    value = getBean(valueReference.getBeanName());
                }
                BeanUtil.setFieldValue(bean, name, value);
            }

        } catch (Exception e) {
            throw new RuntimeException("create constructor bean error " + beanName, e);
        }

    }
}
