package xml;

import exceptions.BeansException;
import registry.BeanDefinitionRegistry;
import resource.Resource;
import resource.ResourceLoader;

/**
 * ClassName: BeanDefinitionReader
 * Package: xml
 * Description:
 * Author: gx
 * Creat: 2025/1/21 19:49
 * @author 11
 */
public interface BeanDefinitionReader {

    BeanDefinitionRegistry getRegistry();

    ResourceLoader getResourceLoader();

    void loadBeanDefinitions(Resource resource) throws BeansException;

    void loadBeanDefinitions(String location) throws BeansException;

    void loadBeanDefinitions(String[] locations) throws BeansException;
}
