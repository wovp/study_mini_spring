package factory;

import processor.BeanFactoryProcessor;
import processor.BeanPostProcessor;
import registry.SingletonBeanRegistry;

import java.util.Map;

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
