package config;

/**
 * ClassName: BeanDefinition
 * Package: config
 * Description:
 * Author: gx
 * Creat: 2025/1/16 12:46
 */
public class BeanDefinition {
    private Class beanClass;

    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }

    @Override
    public String toString() {
        return "BeanDefinition{" +
                "beanClass=" + beanClass +
                '}';
    }

    public BeanDefinition(Class beanClass) {
        this.beanClass = beanClass;
    }
}
