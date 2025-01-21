package config;

import java.util.*;

/**
 * ClassName: PropertyValues
 * Package: config
 * Description:
 * Author: gx
 * Creat: 2025/1/21 13:21
 * @author 11
 */
public class PropertyValues {
    private List<PropertyValue> propertyValueList = new ArrayList<>();
    public void addPropertyValue(PropertyValue propertyValue) {
        propertyValueList.add(propertyValue);
    }

    public List<PropertyValue> getPropertyValueList() {
        return propertyValueList;
    }

    public void setPropertyValueList(List<PropertyValue> propertyValueList) {
        this.propertyValueList = propertyValueList;
    }

    public boolean isEmpty() {
        return propertyValueList.isEmpty();
    }

    public static class PropertyValue {
        private String name;
        private Object object;

        public PropertyValue(String name, Object object) {
            this.name = name;
            this.object = object;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Object getObject() {
            return object;
        }

        public void setObject(Object object) {
            this.object = object;
        }
    }
}
