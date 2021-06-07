package gang.org.springframework.servlet;

import gang.org.springframework.web.HandlerMethod;
import gang.org.springframework.web.ModelAndView;
import gang.org.springframework.web.RequestMappingHandlerMapping;

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

    @Override
    protected void doService(HttpServletRequest req, HttpServletResponse resp) {
        doDispatch(req,resp);
    }

    private void doDispatch(HttpServletRequest req, HttpServletResponse resp){
        System.out.println("DispatcherServlet->doDispatch()->接收请求");
        String url = req.getRequestURI();
        HandlerExecutionChain handler = getHandler(url);
        if (handler ==null) {
            System.out.println("DispatcherServlet->doDispatch()->404异常");
            return;
        }

        ModelAndView mv = handler.handler();
        
        render(mv,req,resp);
    }

    private void render(ModelAndView modelAndView,HttpServletRequest req, HttpServletResponse resp) {
        String viewName = modelAndView.getViewName();
        try {
            resp.getOutputStream().write(viewName.getBytes());
        }
        catch (IOException e) {
            e.printStackTrace();
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
