package factory;

import config.BeanDefinition;

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
}
