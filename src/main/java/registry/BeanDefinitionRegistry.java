package registry;

import config.BeanDefinition;

/**
 * ClassName: BeanDefinitionRegistery
 * Package: registry
 * Description:
 * Author: gx
 * Creat: 2025/1/16 14:36
 */
public interface BeanDefinitionRegistry {
    /**
     * 在注册表中注册beanDefinition
     * @param beanName
     * @param beanDefinition
     */
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);

    boolean containsBeanDefinition(String beanName);
}
