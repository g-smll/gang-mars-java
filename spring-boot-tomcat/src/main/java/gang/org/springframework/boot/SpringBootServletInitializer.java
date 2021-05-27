package gang.org.springframework.boot;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

/**
 * @author gang.chen
 * @description
 * @time 2021/5/27 9:17
 */
public class SpringBootServletInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        System.out.println("SpringBootServletInitializer->onStartup()");

    }
}
