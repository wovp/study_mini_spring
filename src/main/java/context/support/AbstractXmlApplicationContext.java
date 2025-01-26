package context.support;

import context.AbstractApplicationContext;
import factory.DefaultListableBeanFactory;
import xml.XmlBeanDefinitionReader;

/**
 * ClassName: AbstractXmlApplicationContext
 * Package: context.support
 * Description:
 * Author: gx
 * Creat: 2025/1/26 23:46
 */
public abstract class AbstractXmlApplicationContext extends AbstractRefreshableApplicationContext {
    @Override
    protected void loadBeanDefinitions(DefaultListableBeanFactory beanFactory) {
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory, this);
        String[] configLocations = getConfigLocations();
        if (configLocations != null) {
            beanDefinitionReader.loadBeanDefinitions(configLocations);
        }
    }

    protected abstract String[] getConfigLocations();
}
