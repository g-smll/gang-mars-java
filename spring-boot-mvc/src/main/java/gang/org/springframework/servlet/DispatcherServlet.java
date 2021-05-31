package gang.org.springframework.servlet;

import gang.org.springframework.web.RequestMappingHandlerMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author gang.chen
 * @description DispatcherServlet
 * @time 2021/5/28 8:37
 */
public class DispatcherServlet extends FrameworkServlet {

    private RequestMappingHandlerMapping requestMappingHandlerMapping;

    public DispatcherServlet() {
        requestMappingHandlerMapping = new RequestMappingHandlerMapping();
    }

    @Override
    protected void onRefresh() {
        initStrategies();
    }

    protected void initStrategies() {
        System.out.println("DispatcherServlet->initStrategies() #####初始化####");
        requestMappingHandlerMapping.initHandlerMappings();
    }

    /*@Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("DispatcherServlet->service->running #####接收请求####");
    }*/

    @Override
    protected void doService(HttpServletRequest req, HttpServletResponse resp) {
        doDispatch(req,resp);
    }

    private void doDispatch(HttpServletRequest req, HttpServletResponse resp){}
}
