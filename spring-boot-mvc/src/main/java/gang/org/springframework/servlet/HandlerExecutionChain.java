package gang.org.springframework.servlet;

import gang.org.springframework.web.HandlerMethod;
import gang.org.springframework.web.ModelAndView;

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

    public ModelAndView handler(){
        return null;
    }


    public HandlerMethod getHandlerMethod() {
        return this.handlerMethod;
    }
}
