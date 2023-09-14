package cn.xf.springframework.bean.support;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.ReflectUtil;
import cn.xf.springframework.bean.pojo.BeanDefinition;
import cn.xf.springframework.bean.pojo.BeanReference;
import cn.xf.springframework.bean.pojo.PropertyValue;
import cn.xf.springframework.bean.pojo.PropertyValues;
import cn.xf.springframework.bean.strategy.CglibInstantiationStrategy;
import cn.xf.springframework.bean.strategy.InstantiationStrategy;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.logging.Logger;

/**
 * @author xiongfeng
 * @date 2023/9/7 14:14
 */

public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {

    private InstantiationStrategy instantiationStrategy = new CglibInstantiationStrategy();

    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) {
        Object bean = null;
        try {
            bean = createInstantiationBean(beanDefinition, args);
            applyPropertyVaules(beanDefinition, beanName, bean);
        } catch (Exception e) {
            Logger.getLogger("dfsdfdsfs");
        }
        addSingletonBean(beanName, bean);
        return bean;
    }

    protected Object createInstantiationBean(BeanDefinition beanDefinition, Object[] args) {
        Class beanClass = beanDefinition.getBeanClass();
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
        return instantiationStrategy.instantiationBean(beanDefinition, ctr, args);
    }

    protected void applyPropertyVaules(BeanDefinition beanDefinition, String beanName, Object bean) {
        try {
            PropertyValues propertyValues = beanDefinition.getPropertyValues();
            if (Objects.isNull(propertyValues)) {
                return;
            }
            for (PropertyValue propertyValue : propertyValues.getPropertyValues()) {

                String name = propertyValue.getName();
                Object value = propertyValue.getValue();

                if (value instanceof BeanReference) {
                    // A 依赖 B，获取 B 的实例化
                    BeanReference beanReference = (BeanReference) value;
                    value = getBean(beanReference.getBeanName());
                }
                // 属性填充
//                BeanUtil.setFieldValue(bean, name, value);
                setFieldValue(bean, name, value);
            }
        } catch (Exception e) {
            throw new RuntimeException("create constructor bean error " + beanName, e);
        }
    }

    public static void setFieldValue(Object bean, String fieldNameOrIndex, Object value) {
        if (bean instanceof Map) {
            ((Map) bean).put(fieldNameOrIndex, value);
        } else if (bean instanceof List) {
            CollUtil.setOrAppend((List) bean, Convert.toInt(fieldNameOrIndex), value);
        } else if (ArrayUtil.isArray(bean)) {
            ArrayUtil.setOrAppend(bean, Convert.toInt(fieldNameOrIndex), value);
        } else {
            // 普通Bean对象
            ReflectUtil.setFieldValue(bean, fieldNameOrIndex, value);
        }
    }

    public static Object setOrAppend(Object array, int index, Object value) {
//        if (index < length(array)) {
//            Array.set(array, index, value);
//            return array;
//        } else {
//            return append(array, value);
//        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(Convert.toInt("userDao"));
    }


}
