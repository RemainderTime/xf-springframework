import cn.xf.springframework.BeanDefinition;
import cn.xf.springframework.BeanFactory;

/**
 * @author xiongfeng
 * @date 2023/9/1 14:55
 */

public class UserServiceTest {

    /**
     * 什么是javabean：所有遵循一定编程原则的Java类都可以被称作JavaBean
     *
     * Java Bean是基于Java的组件模型，由属性、方法和事件3部分组成。在该模型中，JavaBean可以被修改或与其他组件结合以生成新组件或完整的程序。
     * 它是一种Java类，通过封装成为具有某种功能或者处理某个业务的对象。因此，也可以通过嵌在JSP页面内的Java代码访问Bean及其属性。
     *
     * Bean的含义是可重复使用的Java组件。所谓组件就是一个由可以自行进行内部管理的一个或几个类所组成、外界不了解其内部信息和运行方式的群体。使用它的对象只能通过接口来操作。
     * @param args
     */

    public static void main(String[] args) {
        //初始化bean
        BeanDefinition beanDefinition =new BeanDefinition(new UserService());
        //注册bean
        BeanFactory beanFactory =new BeanFactory();
        beanFactory.registerBeanDefinition("userService", beanDefinition);
        //获取bean
        UserService userService = (UserService) beanFactory.getName("userService");
        userService.getUserInfo();
    }
}
