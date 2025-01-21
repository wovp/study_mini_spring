package config;

/**
 * ClassName: BeanReference
 * Package: config
 * Description:
 * Author: gx
 * Creat: 2025/1/21 14:20
 * @author 11
 */
public class BeanReference {
    private String beanName;

    public String getBeanName() {
        return beanName;
    }

    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }

    public BeanReference(String beanName) {
        this.beanName = beanName;
    }
}
