package cn.xf.springframework.bean.strategy;

import cn.xf.springframework.bean.pojo.BeanDefinition;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;

import java.lang.reflect.Constructor;

/**
 * @Author: xiongfeng
 * @CreateTime: 2023-09-08  17:31
 * @Description:  cglib代理构造函数策略
 * @Version: 1.0
 */
public class CglibInstantiationStrategy implements InstantiationStrategy {
    @Override
    public Object instantiationBean(BeanDefinition beanDefinition, Constructor constructor, Object[] args) {
        Enhancer enhancer =new Enhancer();
        enhancer.setSuperclass(beanDefinition.getBeanClass());
        try {
            enhancer.setCallback(new NoOp() {
                @Override
                public int hashCode() {
                    return super.hashCode();
                }
            });
            if(constructor != null){
                return enhancer.create(constructor.getExceptionTypes(), args);
            }else {
                return enhancer.create();
            }
        }catch (Exception e){
            throw new RuntimeException("cglib instantiation strategy error", e);
        }
    }
}
