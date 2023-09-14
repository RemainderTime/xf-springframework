package bean;

import cn.xf.springframework.bean.pojo.BeanDeifition;
import cn.xf.springframework.bean.pojo.BeanReference;
import cn.xf.springframework.bean.pojo.PropertyValue;
import cn.xf.springframework.bean.pojo.PropertyValues;
import cn.xf.springframework.bean.support.DefaultListableBeanFactory;
import org.junit.Test;

/**
 * @author xiongfeng
 * @date 2023/9/7 14:45
 */

public class ApiTest {

    @Test
    public void beanTest() {

        // 1.初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        // 2.注册 bean
        BeanDeifition beanDefinition = new BeanDeifition(UserService.class);
        beanFactory.registerBeanDefinition("userService", beanDefinition);
        // 3.第一次获取 bean
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();
        // 4.第二次获取 bean from Singleton
        UserService userService_singleton = (UserService) beanFactory.getBean("userService");
        userService_singleton.queryUserInfo();
    }

    @Test
    public void testPropertyValue(){
        // 1.初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 2. bean.UserDao 注册
        beanFactory.registerBeanDefinition("userDao", new BeanDeifition(UserDao.class));

        // 3. bean.UserService 设置属性[uId、userDao]
        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("uId", "10001"));
        propertyValues.addPropertyValue(new PropertyValue("userDao",new BeanReference("userDao")));

        // 4. bean.UserService 注入bean
        BeanDeifition beanDefinition = new BeanDeifition(UserService.class, propertyValues);
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        // 5. bean.UserService 获取bean
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();
    }

}
