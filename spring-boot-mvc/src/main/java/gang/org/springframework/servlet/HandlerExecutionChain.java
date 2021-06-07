package gang.org.springframework.servlet;

import gang.org.springframework.web.HandlerMethod;
import gang.org.springframework.web.ModelAndView;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author gang.chen
 * @description
 * @time 2021/6/1 8:23
 */
public class HandlerExecutionChain {

    private HandlerMethod handlerMethod;

    public HandlerExecutionChain(HandlerMethod handlerMethod) {
        this.handlerMethod = handlerMethod;
    }

    public HandlerMethod getHandlerMethod() {
        return this.handlerMethod;
    }

    public ModelAndView handler(){
        Method method = handlerMethod.getMethod();
        try {
            Object obj = method.invoke(handlerMethod.getBean(), null);
            return new ModelAndView(obj,obj.toString());
        }
        catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }



}
