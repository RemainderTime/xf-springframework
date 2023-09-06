package cn.xf.springframework;

/**
 * @author xiongfeng
 * @date 2023/9/1 14:47
 * 定义bean对象
 */

public class BeanDefinition {

    private Object bean;

    public BeanDefinition(Object bean) {
        this.bean = bean;
    }

    public Object getBean() {
        return bean;
    }
}
