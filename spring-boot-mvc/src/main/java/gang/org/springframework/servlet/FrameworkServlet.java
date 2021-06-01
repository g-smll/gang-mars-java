package gang.org.springframework.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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

    @Override
    protected void doService(HttpServletRequest req, HttpServletResponse resp) {
    }
}
