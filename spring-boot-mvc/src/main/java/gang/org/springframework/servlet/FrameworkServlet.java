package gang.org.springframework.servlet;

/**
 * @author gang.chen
 * @description
 * @time 2021/5/28 8:37
 */
public class FrameworkServlet extends HttpServletBean {
    @Override
    protected void initServletBean() {
        
        onRefresh();
    }

    protected void onRefresh() {
    }
}
