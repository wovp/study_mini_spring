package factory;

import config.BeanDefinition;
import registry.BeanDefinitionRegistry;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: DefaultListableBeanFactory
 * Package: factory
 * Description:
 * Author: gx
 * Creat: 2025/1/16 14:39
 */
public class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory implements BeanDefinitionRegistry, ConfigurableListableBeanFactory {
    private Map<String, BeanDefinition> beanDefinitionMap = new HashMap<>();


    @Override
    public BeanDefinition getBeanDefinition(String name) {
        return beanDefinitionMap.get(name);
    }

    @Override
    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(beanName, beanDefinition);
    }

    @Override
    public boolean containsBeanDefinition(String beanName) {
        return false;
    }
}
