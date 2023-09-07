package cn.xf.springframework.bean.support;

import cn.xf.springframework.bean.pojo.BeanDeifition;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xiongfeng
 * @date 2023/9/7 14:25
 */

public  class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory implements BeanDefinitionRegister{

    private Map<String, BeanDeifition> beanDeifitionMap =new HashMap<>();

    @Override
    public void registerBeanDefinition(String name, BeanDeifition beanDeifition) {
        beanDeifitionMap.put(name, beanDeifition);
    }

    @Override
    protected BeanDeifition getBeanDeifition(String beanName) {
        return beanDeifitionMap.get(beanName);
    }
}
