/**
 * ClassName: HelloService
 * Package: PACKAGE_NAME
 * Description:
 * Author: gx
 * Creat: 2025/1/21 2:36
 */
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