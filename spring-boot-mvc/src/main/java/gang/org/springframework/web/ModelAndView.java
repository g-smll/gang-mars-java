package gang.org.springframework.web;

/**
 * @author gang.chen
 * @description
 * @time 2021/6/1 12:53
 */
public class ModelAndView {

    private Object view;
    private String viewName;

    public ModelAndView(Object view, String viewName) {
        this.view = view;
        this.viewName = viewName;
    }

    public Object getView() {
        return this.view;
    }

    public String getViewName() {
        return this.viewName;
    }
}
