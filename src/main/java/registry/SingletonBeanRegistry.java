package registry;

import config.BeanDefinition;

/**
 * ClassName: SingletonBeanRegistry
 * Package: registry
 * Description: 单例bean的注册器
 * Author: gx
 * Creat: 2025/1/16 13:58
 * @author 11
 */
public interface SingletonBeanRegistry {

    // 暂时没有搞明白，注册表应该提供注册功能和获取功能，也就是应该把register方法放在这里
    Object getSingleton(String beanName);

    /**
     * 改变了继承结构，是我私自加上去的
     * @param beanName
     * @param singletonObject
     */
    void addSingleton(String beanName, Object singletonObject);

}
