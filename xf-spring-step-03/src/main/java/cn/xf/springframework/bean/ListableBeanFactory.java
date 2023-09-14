package cn.xf.springframework.bean;

import cn.xf.springframework.bean.pojo.BeanDefinition;

import java.util.Map;

/**
 * @Author: xiongfeng
 * @CreateTime: 2023-09-14  17:57
 * @Description: TODO 扩展子接口
 * @Version: 1.0
 */
public interface ListableBeanFactory extends BeanFactory{

    <T>Map<String, T> getBeanOfType(Class<T> type);

    BeanDefinition getBeanDefinition(String beanName);
}
