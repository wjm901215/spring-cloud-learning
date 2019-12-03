package com.luban.app;

import com.luban.app.web.SpringServlet;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;
import java.util.Set;
public class LubanInitializer implements ServletContainerInitializer {
    @Override
    public void onStartup(Set<Class<?>> c, ServletContext ctx) {
        ServletRegistration.Dynamic registration=ctx.addServlet("xx",new SpringServlet());
        registration.addMapping("/");
    }
}
