package factory;

import exceptions.BeansException;

import java.util.Map;

/**
 * ClassName: ListableFactory
 * Package: factory
 * Description:
 * Author: gx
 * Creat: 2025/1/21 23:43
 * @author 11
 */
public interface ListableFactory extends BeanFactory{
    /**
     * 返回指定类型的所有实例
     *
     * @param type
     * @param <T>
     * @return
     * @throws BeansException
     */
    <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException;

    /**
     * 返回定义的所有bean的名称
     *
     * @return
     */
    String[] getBeanDefinitionNames();
}
