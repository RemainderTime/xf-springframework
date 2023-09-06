package cn.xf.springframework;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xiongfeng
 * @date 2023/9/1 14:49
 *
 * 构建bean工厂
 */

public class BeanFactory {

    Map<String, BeanDefinition> beanDefinitionMap =new HashMap<>();

    public Object getName(String name){
        return beanDefinitionMap.get(name).getBean();
    }

    public void registerBeanDefinition(String name,BeanDefinition bean){
        beanDefinitionMap.put(name, bean);
    }

}
