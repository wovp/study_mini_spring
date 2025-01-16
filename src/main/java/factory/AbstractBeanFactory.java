package factory;

import config.BeanDefinition;
import exceptions.BeansException;
import registry.DefaultSingletonBeanRegistry;

import java.util.Map;

/**
 * ClassName: AbstractBeanFactory
 * Package: factory
 * Description:
 * Author: gx
 * Creat: 2025/1/16 14:05
 * @author 11
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {
    @Override
    public Object getBean(String name) throws BeansException {
        // 单例保证
        Object bean = super.getSingleton(name);

        // 已经实例化过了
        if (bean != null) {
            return bean;
        }

        // 没有被实例化，需要创建beanDefinition
        BeanDefinition beanDefinition = getBeanDefinition(name);
        return createBean(name, beanDefinition);
    }

    // 留给不同的实现类去实现
    protected abstract BeanDefinition getBeanDefinition(String name);

    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition);
}
