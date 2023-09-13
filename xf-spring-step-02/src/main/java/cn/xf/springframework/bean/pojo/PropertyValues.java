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

    private List<PropertyValue> propertyValues =new ArrayList<>();


    public void addPropertyValue(PropertyValue pv){
        this.propertyValues.add(pv);
    }

    private PropertyValue getPropertyValue(String propertyName){
        for (PropertyValue propertyValue : this.propertyValues) {
            if(propertyValue.getName().equals(propertyValue)){
                return propertyValue;
            }
        }
        return null;
    }


    public List<PropertyValue> getPropertyValues() {
        return propertyValues;
    }

}
