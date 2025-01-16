import config.BeanDefinition;
import factory.DefaultListableBeanFactory;
import org.junit.Test;

/**
 * ClassName: BeanDefinitionAndBeanDefinitionRegistryTest
 * Package: PACKAGE_NAME
 * Description:
 * Author: gx
 * Creat: 2025/1/16 14:42
 */
public class BeanDefinitionAndBeanDefinitionRegistryTest {

    @Test
    public void testBeanFactory() throws Exception {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        BeanDefinition beanDefinition = new BeanDefinition(HelloService.class);
        beanFactory.registerBeanDefinition("helloService", beanDefinition);

        // 第一次调用
        HelloService helloService = (HelloService) beanFactory.getBean("helloService");
        helloService.sayHello();

        // 第二次调用
        HelloService helloService1 = (HelloService) beanFactory.getBean("helloService");
        helloService1.sayHello();
    }
}

class HelloService {
    private int count;
    public HelloService(){
        count = 0;
    }
    public String sayHello() {
        count += 1;
        System.out.println("hello, count = " + count);
        return "hello";
    }
}
