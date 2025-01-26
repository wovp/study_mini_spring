package context;

import factory.HierarchicalBeanFactory;
import factory.ListableFactory;
import resource.ResourceLoader;

/**
 * ClassName: ApplicationContext
 * Package: context
 * Description:
 * Author: gx
 * Creat: 2025/1/26 22:53
 * @author 11
 */
public interface ApplicationContext extends ListableFactory, HierarchicalBeanFactory, ResourceLoader {
}
