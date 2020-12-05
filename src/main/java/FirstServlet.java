
//-- можно использовать аннотацию @WebServlet(name = "BasicServlet", urlPatterns = "/basic_servlet")
//-- import javax.servlet.annotation.WebServlet;
//-- привязка к URL сделана в файле web.xml

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//-- Чтобы создать сервлет его надо унаследовать от  HttpServlet
public class FirstServlet extends HttpServlet {

    private static Logger logger = LoggerFactory.getLogger(FirstServlet.class);

    //-- обработка всех Get запросов
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        logger.info("Log: GET");
        resp.getWriter().printf("<html><body><h1>New GET request</h1></body></html>");
    }

    //-- обработка всех Post запросов
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        logger.debug("Log: POST");
        resp.getWriter().printf("<html><body><h1>New POST request</h1></body></html>");
    }

    @Override
    public void destroy() {
        logger.debug("Destroy");
    }

    @Override
    public void init() {
        logger.debug("Init");
    }
}