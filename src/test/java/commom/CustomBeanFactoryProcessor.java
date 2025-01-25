package commom;

import config.BeanDefinition;
import config.PropertyValues;
import factory.BeanFactory;
import factory.ConfigurableBeanFactory;
import factory.ConfigurableListableBeanFactory;
import processor.BeanFactoryProcessor;

import java.util.List;
import java.util.Objects;

/**
 * ClassName: CustomBeanFactoryProcessor
 * Package: processor
 * Description:
 * Author: gx
 * Creat: 2025/1/26 3:29
 */
public class CustomBeanFactoryProcessor implements BeanFactoryProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) {
        BeanDefinition person = beanFactory.getBeanDefinition("person");
        List<PropertyValues.PropertyValue> propertyValueList = person.getPropertyValues().getPropertyValueList();
        for (PropertyValues.PropertyValue propertyValue: propertyValueList) {
            if (Objects.equals(propertyValue.getName(), "name")) {
                propertyValue.setObject("ivy");
            }
        }

    }
}
