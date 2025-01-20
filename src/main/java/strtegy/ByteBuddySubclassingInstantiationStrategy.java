package strtegy;

import config.BeanDefinition;
import exceptions.BeansException;
import net.bytebuddy.ByteBuddy;
import net.bytebuddy.implementation.FixedValue;
import net.bytebuddy.matcher.ElementMatchers;

import java.lang.reflect.InvocationTargetException;

/**
 * ClassName: ByteBuddySubclassingInstantiationStrategy
 * Package: strtegy
 * Description:
 * Author: gx
 * Creat: 2025/1/21 2:52
 */
public class ByteBuddySubclassingInstantiationStrategy implements InstatiationStrategy{
    @Override
    public Object instantiate(BeanDefinition beanDefinition) throws BeansException {
        // 留了个坑，这里的类加载顺序有问题
        Class<?> dynamicType = new ByteBuddy()
                .subclass(beanDefinition.getBeanClass())
                .make()
                .load(getClass().getClassLoader())
                .getLoaded();
        Object bean = null;
        try {

            bean = dynamicType.getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return bean;
    }
}
