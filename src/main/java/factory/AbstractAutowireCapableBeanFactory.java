package factory;

import config.BeanDefinition;
import config.PropertyValues;
import strtegy.InstatiationStrategy;
import strtegy.SimpleInstantiationStrategy;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

/**
 * ClassName: AbstractAutowireCapableBeanFactory
 * Package: factory
 * Description:
 * Author: gx
 * Creat: 2025/1/16 14:20
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory{
    private InstatiationStrategy instatiationStrategy = new SimpleInstantiationStrategy();
    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition) {
        return doCreateBean(beanName, beanDefinition);
    }

    private Object doCreateBean(String beanName, BeanDefinition beanDefinition) {
        Object beanObject = instatiationStrategy.instantiate(beanDefinition);
        // 实例化bean后，需要将bean放在single容器内，防止被多次创建
        addSingleton(beanName, beanObject);

        // 是否为无参构造
        if (!beanDefinition.isNullConstructor()) {
            // 通过反射注入属性
            injectFields(beanObject, beanDefinition);
        }
        return beanObject;
    }

    public InstatiationStrategy getInstatiationStrategy() {
        return instatiationStrategy;
    }

    public void setInstatiationStrategy(InstatiationStrategy instatiationStrategy) {
        this.instatiationStrategy = instatiationStrategy;
    }

    private void injectFields(Object beanObject, BeanDefinition beanDefinition) {
        Class<?> beanClass = beanObject.getClass();
        List<PropertyValues.PropertyValue> objectFieldValue = beanDefinition.getPropertyValues().getPropertyValueList();
        for (PropertyValues.PropertyValue propertyValue : objectFieldValue) {
            String fieldName = propertyValue.getName();
            Object value = propertyValue.getObject();
            try {
                Field field = beanClass.getDeclaredField(fieldName);
                field.setAccessible(true);
                field.set(beanObject, value);
            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
}
