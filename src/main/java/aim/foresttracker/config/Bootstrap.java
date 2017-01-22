package aim.foresttracker.config;

import org.springframework.core.annotation.Order;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 *
 */
@Order(1)
public class Bootstrap implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {

        AnnotationConfigWebApplicationContext rootContext =
                new AnnotationConfigWebApplicationContext();
        rootContext.register(RootContextConfiguration.class);
        servletContext.addListener(new ContextLoaderListener(rootContext));

        AnnotationConfigWebApplicationContext dispatcherContext =
                new AnnotationConfigWebApplicationContext();
        dispatcherContext.register(ServletContextConfiguration.class);
        ServletRegistration.Dynamic dispatcher =
                servletContext.addServlet("dispatcher", new DispatcherServlet(dispatcherContext));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/rest/*");
    }
}
