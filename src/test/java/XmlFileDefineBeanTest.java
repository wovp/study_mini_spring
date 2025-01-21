import factory.DefaultListableBeanFactory;
import org.junit.Test;
import xml.XmlBeanDefinitionReader;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * ClassName: XmlFileDefineBeanTest
 * Package: PACKAGE_NAME
 * Description:
 * Author: gx
 * Creat: 2025/1/21 23:58
 */
public class XmlFileDefineBeanTest {
    @Test
    public void testXmlFile() throws Exception {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
        beanDefinitionReader.loadBeanDefinitions("classpath:spring.xml");

        Person person = (Person) beanFactory.getBean("person");
        System.out.println(person);
        assertThat(person.getName()).isEqualTo("derek");
        assertThat(person.getCar().getBrand()).isEqualTo("porsche");

        Car car = (Car) beanFactory.getBean("car");
        System.out.println(car);
        assertThat(car.getBrand()).isEqualTo("porsche");
    }
}
