package context.support;

import exceptions.BeansException;

/**
 * ClassName: ClassPathXmlApplicationContext
 * Package: context.support
 * Description:
 * Author: gx
 * Creat: 2025/1/26 23:53
 * @author 11
 */
public class ClassPathXmlApplicationContext extends AbstractXmlApplicationContext {

    private String[] configLocations;

    /**
     * 从xml文件加载BeanDefinition，并且自动刷新上下文
     *
     * @param configLocation xml配置文件
     * @throws BeansException 应用上下文创建失败
     */
    public ClassPathXmlApplicationContext(String configLocation) throws BeansException {
        this(new String[]{configLocation});
    }

    /**
     * 从xml文件加载BeanDefinition，并且自动刷新上下文
     *
     * @param configLocations xml配置文件
     * @throws BeansException 应用上下文创建失败
     */
    public ClassPathXmlApplicationContext(String[] configLocations) throws BeansException {
        this.configLocations = configLocations;
        refresh();
    }

    @Override
    protected String[] getConfigLocations() {
        return this.configLocations;
    }

}
