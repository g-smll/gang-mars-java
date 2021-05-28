package gang.org.springframework.servlet;

/**
 * @author gang.chen
 * @description
 * @time 2021/5/28 8:37
 */
public class DispatcherServlet extends FrameworkServlet {
    @Override
    protected void onRefresh() {
        initStrategies();
    }

    protected void initStrategies() {
        System.out.println("DispatcherServlet->initStrategies() #####初始化####");
    }
}
