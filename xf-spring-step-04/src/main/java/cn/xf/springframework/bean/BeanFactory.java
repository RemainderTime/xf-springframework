package cn.xf.springframework.bean;

/**
 * @author xiongfeng
 * @date 2023/9/6 18:03
 */

public interface BeanFactory {

//    public Object getBean(String name);

    public Object getBean(String beanName, Object... args);
}
