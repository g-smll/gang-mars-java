package gang.org.springframework.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

/**
 * @author gang.chen
 * @description
 * @time 2021/5/28 8:37
 */
public class HttpServletBean extends HttpServlet {

    @Override
    public void init() throws ServletException {
        
        initServletBean();
    }

    protected void initServletBean() {
    }
}
