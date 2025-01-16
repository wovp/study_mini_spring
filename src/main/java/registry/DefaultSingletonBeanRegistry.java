package registry;

import config.BeanDefinition;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: DefaultSingletonBeanRegistry
 * Package: registry
 * Description: 注册器，将bean注册到bean工厂中
 * Author: gx
 * Creat: 2025/1/16 14:00
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry{

    private Map<String, Object> singletonObjects = new HashMap<>();

    @Override
    public Object getSingleton(String beanName) {
        return singletonObjects.get(beanName);
    }

    @Override
    public void addSingleton(String beanName, Object singletonObject) {
        singletonObjects.put(beanName, singletonObject);
    }
}
