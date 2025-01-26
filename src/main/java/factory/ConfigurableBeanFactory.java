package factory;

import processor.BeanPostProcessor;
import registry.SingletonBeanRegistry;

/**
 * ClassName: ConfigurableBeanFactory
 * Package: factory
 * Description:
 * Author: gx
 * Creat: 2025/1/21 23:45
 * @author 11
 */
public interface ConfigurableBeanFactory extends SingletonBeanRegistry, HierarchicalBeanFactory {
    /**
     * @param beanPostProcessor
     */
    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);
}
