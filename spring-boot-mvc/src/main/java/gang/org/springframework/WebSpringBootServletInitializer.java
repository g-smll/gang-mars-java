package gang.org.springframework;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

/**
 * @author gang.chen
 * @description
 * @time 2021/5/27 9:17
 */
public class WebSpringBootServletInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        System.out.println("SpringBootServletInitializer->onStartup()");

    }
}
