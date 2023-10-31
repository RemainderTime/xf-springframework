package cn.xf.springframework.bean.pojo;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: xiongfeng
 * @CreateTime: 2023-09-11  14:20
 * @Description: TODO
 * @Version: 1.0
 */
public class PropertyValues {

    private final List<PropertyValue> propertyValues =new ArrayList<>();


    public void addPropertyValue(PropertyValue pv) {
        this.propertyValues.add(pv);
    }

    public PropertyValue[] getPropertyValues() {
        return this.propertyValues.toArray(new PropertyValue[0]);
    }

    public PropertyValue getPropertyValue(String propertyName) {
        for (PropertyValue pv : this.propertyValues) {
            if (pv.getName().equals(propertyName)) {
                return pv;
            }
        }
        return null;
    }

}
