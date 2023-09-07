package cn.xf.springframework.bean.support;

import cn.xf.springframework.bean.BeanFactory;
import cn.xf.springframework.bean.pojo.BeanDeifition;

import java.util.Objects;

/**
 * @author xiongfeng
 * @date 2023/9/7 11:38
 */

public abstract class AbstractBeanFactory extends DefaultSingletonBeanFactory implements BeanFactory  {

    @Override
    public Object getBean(String name) {
        Object singletonBean = getSingletonBean(name);
        if(Objects.nonNull(singletonBean)){
            return singletonBean;
        }
        BeanDeifition bean = getBeanDeifition(name);

        return createBean(name, bean);
    }

    protected  abstract BeanDeifition getBeanDeifition(String beanName);

    protected abstract Object createBean(String beanName, BeanDeifition beanDeifition);
}
