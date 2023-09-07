package cn.xf.springframework.bean.pojo;

/**
 * @author xiongfeng
 * @date 2023/9/6 17:59
 */

public class BeanDeifition {

    private Class beanClass;

    public BeanDeifition(Class beanClass) {
        this.beanClass = beanClass;
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }
}
