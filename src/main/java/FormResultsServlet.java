import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "FormResultsServlet", urlPatterns = "/formResults.html")
public class FormResultsServlet extends HttpServlet {
    // http://localhost:8080/firstapp/formResults.html?info=Milk&price=100
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html");

        String infoParam = req.getParameter("info = price");

        out.println("<html><body><h1>" + infoParam + "</h1></body></html>");
        out.close();
    }
}