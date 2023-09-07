package cn.xf.springframework.bean.support;

import cn.xf.springframework.bean.pojo.BeanDeifition;

import java.util.logging.Logger;

/**
 * @author xiongfeng
 * @date 2023/9/7 14:14
 */

public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {
    @Override
    protected Object createBean(String beanName, BeanDeifition beanDeifition) {
        Object bean = null;
        try {
            bean = beanDeifition.getBeanClass().newInstance();
        } catch (Exception e) {
            Logger.getLogger("dfsdfdsfs");
        }
        addSingletonBean(beanName, bean);
        return bean;
    }
}
