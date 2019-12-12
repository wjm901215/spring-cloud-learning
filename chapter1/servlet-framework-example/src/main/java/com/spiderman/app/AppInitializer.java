package com.spiderman.app;



import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.annotation.HandlesTypes;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@HandlesTypes({Page.class})
public class AppInitializer implements ServletContainerInitializer {
    @Override
    public void onStartup (Set<Class<?>> pageClasses, ServletContext ctx)
              throws ServletException {
        List<Page> pages = new ArrayList<>();
        if (pageClasses != null) {
            for (Class<?> pageClass : pageClasses) {
                if (!pageClass.isInterface() &&
                          !Modifier.isAbstract(pageClass.getModifiers())) {
                    try {
                        Page page = (Page) pageClass.newInstance();
                        pages.add(page);
                    } catch (Throwable ex) {
                        throw new ServletException(
                                  "Failed to instantiate WebApplicationInitializer" +
                                            " class", ex);
                    }
                }
            }
        }
        if (pages.size() > 0) {
            ctx.setAttribute("pages", pages);
            ServletRegistration.Dynamic servletRegistration = ctx.addServlet("appController",
                                                                             AppController.class);
            pages.forEach(p -> {
                servletRegistration.addMapping(p.getPath());
            });
        }
    }
}