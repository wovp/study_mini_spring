package factory;

import exceptions.BeansException;

/**
 * ClassName: AutowireCapableBeanFactory
 * Package: factory
 * Description:
 * Author: gx
 * Creat: 2025/1/21 23:48
 * @author 11
 */
public interface AutowireCapableBeanFactory extends BeanFactory{
    /**
     * 执行BeanPostProcessors的postProcessBeforeInitialization方法
     *
     * @param existingBean
     * @param beanName
     * @return
     * @throws BeansException
     */
    Object applyBeanPostProcessorsBeforeInitialization(Object existingBean, String beanName)
            throws BeansException;

    /**
     * 执行BeanPostProcessors的postProcessAfterInitialization方法
     *
     * @param existingBean
     * @param beanName
     * @return
     * @throws BeansException
     */
    Object applyBeanPostProcessorsAfterInitialization(Object existingBean, String beanName)
            throws BeansException;
}
