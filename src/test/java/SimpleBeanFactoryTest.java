import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * ClassName: SimpleBeanFactoryTest
 * Package: PACKAGE_NAME
 * Description:
 * Author: gx
 * Creat: 2025/1/16 12:33
 */
public class SimpleBeanFactoryTest {
    @Test
    public void testGetBean() throws Exception {
        BeanFactory beanFactory = new BeanFactory();
        beanFactory.registerBean("helloService", new HelloService());
        HelloService helloService = (HelloService) beanFactory.getBean("helloService");
        assertThat(helloService).isNotNull();
        assertThat(helloService.sayHello()).isEqualTo("hello");
    }

    class HelloService {
        public String sayHello() {
            System.out.println("hello");
            return "hello";
        }
    }
}