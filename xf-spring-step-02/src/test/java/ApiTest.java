import cn.xf.springframework.bean.pojo.BeanDeifition;
import cn.xf.springframework.bean.support.DefaultListableBeanFactory;

/**
 * @author xiongfeng
 * @date 2023/9/7 14:45
 */

public class ApiTest {

    public static void main(String[] args) {

        // 1.初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        // 2.注册 bean
        BeanDeifition beanDefinition = new BeanDeifition(UserService.class);
        beanFactory.registerBeanDefinition("userService", beanDefinition);
        // 3.第一次获取 bean
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.getUserInfo();
        // 4.第二次获取 bean from Singleton
        UserService userService_singleton = (UserService) beanFactory.getBean("userService");
        userService_singleton.getUserInfo();
    }

}
