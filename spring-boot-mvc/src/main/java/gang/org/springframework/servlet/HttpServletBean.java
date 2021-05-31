package gang.org.springframework.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doService(req,resp);
    }

    protected void doService(HttpServletRequest req, HttpServletResponse resp) {
    }


}
