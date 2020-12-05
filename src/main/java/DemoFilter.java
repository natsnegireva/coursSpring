import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Date;

//-- Для создания фильтра необходимо создать класс, который реализует интерфейс javax.servlet.Filter.
//-- Чтобы этот класс был использован контейнером сервлетов как фильтр его нужно отметить
//-- аннотацией @WebFilter или прописать в файле web.xml.
@WebFilter(value = "/show_page", dispatcherTypes = {DispatcherType.REQUEST, DispatcherType.FORWARD})
public class DemoFilter implements Filter {
    private static Logger logger = LoggerFactory.getLogger(DemoFilter.class);

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest)servletRequest;
        logger.info(new Date() + " - " + httpServletRequest.getServletPath());
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void init(FilterConfig filterConfig) {
    }

    @Override
    public void destroy() {
    }
}