package strtegy;

import config.BeanDefinition;
import exceptions.BeansException;

/**
 * ClassName: InstatiationStrategy
 * Package: strtegy
 * Description:
 * Author: gx
 * Creat: 2025/1/21 2:17
 * @author 11
 */
public interface InstatiationStrategy {
    Object instantiate(BeanDefinition beanDefinition) throws BeansException;

}
