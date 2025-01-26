package context;

/**
 * ClassName: ConfigurableApplicationContext
 * Package: context
 * Description:
 * Author: gx
 * Creat: 2025/1/26 22:54
 * @author 11
 */
public interface ConfigurableApplicationContext extends ApplicationContext{
    /**
     * 重新加载容器
     */
    void refresh();
}
