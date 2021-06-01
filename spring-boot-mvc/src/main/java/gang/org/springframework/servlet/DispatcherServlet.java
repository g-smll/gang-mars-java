package gang.org.springframework.servlet;

import gang.org.springframework.web.HandlerMethod;
import gang.org.springframework.web.RequestMappingHandlerMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

    @Override
    protected void doService(HttpServletRequest req, HttpServletResponse resp) {
        doDispatch(req,resp);
    }

    private void doDispatch(HttpServletRequest req, HttpServletResponse resp){
        System.out.println("DispatcherServlet->doDispatch()->接收请求");
        String url = req.getRequestURI();
        HandlerExecutionChain handler = getHandler(url);
        if (handler !=null) {

        }
    }

    private HandlerExecutionChain getHandler(String url){
        HandlerMethod handlerMethod = requestMappingHandlerMapping.getHandlerMethod(url);
        if (handlerMethod ==null) {
            return null;
        }
        return new HandlerExecutionChain(handlerMethod);
    }
}
