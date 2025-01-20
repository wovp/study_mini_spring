package strtegy;

import config.BeanDefinition;
import exceptions.BeansException;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;

/**
 * ClassName: CglibSubclassingInstantiationStrategy
 * Package: strtegy
 * Description:
 * Author: gx
 * Creat: 2025/1/21 2:22
 */
public class CglibSubclassingInstantiationStrategy implements InstatiationStrategy{
    @Override
    public Object instantiate(BeanDefinition beanDefinition) throws BeansException {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(beanDefinition.getBeanClass());
        enhancer.setCallback((MethodInterceptor) (obj, method, argsTemp, proxy) -> proxy.invokeSuper(obj,argsTemp));
        return enhancer.create();
    }
}
