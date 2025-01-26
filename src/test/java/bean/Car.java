package bean;

/**
 * ClassName: bean.Car
 * Package: PACKAGE_NAME
 * Description:
 * Author: gx
 * Creat: 2025/1/21 14:26
 */
public class Car {
    private String brand;

    public Car(String brand) {
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Car() {
    }

    @Override
    public String toString() {
        return "bean.Car{" +
                "brand='" + brand + '\'' +
                '}';
    }
}
