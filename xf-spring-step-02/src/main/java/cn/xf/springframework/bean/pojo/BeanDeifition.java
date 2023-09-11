package cn.xf.springframework.bean.pojo;

/**
 * @author xiongfeng
 * @date 2023/9/6 17:59
 */

public class BeanDeifition {

    private Class beanClass;

    private PropertyValues propertyValues;

    public BeanDeifition(Class beanClass) {
        this.beanClass = beanClass;
    }

    public BeanDeifition(Class beanClass, PropertyValues propertyValues) {
        this.beanClass = beanClass;
        this.propertyValues = propertyValues;
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }

    public PropertyValues getPropertyValues() {
        return propertyValues;
    }

    public void setPropertyValues(PropertyValues propertyValues) {
        this.propertyValues = propertyValues;
    }
}
