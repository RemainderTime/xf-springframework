package cn.xf.springframework.bean.pojo;

/**
 * @Author: xiongfeng
 * @CreateTime: 2023-09-11  14:17
 * @Description: TODO
 * @Version: 1.0
 */
public class BeanReference {

    private String beanName;

    public BeanReference(String beanName) {
        this.beanName = beanName;
    }

    public String getBeanName() {
        return beanName;
    }
}
