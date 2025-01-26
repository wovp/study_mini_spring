package factory;

import cn.hutool.core.bean.OptionalBean;
import config.BeanDefinition;
import config.BeanReference;
import config.PropertyValues;
import exceptions.BeansException;
import processor.BeanPostProcessor;
import strtegy.InstatiationStrategy;
import strtegy.SimpleInstantiationStrategy;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

/**
 * ClassName: AbstractAutowireCapableBeanFactory
 * Package: factory
 * Description:
 * Author: gx
 * Creat: 2025/1/16 14:20
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory implements AutowireCapableBeanFactory{
    private InstatiationStrategy instatiationStrategy = new SimpleInstantiationStrategy();
    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition) {
        return doCreateBean(beanName, beanDefinition);
    }

    private Object doCreateBean(String beanName, BeanDefinition beanDefinition) {
        Object beanObject = instatiationStrategy.instantiate(beanDefinition);
        // 是否为无参构造
        if (!beanDefinition.isNullConstructor()) {
            // 通过反射注入属性
            injectFields(beanObject, beanDefinition);
        }
        beanObject = initializeBean(beanName, beanObject, beanDefinition);
        // 实例化bean后，需要将bean放在single容器内，防止被多次创建
        addSingleton(beanName, beanObject);
        return beanObject;
    }

    public InstatiationStrategy getInstatiationStrategy() {
        return instatiationStrategy;
    }

    public void setInstatiationStrategy(InstatiationStrategy instatiationStrategy) {
        this.instatiationStrategy = instatiationStrategy;
    }

    private void injectFields(Object beanObject, BeanDefinition beanDefinition) {
        Class<?> beanClass = beanObject.getClass();
        List<PropertyValues.PropertyValue> objectFieldValue = beanDefinition.getPropertyValues().getPropertyValueList();
        for (PropertyValues.PropertyValue propertyValue : objectFieldValue) {
            String fieldName = propertyValue.getName();
            Object value = propertyValue.getObject();
            if (value instanceof BeanReference beanReference) {
                value = getBean(beanReference.getBeanName());
            }
            try {
                Field field = beanClass.getDeclaredField(fieldName);
                field.setAccessible(true);
                field.set(beanObject, value);
            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    private Object initializeBean(String beanName, Object bean, BeanDefinition beanDefinition) {
        Object wrapBean = applyBeanPostProcessorsBeforeInitialization(bean, beanName);

        invokeInitMethods(beanName, bean, beanDefinition);

        wrapBean = applyBeanPostProcessorsAfterInitialization(bean, beanName);
        return wrapBean;
    }

    @Override
    public Object applyBeanPostProcessorsBeforeInitialization(Object existingBean, String beanName) throws BeansException {
        for (BeanPostProcessor beanPostProcessor : getBeanPostProcessors()) {
            beanPostProcessor.postProcessBeforeInitialization(existingBean, beanName);
        }
        return existingBean;
    }

    @Override
    public Object applyBeanPostProcessorsAfterInitialization(Object existingBean, String beanName)
            throws BeansException {

        Object result = existingBean;
        for (BeanPostProcessor processor : getBeanPostProcessors()) {
            Object current = processor.postProcessAfterInitialization(result, beanName);
            if (current == null) {
                return result;
            }
            result = current;
        }
        return result;
    }

    /**
     * 执行bean的初始化方法
     *
     * @param beanName
     * @param bean
     * @param beanDefinition
     * @throws Throwable
     */
    protected void invokeInitMethods(String beanName, Object bean, BeanDefinition beanDefinition) {
        //TODO 后面会实现
        System.out.println("执行bean[" + beanName + "]的初始化方法");
    }
}
