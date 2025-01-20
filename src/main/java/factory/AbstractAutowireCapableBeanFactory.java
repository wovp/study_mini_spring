package factory;

import config.BeanDefinition;
import strtegy.InstatiationStrategy;
import strtegy.SimpleInstantiationStrategy;

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
    private InstatiationStrategy instatiationStrategy = new SimpleInstantiationStrategy();
    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition) {
        return doCreateBean(beanName, beanDefinition);
    }

    private Object doCreateBean(String beanName, BeanDefinition beanDefinition) {
        Object beanObject = instatiationStrategy.instantiate(beanDefinition);
        // 实例化bean后，需要将bean放在single容器内，防止被多次创建
        addSingleton(beanName, beanObject);
        return beanObject;
    }

    public InstatiationStrategy getInstatiationStrategy() {
        return instatiationStrategy;
    }

    public void setInstatiationStrategy(InstatiationStrategy instatiationStrategy) {
        this.instatiationStrategy = instatiationStrategy;
    }
}
