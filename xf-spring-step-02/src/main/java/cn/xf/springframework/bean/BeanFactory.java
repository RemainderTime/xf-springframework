package cn.xf.springframework.bean;

import cn.xf.springframework.bean.pojo.BeanDeifition;

/**
 * @author xiongfeng
 * @date 2023/9/6 18:03
 */

public interface BeanFactory {

    public Object getBean(String name);
}
