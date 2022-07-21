package com.shixin;

import com.shixin.bean.Person;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {
    public static void main(String[] args) {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("bean.xml");
        Person person = (Person)beanFactory.getBean("person");
        System.out.println(person);
    }
}
