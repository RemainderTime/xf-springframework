package cn.xf.springframework.bean.pojo;

import java.util.Objects;

/**
 * @Author: xiongfeng
 * @CreateTime: 2023-09-11  14:19
 * @Description: TODO
 * @Version: 1.0
 */
public class PropertyValue {

    private String name;

    private Object value;

    public PropertyValue(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
