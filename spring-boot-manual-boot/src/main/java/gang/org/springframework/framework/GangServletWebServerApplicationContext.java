package gang.org.springframework.framework;

import gang.org.springframework.framework.context.GangAbstractApplicationContext;
import gang.org.springframework.framework.context.GangGenericWebApplicationContext;

/**
 * @author gang.chen
 * @description
 * @time 2021/6/11 12:44
 */
public class GangServletWebServerApplicationContext extends GangGenericWebApplicationContext {
    @Override
    public void refresh() {
        super.refresh();
    }
}
