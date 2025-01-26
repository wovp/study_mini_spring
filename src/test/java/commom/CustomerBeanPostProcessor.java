package commom;

import bean.Car;
import exceptions.BeansException;
import processor.BeanPostProcessor;

import java.util.Objects;

/**
 * ClassName: CustomerBeanPostProcessor
 * Package: commom
 * Description:
 * Author: gx
 * Creat: 2025/1/26 14:43
 */
public class CustomerBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (Objects.equals(beanName, "car")) {
            ((Car) bean).setBrand("lamborghini");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return null;
    }
}
