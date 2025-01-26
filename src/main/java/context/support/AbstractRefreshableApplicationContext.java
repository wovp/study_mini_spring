package context.support;

import context.AbstractApplicationContext;
import exceptions.BeansException;
import factory.DefaultListableBeanFactory;

/**
 * ClassName: AbstractRefreshableApplicationContext
 * Package: context.support
 * Description:
 * Author: gx
 * Creat: 2025/1/26 23:38
 */
public abstract class AbstractRefreshableApplicationContext extends AbstractApplicationContext {
    private DefaultListableBeanFactory beanFactory;

    /**
     * 创建beanFactory并加载BeanDefinition
     *
     * @throws BeansException
     */

    @Override
    protected void refreshBeanFactory() throws BeansException {
        DefaultListableBeanFactory beanFactory = createBeanFactory();
        // 关键在这里，需要将definition填充到bean工厂中
        loadBeanDefinitions(beanFactory);
        this.beanFactory = beanFactory;
    }

    /**
     * 创建bean工厂
     *
     * @return
     */
    protected DefaultListableBeanFactory createBeanFactory() {
        return new DefaultListableBeanFactory();
    }

    /**
     * 加载BeanDefinition
     *
     * @param beanFactory
     * @throws BeansException
     */
    protected abstract void loadBeanDefinitions(DefaultListableBeanFactory beanFactory) throws BeansException;

    @Override
    public DefaultListableBeanFactory getBeanFactory() {
        return beanFactory;
    }
}
