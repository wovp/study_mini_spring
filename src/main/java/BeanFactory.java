import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: BeanFactory
 * Package: PACKAGE_NAME
 * Description:
 * Author: gx
 * Creat: 2025/1/16 12:32
 * @author 11
 */
public class BeanFactory {
    private Map<String, Object> beanMap = new HashMap<>();

    public void registerBean(String name, Object bean) {
        beanMap.put(name, bean);
    }

    public Object getBean(String name) {
        return beanMap.get(name);
    }
}