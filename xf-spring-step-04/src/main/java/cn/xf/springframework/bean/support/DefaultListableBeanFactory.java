package cn.xf.springframework.bean.support;

import cn.xf.springframework.bean.pojo.BeanDefinition;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xiongfeng
 * @date 2023/9/7 14:25
 */

public  class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory implements BeanDefinitionRegister{

    private Map<String, BeanDefinition> beanDefinitionMap =new HashMap<>();

    @Override
    public void registerBeanDefinition(String name, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(name, beanDefinition);
    }


    @Override
    public Boolean containsBeanDefinition(String beanName) {
        return beanDefinitionMap.keySet().contains(beanName);
    }

    @Override
    public List<Object> getBeanDefinitionNames() {
        return Arrays.asList(beanDefinitionMap.keySet().toArray());
    }

    @Override
    public BeanDefinition getBeanDefinition(String beanName) {
        return beanDefinitionMap.get(beanName);
    }
}
