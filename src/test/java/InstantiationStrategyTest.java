import config.BeanDefinition;
import factory.DefaultListableBeanFactory;
import org.junit.Test;


/**
 * ClassName: InstantiationStrategyTest
 * Package: PACKAGE_NAME
 * Description:
 * Author: gx
 * Creat: 2025/1/21 2:36
 */
public class InstantiationStrategyTest {
    @Test
    public void InstantiationBeanTest(){
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        BeanDefinition beanDefinition = new BeanDefinition(HelloService.class);

        beanFactory.registerBeanDefinition("helloService", beanDefinition);
        beanFactory.registerBeanDefinition("helloService1", beanDefinition);

        // 第一次调用
        HelloService helloService = (HelloService) beanFactory.getBean("helloService");
        helloService.sayHello();

        // 第二次调用，使用bytebuddy实例化方法，自行测试
//        InstatiationStrategy cglibSubclassingInstantiationStrategy = new ByteBuddySubclassingInstantiationStrategy();
//        beanFactory.setInstatiationStrategy(cglibSubclassingInstantiationStrategy);
//        HelloService helloService1 = (HelloService) beanFactory.getBean("helloService1");
//        helloService1.sayHello();
    }

}
