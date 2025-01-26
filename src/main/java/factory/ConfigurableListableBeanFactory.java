package factory;

import config.BeanDefinition;
import exceptions.BeansException;
import processor.BeanFactoryProcessor;

import java.util.Map;

/**
 * ClassName: ConfigurableListableBeanFactory
 * Package: factory
 * Description:
 * Author: gx
 * Creat: 2025/1/21 23:46
 * @author 11
 */
public interface ConfigurableListableBeanFactory extends AutowireCapableBeanFactory, ConfigurableBeanFactory, ListableFactory{
    public abstract BeanDefinition getBeanDefinition(String name);

    /**
     * 提前实例化所有单例实例
     *
     * @throws BeansException
     */
    void preInstantiateSingletons() throws BeansException;
}
