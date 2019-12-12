package com.spiderman.app;


import com.spiderman.app.web.SpringServlet;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;
import java.util.Set;

public class SpiderInitializer implements ServletContainerInitializer {
    @Override
    public void onStartup(Set<Class<?>> c, ServletContext ctx) {
        System.out.println("执行SpiderInitializer");
        ServletRegistration.Dynamic registration=ctx.addServlet("spider",new SpringServlet());
        registration.addMapping("/spider");
    }
}
