package factory;

import config.BeanDefinition;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * ClassName: AbstractAutowireCapableBeanFactory
 * Package: factory
 * Description:
 * Author: gx
 * Creat: 2025/1/16 14:20
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory{

    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition) {
        return doCreateBean(beanName, beanDefinition);
    }

    private Object doCreateBean(String beanName, BeanDefinition beanDefinition) {
        Class beanClass = beanDefinition.getBeanClass();
        Object bean = null;
        // 真正实例化bean的地方
        try {
            // 获取无参构造函数
            Constructor<?> constructor = beanClass.getDeclaredConstructor();
            // 需要规避反射安全检测
            constructor.setAccessible(true);
            bean = constructor.newInstance();
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }
        // 实例化bean后，需要将bean放在single容器内，防止被多次创建
        addSingleton(beanName, bean);
        return bean;
    }
}
