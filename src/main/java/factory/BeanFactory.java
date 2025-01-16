package factory;

import exceptions.BeansException;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: factory.BeanFactory
 * Package: PACKAGE_NAME
 * Description:
 * Author: gx
 * Creat: 2025/1/16 12:32
 * @author 11
 */
public interface BeanFactory {
    /**
     * 获取bean
     *
     * @param name
     * @return
     * @throws BeansException bean不存在时
     */
    Object getBean(String name) throws BeansException;
}