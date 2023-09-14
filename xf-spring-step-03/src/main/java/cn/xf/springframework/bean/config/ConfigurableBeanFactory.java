package cn.xf.springframework.bean.config;

import cn.xf.springframework.bean.HierarchicalBeanFactory;

/**
 * @Author: xiongfeng
 * @CreateTime: 2023-09-14  18:03
 * @Description: TODO 扩展bean配置化子接口
 * @Version: 1.0
 */
public interface ConfigurableBeanFactory extends HierarchicalBeanFactory {

    String SCOPE_SINGLETON = "singleton";

    String SCOPE_PROTOTYPE = "prototype";

}
