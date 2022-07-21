package com.shixin.factory;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

public class BeanFactory {
    private static Map<String, Object> beanMap = new ConcurrentHashMap<>();
    private static final Properties properties;

    static {
        properties = new Properties();
        try {
            properties.load(BeanFactory.class.getClassLoader().getResourceAsStream("factory.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Object getBean(String beanName) {
        try {
            if (beanMap.containsKey(beanName)) {
                return beanMap.get(beanName);
            }
            synchronized (BeanFactory.class) {
                if (beanMap.containsKey(beanName)) {
                    return beanMap.get(beanName);
                }
                Object bean = Class.forName(properties.getProperty(beanName)).getDeclaredConstructor().newInstance();
                beanMap.put(beanName, bean);
                return beanMap.get(beanName);
            }
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | InvocationTargetException |
                 NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }
}