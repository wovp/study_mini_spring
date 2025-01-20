package strtegy;

import config.BeanDefinition;
import exceptions.BeansException;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * ClassName: SimpleInstantiationStrategy
 * Package: strtegy
 * Description:
 * Author: gx
 * Creat: 2025/1/21 2:19
 * @author 11
 */
public class SimpleInstantiationStrategy implements InstatiationStrategy {
    /**
     * 简单的bean实例化策略，根据bean的无参构造函数实例化对象
     *
     * @param beanDefinition
     * @return
     * @throws BeansException
     */
    @Override
    public Object instantiate(BeanDefinition beanDefinition) throws BeansException {
        Class beanClass = beanDefinition.getBeanClass();
        try {
            Constructor constructor = beanClass.getDeclaredConstructor();
            // 需要规避反射安全检测
            constructor.setAccessible(true);
            return constructor.newInstance();
        } catch (Exception e) {
            throw new BeansException("Failed to instantiate [" + beanClass.getName() + "]", e);
        }
    }
}
