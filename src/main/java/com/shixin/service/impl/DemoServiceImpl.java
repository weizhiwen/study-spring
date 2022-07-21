package com.shixin.service.impl;

import com.shixin.factory.BeanFactory;
import com.shixin.dao.DemoDao;
import com.shixin.service.DemoService;

import java.util.List;

public class DemoServiceImpl implements DemoService {
    DemoDao dao = (DemoDao) BeanFactory.getBean("demoDao");

    @Override
    public List<String> findAll() {
        return dao.findAll();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(BeanFactory.getBean("demoDao"));
        }
    }
}
