package processor;

import exceptions.BeansException;

/**
 * ClassName: BeanPostProcessor
 * Package: processor
 * Description:
 * Author: gx
 * Creat: 2025/1/26 3:24
 */
public interface BeanPostProcessor {
    /**
     * 在bean执行初始化方法之前执行此方法
     */
    Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException;

    /**
     * 在bean执行初始化方法之后执行此方法
     */
    Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException;
}
