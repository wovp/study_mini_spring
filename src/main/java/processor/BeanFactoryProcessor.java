package processor;

import factory.BeanFactory;
import factory.ConfigurableBeanFactory;
import factory.ConfigurableListableBeanFactory;

/**
 * ClassName: BeanFactoryProcessor
 * Package: processor
 * Description:
 * Author: gx
 * Creat: 2025/1/26 3:25
 */
public interface BeanFactoryProcessor {
    /**
     * 在bean被实例化之前修改BeanDefinition
     * @param beanFactory
     */
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory);
}
