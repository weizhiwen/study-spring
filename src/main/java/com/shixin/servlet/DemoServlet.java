package com.shixin.servlet;

import com.shixin.factory.BeanFactory;
import com.shixin.service.DemoService;
import com.shixin.service.impl.DemoServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/demo")
public class DemoServlet extends HttpServlet {
    DemoService service = (DemoService) BeanFactory.getBean("demoService");

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println(service.findAll());
    }
}
