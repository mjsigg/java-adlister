import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CounterServlet", urlPatterns = "/count")

public class CounterServlet extends HttpServlet {

    private int count;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String reset = request.getParameter("reset");

        if(reset == null) {
            count++;
        }else {
            count = 0;
        }

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h1> The page count is: " + count + "</h1>");

    }

}
