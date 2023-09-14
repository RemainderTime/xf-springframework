package cn.xf.springframework.bean.support;

public interface SingletonBeanRegister {

    public Object getSingletonBean(String beanName);

    public void addSingletonBean(String beanName, Object bean);


}
