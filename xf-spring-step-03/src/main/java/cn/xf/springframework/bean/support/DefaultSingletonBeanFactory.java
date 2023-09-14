package cn.xf.springframework.bean.support;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xiongfeng
 * @date 2023/9/7 11:34
 */

public class DefaultSingletonBeanFactory implements SingletonBeanRegister{

    private Map<String, Object> singletonBeanMap = new HashMap<>();

    @Override
    public Object getSingletonBean(String beanName) {
        return singletonBeanMap.get(beanName);
    }

    @Override
    public void addSingletonBean(String beanName, Object bean) {
        singletonBeanMap.put(beanName, bean);
    }
}
