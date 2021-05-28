package gang.org.springframework;

import gang.org.springframework.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * @author gang.chen
 * @description
 * @time 2021/5/27 9:17
 */
public class WebSpringBootServletInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        System.out.println("SpringBootServletInitializer->onStartup()");

        ServletRegistration.Dynamic dispatcherServlet = servletContext.addServlet("dispatcherServlet", new DispatcherServlet());

        dispatcherServlet.addMapping("/*");

        dispatcherServlet.setLoadOnStartup(1);
    }
}
