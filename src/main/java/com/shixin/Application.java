package com.shixin;

import com.shixin.bean.color.Color;
import com.shixin.bean.person.Cat;
import com.shixin.bean.person.Dog;
import com.shixin.bean.person.Person;
import com.shixin.dao.DemoDao;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;
import java.util.stream.Stream;

public class Application {
    public static void main(String[] args) {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("bean.xml");
        System.out.println(beanFactory.getBean("person"));
        System.out.println(beanFactory.getBean(Person.class));
        System.out.println(beanFactory.getBean("com.shixin.bean.person.Dog"));
        System.out.println(beanFactory.getBean(Dog.class));

        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        // 获取DemoDao类型的Bean
        Map<String, DemoDao> demoDaoBeans = context.getBeansOfType(DemoDao.class);
        demoDaoBeans.forEach((beanName, bean)-> {
            System.out.println(beanName + "#findAll(): " + bean.findAll());
        });
        // 获取带有Color注解的Bean
        Map<String, Object> colorBeans = context.getBeansWithAnnotation(Color.class);
        colorBeans.forEach((beanName, bean)->{
            System.out.println(beanName + ": " + bean.toString());
        });
        // 获取所有定义的Bean名称
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        Stream.of(beanDefinitionNames).forEach(System.out::println);
        // 获取未定义的Bean
        ObjectProvider<Cat> catProvider = context.getBeanProvider(Cat.class);
        // NoSuchBeanDefinitionException 抛出
//        System.out.println(catProvider.getObject());
        catProvider.ifAvailable(System.out::println);
        // 没有改Bean就创建一个，不会抛出异常
        System.out.println(catProvider.getIfAvailable(Cat::new));
    }
}
