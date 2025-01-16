package exceptions;

/**
 * ClassName: exceptions.BeansException
 * Package: PACKAGE_NAME
 * Description:
 * Author: gx
 * Creat: 2025/1/16 14:04
 */
public class BeansException extends RuntimeException {

    public BeansException(String msg) {
        super(msg);
    }

    public BeansException(String msg, Throwable cause) {
        super(msg, cause);
    }
}